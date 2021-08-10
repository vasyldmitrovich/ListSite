package org.list_of_deals.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    //TODO patch variable where will be url to exist file excel
    //TODO fileLocation variable and add this variable to resp

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html;charset=UTF-8");

        getServletContext().getRequestDispatcher("/view/index.html").forward(req,resp);

    }
}
