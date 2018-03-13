package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class test_main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter resultExporter = new PrintWriter("result.txt", "UTF-8");
        final String NEWLINE = System.getProperty("line.separator");

        Result result = JUnitCore.runClasses(AllTests.class);
        int totalRunTests = result.getRunCount();
        int failedUnittest = 0;
        long totalTime = result.getRunTime();

        for (Failure failure : result.getFailures()) {
            failedUnittest++;
        }
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        resultExporter.write(ft.format(dNow) + NEWLINE);
        resultExporter.write("Total runned tests: " + totalRunTests + NEWLINE);
        resultExporter.write("Total failed tests: " + failedUnittest + NEWLINE);
        resultExporter.write("Total cost time: " + totalTime + " milesecond" + NEWLINE);
        resultExporter.write(NEWLINE);
        for (Failure failure : result.getFailures()) {
            resultExporter.write("Failed TestCase(TestClass): " + failure.getDescription() + NEWLINE);
            StringWriter errors = new StringWriter();
            failure.getException().printStackTrace(new PrintWriter(errors));
            String errorException = errors.toString();
            resultExporter.write(errorException + NEWLINE);
        }

        resultExporter.close();
    }

}
