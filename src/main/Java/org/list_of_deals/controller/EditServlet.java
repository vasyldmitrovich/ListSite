package org.list_of_deals.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {

    public static String fileLocation = "C:\\\\04.08.21_rewrite.xlsx";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        getServletContext().getRequestDispatcher("/view/edit.jsp").forward(req,resp);

    }
}
