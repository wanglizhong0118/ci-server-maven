package test;

import static org.junit.Assert.assertFalse;
import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class test_compileRepository {

    File localtmpPath_exists = new File("C://Users//allwi//Documents//GitHub//ci-server-maven-junit");
    File localtmpPath_not_exists = new File("C://Users//allwi//Documents//GitHub//ci-server-maven-junit-fake");

    String logFilePath_exists = "C://Users/allwi/Documents/GitHub/ci-server-maven-junit/test_log.txt";
    String logFilePath_not_exists = "C://Users/allwi/Documents/GitHub/ci-server-maven-junit-fake/test_log.txt";

    File test_file = new File("test_File");
    String test_logFilePath = "test_String";

    @Test
    public void trueIsFalse() throws IOException {
        assertFalse(true);
    }

}
