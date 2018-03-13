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

    private static String cleanCompileSource = "mvn clean compile";
    private static String cleanCompileTest = "mvn clean test-compile";

    public static void init(File localtmpPath, String logFilePath) throws IOException {

        String compileLocation = localtmpPath.getAbsolutePath() + "/ci-server-maven";

        try (FileWriter fw = new FileWriter(logFilePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pWriter = new PrintWriter(bw)) {

            String sourceCompile = "/C cd " + compileLocation + "&" + cleanCompileTest;
            ProcessBuilder compilePB = new ProcessBuilder(CMD, sourceCompile);
            compilePB.redirectErrorStream(true);
            Process compileProcess = compilePB.start();

            BufferedReader resultBuffer = new BufferedReader(new InputStreamReader(compileProcess.getInputStream()));
            String line;
            String log = "";
            while (true) {
                line = resultBuffer.readLine();
                if (line == null) {
                    break;
                }
                log = log + " \n " + line;
                pWriter.println(line);
            }
        }
        // String testCompile = "/C cd " + compileLocation + "&" + cleanCompileTest + "
        // >> " + logFilePath;
        // ProcessBuilder compilePBtest = new ProcessBuilder(CMD, testCompile);
        // compilePBtest.redirectErrorStream(true).start();
    }
}
