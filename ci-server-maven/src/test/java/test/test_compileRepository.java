package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.cloneRepository;
import app.compileRepository;

public class test_compileRepository {

    File localtmpPath_exists = new File("C://Users/allwi/Documents/GitHub/ci-server-temp-unittest");
    File localtmpPath_not_exists = new File("C://Users/allwi/Documents/GitHub/ci-server-temp-unittest-fake");

    String logFilePath_exists = "C://Users/allwi/Documents/GitHub/ci-server-temp-unittest/test_log.txt";
    String logFilePath_not_exists = "C://Users/allwi/Documents/GitHub/ci-server-temp-unittest-fake/test_log.txt";

    File test_file = new File("test_File");
    String test_logFilePath = "test_String";

    @Test
    public void trueIsFalse() throws IOException {
        assertFalse(true);
    }

}
