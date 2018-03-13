package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import app.cloneRepository;
import app.helpFunc;

public class test_cloneRepository {

    String test_githubURL = "https://github.com/wanglizhong0118/ci-server.git";
    String test_githubURL_fake = "https://github.com/wanglizhong0118/notExistRepo.git";
    String test_tempDir = "C:\\Users\\allwi\\Documents\\GitHub\\ci-server-junit";

    @Test
    public void test_githubURL_exists() throws IOException {

        File test_localTempFile = helpFunc.create_temp_path(test_tempDir);
        String test_logFilePath = test_localTempFile + "_logger.txt";
        File test_logFile = new File(test_logFilePath);
        cloneRepository.init(test_githubURL, test_localTempFile, test_logFilePath);

        assertEquals(true, test_localTempFile.exists());
        assertNotNull(test_localTempFile.length());
        assertTrue(test_logFile.length() > 0);

        helpFunc.remove_temp_data(test_localTempFile, test_logFile);
    }

    @Test
    public void test_githubURL_not_exists() throws IOException {

        File test_localTempFile = helpFunc.create_temp_path(test_tempDir);
        String test_logFilePath = test_localTempFile + "_logger.txt";
        File test_logFile = new File(test_logFilePath);

        cloneRepository.init(test_githubURL_fake, test_localTempFile, test_logFilePath);
        assertEquals(false, test_localTempFile.exists());
        assertEquals(0, test_localTempFile.length());
        assertTrue(test_logFile.length() > 0);

        helpFunc.remove_temp_data(test_localTempFile, test_logFile);
    }

    @Test
    public void falseIsTrue() throws IOException {
        assertTrue(false);
    }
}
