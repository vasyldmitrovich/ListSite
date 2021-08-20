package org.list_of_deals.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(
        name = "IndexServlet",
        urlPatterns = "/",
        loadOnStartup = 1
)
public class IndexServlet extends HttpServlet {
    private static  String realPatch;


    @Override
    public void init() throws ServletException {
        super.init();
        realPatch = getServletContext().getRealPath("");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String patch1 = getServletContext().getRealPath(File.separator+"view"+File.separator+"index.html");
        Path patch = Paths.get(realPatch +"view"+File.separator+"index.html");
        StringBuilder stringBuilder = new StringBuilder();
        Charset charset = Charset.forName("UTF-8");

        try (BufferedReader bufferedReader = Files.newBufferedReader(patch,charset)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            System.out.println("IOException: No html file on disc: "+e);
        }

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(stringBuilder.toString());
        printWriter.flush();

    }
}
