package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;

public class Utils {

    /**
     * Using Java inbuilt random operation to generate directory
     * 
     * @param tempDir
     *            the parent directory
     * @return new created random directory
     * @throws IOException
     *             directory creation failed
     */
    public static File create_temp_path(String tempDir) throws IOException {
        File tempFile = new File(tempDir);
        File randomTempFile = File.createTempFile("TestCloneGitRepo", "", tempFile);
        if (!randomTempFile.delete()) {
            throw new IOException("Could not delete temporary file " + randomTempFile);
        }
        return randomTempFile;
    }

    /**
     * Delete a directory and a file
     * 
     * @param tempFile
     *            directory to be removed
     * @param tempLog
     *            file to be removed
     * @throws IOException
     *             unsuccessful operation, directory/file cannot be removed
     */
    public static void remove_temp_data(File tempFile, File tempLog) throws IOException {
        FileUtils.deleteDirectory(tempFile);
        tempLog.delete();
    }

    /**
     * Try to system.out.println the response at server side.
     * 
     * @param currentPorcess
     *            current executed process
     * @throws IOException
     *             problem append during the read and write process
     */
    public static void printCommandResponse(Process currentPorcess) throws IOException {
        String line;
        BufferedReader bri = new BufferedReader(new InputStreamReader(currentPorcess.getInputStream()));
        BufferedReader bre = new BufferedReader(new InputStreamReader(currentPorcess.getErrorStream()));

        while ((line = bri.readLine()) != null) {
            System.out.println(line);
        }
        bri.close();
        while ((line = bre.readLine()) != null) {
            System.out.println(line);
        }
        bre.close();
    }

    /**
     * Adding several empty lines to make the output file more beautiful
     * 
     * @param logFilePath
     *            current executed process
     * @throws IOException
     *             the output file is not validated
     */
    public static void printPudding(String logFilePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(logFilePath, true));
        PrintWriter outwriter = new PrintWriter(bw);
        outwriter.println();
        outwriter.println("=============================================================================");
        outwriter.println();
        outwriter.close();
    }
}
