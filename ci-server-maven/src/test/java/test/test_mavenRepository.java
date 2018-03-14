package test;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.MavenException;
import app.mavenRepository;

public class test_mavenRepository {

    /**
     * Test if the MavenException thrown when the mvn command not exists
     */
    @Rule
    public ExpectedException filedMvnCommandException = ExpectedException.none();

    @Test
    public void test_maven_FailedCommand() throws IOException, InterruptedException, MavenException {
        File localtmpPath = new File("test_localtmpPath");
        String logFilePath = "test_logFilePath";
        String operation = "NoExistCommand";
        filedMvnCommandException.expect(MavenException.class);
        filedMvnCommandException.expectMessage("Maven donot support this command");
        mavenRepository.init(localtmpPath, logFilePath, operation);
    }
}
