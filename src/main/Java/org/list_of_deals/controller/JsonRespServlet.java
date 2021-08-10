package org.list_of_deals.controller;

import org.list_of_deals.modal.entity.CourtCase;
import org.list_of_deals.modal.service.ConvertToJson;
import org.list_of_deals.modal.service.WorkWithFiles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class JsonRespServlet extends HttpServlet {

    public static String fileLocation = "C:\\\\04.08.21_rewrite.xlsx";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("application/json");

        resp.setContentType("text/html;charset=UTF-8");

        //Create list courtCase what we read from file
        WorkWithFiles workWithFiles = new WorkWithFiles();
        ArrayList<CourtCase> casesArrayList;
        casesArrayList = workWithFiles.readFromExcelFile(fileLocation);

        ConvertToJson convertToJson = new ConvertToJson();
        String jsonToFrontend = convertToJson.arrCourtCaseToJson(casesArrayList);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(jsonToFrontend);
    }
}
