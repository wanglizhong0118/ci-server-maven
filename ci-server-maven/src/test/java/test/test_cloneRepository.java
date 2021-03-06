package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import app.cloneRepository;
import app.Utils;

/**
 * Test case for class cloneRepository
 * 
 * @author allwi
 *
 */
public class test_cloneRepository {

    String test_githubURL = "https://github.com/wanglizhong0118/ci-server-maven.git";
    String test_githubURL_fake = "https://github.com/wanglizhong0118/notExistRepo.git";
    String test_tempDir = "C:\\Users\\allwi\\Documents\\GitHub\\ci-server-maven-junit";

    /**
     * Test if the github url exists with correct user authentication
     * 
     * @throws IOException
     */
    @Test
    public void test_githubURL_exists() throws IOException {

        File test_localTempFile = Utils.create_temp_path(test_tempDir);
        String test_logFilePath = test_localTempFile + "_logger.txt";
        File test_logFile = new File(test_logFilePath);

        cloneRepository.init(test_githubURL, test_localTempFile, test_logFilePath);
        assertEquals(true, test_localTempFile.exists());
        assertNotNull(test_localTempFile.length());
        assertTrue(test_logFile.length() > 0);

        Utils.remove_temp_data(test_localTempFile, test_logFile);
    }

    /**
     * Test if the github url does not exist, or without user authentication
     * 
     * @throws IOException
     */
    @Test
    public void test_githubURL_not_exists() throws IOException {

        File test_localTempFile = Utils.create_temp_path(test_tempDir);
        String test_logFilePath = test_localTempFile + "_logger.txt";
        File test_logFile = new File(test_logFilePath);

        cloneRepository.init(test_githubURL_fake, test_localTempFile, test_logFilePath);
        assertEquals(false, test_localTempFile.exists());
        assertEquals(0, test_localTempFile.length());
        assertFalse(test_logFile.length() > 0);

        Utils.remove_temp_data(test_localTempFile, test_logFile);
    }
}
