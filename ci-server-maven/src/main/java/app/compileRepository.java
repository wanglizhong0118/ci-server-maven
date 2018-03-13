package app;

import java.io.File;
import java.io.IOException;

public class compileRepository {

    final private static String CMD = "cmd.exe";
    final private static String cleanCompileTest = " mvn clean test-compile ";

    /**
     * Compile a cloned git repository (source and test code) using Maven.
     * 
     * @param localtmpPath
     *            the directory where the project is stored
     * @param logFilePath
     *            the file to log the process of compilation
     * @throws IOException
     *             the log cannot be written to log file
     * @throws InterruptedException
     *             the CMD command cannot be interrupted
     */
    public static void init(File localtmpPath, String logFilePath) throws IOException, InterruptedException {

        String compileLocation = localtmpPath.getAbsolutePath() + "/ci-server-maven";
        String testCompile = "/C cd " + compileLocation + " &" + cleanCompileTest + " >> " + logFilePath;

        ProcessBuilder compilationBuilder = new ProcessBuilder(CMD, testCompile);
        compilationBuilder.redirectErrorStream(true);
        Process compileProcess = compilationBuilder.start();

        Utils.printCommandResponse(compileProcess);

        compileProcess.waitFor();

        Utils.printPudding(logFilePath);
    }
}
