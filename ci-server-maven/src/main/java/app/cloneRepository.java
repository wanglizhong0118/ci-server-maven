package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class cloneRepository {

    /**
     * Clone a Github repository using specified URL to local file system.
     * 
     * @param githubURL
     *            the URL link to the github repository in https
     * @param localtmpPath
     *            the local temporary directory to store the cloned repository
     * @param logFilePath
     *            the local temporary file to log the cloned process
     * @throws IOException
     *             any exception thrown during the clone process
     */
    public static void init(String githubURL, File localtmpPath, String logFilePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(logFilePath, true));
            PrintWriter outwriter = new PrintWriter(bw);

            try {
                outwriter.println("=============================================================================");
                outwriter.println("Reuqest Time is: " + LocalDateTime.now());
                outwriter.println("Downloading project ......");
                outwriter.println("Source Github project: " + githubURL);
                long startTime = System.currentTimeMillis();
                Git git = Git.cloneRepository().setURI(githubURL).setDirectory(localtmpPath)
                        .setBranch("refs/heads/master").call();
                git.close();
                long endTime = System.currentTimeMillis();
                long timeToClone = endTime - startTime;
                outwriter.println("Clone Done in " + timeToClone + " ms");
                outwriter.println();
                outwriter.println("=============================================================================");
                outwriter.println();
                outwriter.close();
            } catch (GitAPIException e) {
                System.out.println("Clone Failed ");
                e.printStackTrace();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
