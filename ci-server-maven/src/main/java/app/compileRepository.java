package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class compileRepository {

    private static String CMD = "cmd.exe";

    private static String cleanCompileSource = " mvn clean compile ";
    private static String cleanCompileTest = " mvn clean test-compile ";
    private static String runTestCases = " mvn test -Dtest=AllTests ";

    public static void init(File localtmpPath, String logFilePath) throws IOException, InterruptedException {
        String line;
        String compileLocation = localtmpPath.getAbsolutePath() + "/ci-server-maven";
        String testCompile = "/C cd " + compileLocation + " &" + runTestCases + " >> " + logFilePath;
        System.out.println("compileLocation:" + compileLocation);
        System.out.println("testCompile:" + testCompile);

        ProcessBuilder compilationBuilder = new ProcessBuilder(CMD, testCompile);
        compilationBuilder.redirectErrorStream(true);
        Process compileProcess = compilationBuilder.start();

        BufferedReader bri = new BufferedReader(new InputStreamReader(compileProcess.getInputStream()));
        BufferedReader bre = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));

        System.out.println("after process");

        while ((line = bri.readLine()) != null) {
            System.out.println(line);
        }
        bri.close();
        while ((line = bre.readLine()) != null) {
            System.out.println(line);
        }
        bre.close();
        compileProcess.waitFor();
    }

}
