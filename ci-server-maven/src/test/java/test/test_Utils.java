package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.Utils;

public class test_Utils {

    String test_tempDir = "C:\\Users\\allwi\\Documents\\GitHub\\ci-server-maven-junit";

    /**
     * Test if the input string is not a path
     */
    @Rule
    public ExpectedException createTempException = ExpectedException.none();

    @Test
    public void test_create_temp_path_NotPath() throws IOException {
        String test_tempDir = "It is not a path string";
        createTempException.expect(IOException.class);
        Utils.create_temp_path(test_tempDir);
    }

    /**
     * Test if the input string is a null object
     */
    @Rule
    public ExpectedException ceateTempNullException = ExpectedException.none();

    @Test
    public void test_create_temp_path_Null() throws IOException {
        String test_tempDir = null;
        ceateTempNullException.expect(NullPointerException.class);
        Utils.create_temp_path(test_tempDir);
    }

    /**
     * Test if the temporary path is correctly created.
     */
    @Test
    public void test_create_temp_path_Validation() throws IOException {
        File test_randomTempFile = Utils.create_temp_path(test_tempDir);
        assertTrue(test_randomTempFile.mkdirs());
        assertTrue(test_randomTempFile.exists());
        assertTrue(test_randomTempFile.isDirectory());
        assertTrue(test_randomTempFile.delete());

    }

    /**
     * Test 10 times that the random created folder do not have same name.
     */
    @Test
    public void test_create_temp_path_Random() throws IOException {
        File test_randomTempFile_1 = Utils.create_temp_path(test_tempDir);
        File test_randomTempFile_2 = Utils.create_temp_path(test_tempDir);
        for (int i = 0; i < 10; i++) {
            assertNotSame(test_randomTempFile_1, test_randomTempFile_2);
        }
    }

    /**
     * Test if an existing file can be removed correctly
     */
    @Test
    public void test_remove_temp_data() throws IOException {
        File test_randomTempFile = Utils.create_temp_path(test_tempDir);
        File tempLog = new File(test_randomTempFile.toString() + "_log.txt");
        test_randomTempFile.mkdirs();
        Utils.remove_temp_data(test_randomTempFile, tempLog);
        assertFalse(test_randomTempFile.isDirectory());
        assertFalse(test_randomTempFile.exists());
        assertFalse(tempLog.exists());
    }

    /**
     * Test if a non existing file can be removed correctly
     */
    @Rule
    public ExpectedException removeTempException = ExpectedException.none();

    @Test
    public void test_remove_temp_data_Exception() throws IOException {
        File test_tempFile = null;
        File test_tempLog = null;
        removeTempException.expect(NullPointerException.class);
        Utils.remove_temp_data(test_tempFile, test_tempLog);
    }

    /**
     * Test if NullPointerException is thrown when input is null.
     */
    @Rule
    public ExpectedException processException = ExpectedException.none();

    @Test
    public void test_printCommandResponse() throws IOException {
        Process test_process = null;
        processException.expect(NullPointerException.class);
        Utils.printCommandResponse(test_process);
    }

    /**
     * Test if FileNotFoundException is thrown when input file path doesn't exist.
     */
    @Rule
    public ExpectedException puddingException = ExpectedException.none();

    @Test
    public void test_printPudding() throws IOException {
        String test_logFilePath = "";
        processException.expect(FileNotFoundException.class);
        Utils.printPudding(test_logFilePath);
    }

}
