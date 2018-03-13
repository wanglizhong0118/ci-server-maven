package app;

import java.io.File;
import java.io.IOException;

public class mavenRepository {

    final private static String CMD = "cmd.exe";
    final private static String COMPILE = "COMPILE";
    final private static String TEST = "TEST";
    final private static String cleanCompileTest = " mvn clean test-compile ";
    final private static String runTestCases = " mvn test -Dtest=AllTests ";

    public static void init(File localtmpPath, String logFilePath, String operation)
            throws IOException, InterruptedException {
        if (operation.equals(COMPILE)) {
            runMaveCommand(localtmpPath, logFilePath, cleanCompileTest);
        } else if (operation.equals(TEST)) {
            runMaveCommand(localtmpPath, logFilePath, runTestCases);
        } else {
            System.out.println("No such command");
        }
    }

    public static void runMaveCommand(File localtmpPath, String logFilePath, String mvnCMD)
            throws IOException, InterruptedException {

        String junitPath = localtmpPath.getAbsolutePath() + "/ci-server-maven";
        String junitCommand = "/C cd " + junitPath + " &" + mvnCMD + " >> " + logFilePath;

        ProcessBuilder junitBuilder = new ProcessBuilder(CMD, junitCommand);
        junitBuilder.redirectErrorStream(true);
        Process junitProcess = junitBuilder.start();

        Utils.printCommandResponse(junitProcess);

        junitProcess.waitFor();

        Utils.printPudding(logFilePath);
    }

}
