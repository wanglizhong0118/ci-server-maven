package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class testRepository {

    final private static String CMD = "cmd.exe";
    final private static String runTestCases = " mvn test -Dtest=AllTests ";

    public static void init(File localtmpPath, String logFilePath) throws IOException, InterruptedException {
        String line;
        String compileLocation = localtmpPath.getAbsolutePath() + "/ci-server-maven";
        String testCompile = "/C cd " + compileLocation + " &" + runTestCases + " >> " + logFilePath;

        ProcessBuilder compilationBuilder = new ProcessBuilder(CMD, testCompile);
        compilationBuilder.redirectErrorStream(true);
        Process compileProcess = compilationBuilder.start();

        // String line;
        // BufferedReader bri = new BufferedReader(new
        // InputStreamReader(compileProcess.getInputStream()));
        // BufferedReader bre = new BufferedReader(new
        // InputStreamReader(compileProcess.getErrorStream()));
        //
        // while ((line = bri.readLine()) != null) {
        // System.out.println(line);
        // }
        // bri.close();
        // while ((line = bre.readLine()) != null) {
        // System.out.println(line);
        // }
        // bre.close();
        compileProcess.waitFor();
    }
}
