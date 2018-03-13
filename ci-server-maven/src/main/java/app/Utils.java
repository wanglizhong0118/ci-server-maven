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

    public static File create_temp_path(String tempDir) throws IOException {
        File tempFile = new File(tempDir);
        File randomTempFile = File.createTempFile("TestCloneGitRepo", "", tempFile);
        if (!randomTempFile.delete()) {
            throw new IOException("Could not delete temporary file " + randomTempFile);
        }
        return randomTempFile;
    }

    public static void remove_temp_data(File tempFile, File tempLog) {
        try {
            FileUtils.deleteDirectory(tempFile);
            tempLog.delete();
        } catch (IOException e) {
            System.out.println("Problem occurs when deleting the directory : " + tempFile.toString());
            e.printStackTrace();
        }
    }

    public static void testPrintCommad(Process compileProcess) throws IOException {
        String line;
        BufferedReader bri = new BufferedReader(new InputStreamReader(compileProcess.getInputStream()));
        BufferedReader bre = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));

        while ((line = bri.readLine()) != null) {
            System.out.println(line);
        }
        bri.close();
        while ((line = bre.readLine()) != null) {
            System.out.println(line);
        }
        bre.close();
    }

    static void printPudding(String logFilePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(logFilePath, true));
        PrintWriter outwriter = new PrintWriter(bw);
        outwriter.println();
        outwriter.println("=============================================================================");
        outwriter.println();
        outwriter.close();
    }
}
