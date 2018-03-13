package app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class helpFunc {

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
}
