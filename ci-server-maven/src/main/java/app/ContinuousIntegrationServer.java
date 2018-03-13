package app;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class ContinuousIntegrationServer extends AbstractHandler {

    public static String githubURL = "https://github.com/wanglizhong0118/ci-server-maven.git";
    public static String tempDir = "C://Users//allwi//Documents//GitHub//ci-server-maven-temp";
    public static File localTempFile;
    public static String logFilePath;

    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        try {
            init();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.getWriter().println("<br/> CI job done");
    }

    public void init() throws IOException, InterruptedException {

        localTempFile = helpFunc.create_temp_path(tempDir);
        logFilePath = localTempFile + "_logger.txt";

        cloneRepository.init(githubURL, localTempFile, logFilePath);

        System.out.println("Clone Done");

        compileRepository.init(localTempFile, logFilePath);

        System.out.println("Complation Done");

        notification.init(logFilePath);

    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new ContinuousIntegrationServer());
        server.start();
        server.join();
    }
}
