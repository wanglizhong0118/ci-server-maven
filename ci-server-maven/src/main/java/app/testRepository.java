package app;

import java.io.File;
import java.io.IOException;

public class testRepository {

    final private static String CMD = "cmd.exe";
    final private static String runTestCases = " mvn test -Dtest=AllTests ";

    /**
     * Execute test cases to test whether the project looks good using Maven.
     * 
     * @param localtmpPath
     *            the local temporary directory to store the cloned repository
     * @param logFilePath
     *            the local temporary file to log the cloned process
     * @throws IOException
     *             any exception thrown during the test process
     * @throws InterruptedException
     *             the CMD command cannot be interrupted
     */
    public static void init(File localtmpPath, String logFilePath) throws IOException, InterruptedException {

        String junitPath = localtmpPath.getAbsolutePath() + "/ci-server-maven";
        String junitCommand = "/C cd " + junitPath + " &" + runTestCases + " >> " + logFilePath;

        ProcessBuilder junitBuilder = new ProcessBuilder(CMD, junitCommand);
        junitBuilder.redirectErrorStream(true);
        Process junitProcess = junitBuilder.start();

        Utils.printCommandResponse(junitProcess);

        junitProcess.waitFor();

        Utils.printPudding(logFilePath);
    }
}
