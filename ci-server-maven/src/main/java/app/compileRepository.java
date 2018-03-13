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
    private static String compileCommand = " javac -cp lib/* src/app/*.java";

    public static void init(File localtmpPath, String logFilePath) {

        String compileLocation = localtmpPath.getAbsolutePath() + "/ci-server";
        String command = "/C cd " + compileLocation + "&" + compileCommand;

        try (FileWriter fw = new FileWriter(logFilePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pWriter = new PrintWriter(bw)) {

            pWriter.println("===============================");
            pWriter.println("Compilation Started ...... ");

            long startTime = System.currentTimeMillis();
            ProcessBuilder compilePB = new ProcessBuilder(CMD, command);
            compilePB.redirectErrorStream(true);
            Process compileProcess = compilePB.start();
            long endTime = System.currentTimeMillis();
            long timeToCompile = endTime - startTime;
            pWriter.println("Complation Done in " + timeToCompile + " ms");

            BufferedReader resultBuffer = new BufferedReader(new InputStreamReader(compileProcess.getInputStream()));
            String line;
            String log = "";
            while (true) {
                line = resultBuffer.readLine();
                if (line == null) {
                    pWriter.println("Compilation Finished Sucessfully");
                    break;
                }
                log = log + " \n " + line;
                pWriter.println(line);
            }
            pWriter.println("===============================");
        } catch (IOException e) {
            System.out.println("certain error happen");
            e.printStackTrace();
        }
    }
}
