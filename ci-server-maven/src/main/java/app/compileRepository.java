package app;

import java.io.File;
import java.io.IOException;

public class compileRepository {

    final private static String CMD = "cmd.exe";
    final private static String cleanCompileTest = " mvn clean test-compile ";

    public static void init(File localtmpPath, String logFilePath) throws IOException, InterruptedException {

        String compileLocation = localtmpPath.getAbsolutePath() + "/ci-server-maven";
        String testCompile = "/C cd " + compileLocation + " &" + cleanCompileTest + " >> " + logFilePath;

        ProcessBuilder compilationBuilder = new ProcessBuilder(CMD, testCompile);
        compilationBuilder.redirectErrorStream(true);
        Process compileProcess = compilationBuilder.start();

        Utils.testPrintCommad(compileProcess);

        compileProcess.waitFor();

        Utils.printPudding(logFilePath);
    }
}
