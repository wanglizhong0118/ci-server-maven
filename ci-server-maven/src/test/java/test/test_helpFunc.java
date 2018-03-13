package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.helpFunc;

public class test_helpFunc {

    String test_tempDir = "C:\\Users\\allwi\\Documents\\GitHub\\ci-server-maven-junit";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_create_temp_path_Input() throws IOException {
        expectedException.expect(IOException.class);
        helpFunc.create_temp_path("It is not a path string");
    }

    @Test
    public void test_create_temp_path_Validation() throws IOException {
        File test_randomTempFile = helpFunc.create_temp_path(test_tempDir);
        assertTrue(test_randomTempFile.mkdirs());
        assertTrue(test_randomTempFile.exists());
        assertTrue(test_randomTempFile.isDirectory());
        assertTrue(test_randomTempFile.delete());
    }

    @Test
    public void test_create_temp_path_Random() throws IOException {
        File test_randomTempFile_1 = helpFunc.create_temp_path(test_tempDir);
        File test_randomTempFile_2 = helpFunc.create_temp_path(test_tempDir);
        for (int i = 0; i < 10; i++) {
            assertNotSame(test_randomTempFile_1, test_randomTempFile_2);
        }
    }

    @Test
    public void test_remove_temp_data() throws IOException {
        File test_randomTempFile = helpFunc.create_temp_path(test_tempDir);
        File tempLog = new File(test_randomTempFile.toString() + "_log.txt");
        test_randomTempFile.mkdirs();
        helpFunc.remove_temp_data(test_randomTempFile, tempLog);
        assertFalse(test_randomTempFile.isDirectory());
        assertFalse(test_randomTempFile.exists());
        assertFalse(tempLog.exists());
    }

    @Test
    public void helpMe() throws IOException {
        assertFalse(1 + 1 == 2);
    }
}
