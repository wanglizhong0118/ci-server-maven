package app;

import java.io.File;
import java.io.IOException;

public class compileRepository {

    private static String CMD = "cmd.exe";

    private static String cleanCompileSource = "mvn clean compile";
    private static String cleanCompileTest = "mvn clean test-compile";

    public static void init(File localtmpPath, String logFilePath) throws IOException {

        String compileLocation = localtmpPath.getAbsolutePath() + "/ci-server-maven";

        String sourceCompile = "/C cd " + compileLocation + "&" + cleanCompileSource + " >> " + logFilePath;
        ProcessBuilder compilePB = new ProcessBuilder(CMD, sourceCompile);
        compilePB.redirectErrorStream(true).start();
        System.out.println("hello world");

        String testCompile = "/C cd " + compileLocation + "&" + cleanCompileTest + " >> " + logFilePath;
        ProcessBuilder compilePBtest = new ProcessBuilder(CMD, testCompile);
        compilePBtest.redirectErrorStream(true).start();
    }
}
