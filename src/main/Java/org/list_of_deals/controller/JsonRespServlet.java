package org.list_of_deals.controller;

import org.list_of_deals.modal.entity.CourtCase;
import org.list_of_deals.modal.service.ConvertToJson;
import org.list_of_deals.modal.service.WorkWithFiles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(
        name = "JsonResponse",
        urlPatterns = "/jsonResponse"
)
public class JsonRespServlet extends HttpServlet {

    public static String fileLocation = "\\\\srv3\\pryznachennya\\SpusokSprav.xlsx";
    public static String dateFormat = "dd.MM.yyyy HH:mm";
    public static int maxLengthStr = 230;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("application/json");

        resp.setContentType("text/html;charset=UTF-8");

        //Create list courtCase what we read from file
        WorkWithFiles workWithFiles = new WorkWithFiles();
        ArrayList<CourtCase> casesArrayList;
        casesArrayList = workWithFiles.readFromExcelFile(fileLocation,dateFormat,maxLengthStr);

        ConvertToJson convertToJson = new ConvertToJson();
        String jsonToFrontend = convertToJson.arrCourtCaseToJson(casesArrayList, dateFormat);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(jsonToFrontend);
    }
}
