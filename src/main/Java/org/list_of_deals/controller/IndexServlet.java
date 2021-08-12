package org.list_of_deals.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        System.out.println(realPatch+" This is real patch to view");
    }

    //TODO patch variable where will be url to exist file excel
    //TODO fileLocation variable and add this variable to resp

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("From indexServlet method doGet "+getServletContext().getRealPath("/view/"));

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><a href=\"/edit\">To next page \"index.html\"</a>\n" +
                "\n" +
                "<br>\n" +
                "<a href=\"/jsonResponse\">jsonResponse</a></html>");
        printWriter.flush();

        //getServletContext().getRequestDispatcher("/view/index.html").forward(req,resp);

    }
}
