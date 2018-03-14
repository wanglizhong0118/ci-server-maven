package app;

import java.io.File;
import java.io.IOException;

public class mavenRepository {

    final private static String CMD = "cmd.exe";
    final private static String COMPILE = "COMPILE";
    final private static String TEST = "TEST";
    final private static String cleanCompileTest = " mvn clean test-compile ";
    final private static String runTestCases = " mvn test -Dtest=AllTests ";

    /**
     * Switch between the compile and test command based on the selection
     * 
     * @param localtmpPath
     *            the directory where the repo is cloned
     * @param logFilePath
     *            the path of the log file is generated
     * @param operation
     *            the file choice made in the previous method
     * @throws IOException
     *             either the directory or the file is unavailable
     * @throws InterruptedException
     *             the CMD command cannot be interrupted
     * @throws mavenException
     */
    public static void init(File localtmpPath, String logFilePath, String operation)
            throws IOException, InterruptedException, MavenException {
        if (operation.equals(COMPILE)) {
            runMaveCommand(localtmpPath, logFilePath, cleanCompileTest);
        } else if (operation.equals(TEST)) {
            runMaveCommand(localtmpPath, logFilePath, runTestCases);
        } else {
            throw new MavenException("Maven donot support this command");
        }
    }

    /**
     * Execute Maven command(compile/test), and record the result in the log file
     * 
     * 
     * @param localtmpPath
     *            the directory where the repo is cloned
     * @param logFilePath
     *            the path of the log file is generated
     * @param mvnCMD
     *            the Maven command executed in the directory
     * @throws IOException
     *             either the directory or the file is unavailable
     * @throws InterruptedException
     *             the CMD command cannot be interrupted
     */
    public static void runMaveCommand(File localtmpPath, String logFilePath, String mvnCMD)
            throws InterruptedException, IOException {

        String junitPath = localtmpPath.getAbsolutePath() + "/ci-server-maven";
        String junitCommand = "/C cd " + junitPath + " &" + mvnCMD + " >> " + logFilePath;

        ProcessBuilder junitBuilder = new ProcessBuilder(CMD, junitCommand);
        junitBuilder.redirectErrorStream(true);
        Process junitProcess = junitBuilder.start();

        // Utils.printCommandResponse(junitProcess);

        junitProcess.waitFor();

        // Utils.printPudding(logFilePath);
    }

}
