package app;

import java.io.File;
import java.io.IOException;

public class testRepository {

    final private static String CMD = "cmd.exe";
    final private static String runTestCases = " mvn test -Dtest=AllTests ";

    public static void init(File localtmpPath, String logFilePath) throws IOException, InterruptedException {

        String junitPath = localtmpPath.getAbsolutePath() + "/ci-server-maven";
        String junitCommand = "/C cd " + junitPath + " &" + runTestCases + " >> " + logFilePath;

        ProcessBuilder junitBuilder = new ProcessBuilder(CMD, junitCommand);
        junitBuilder.redirectErrorStream(true);
        Process junitProcess = junitBuilder.start();

        Utils.testPrintCommad(junitProcess);

        junitProcess.waitFor();

        Utils.printPudding(logFilePath);
    }
}
