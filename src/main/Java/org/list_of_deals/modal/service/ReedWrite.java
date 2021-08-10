package org.list_of_deals.modal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.list_of_deals.modal.entity.CourtCase;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/*
* This
* is
* class
* for
* testing*/
public class ReedWrite {
//_rewrite
    public static String fileLocation = "C:\\\\04.08.21_rewrite.xlsx";
    public ArrayList<CourtCase> casesArrayList = new ArrayList<>();

    //Testing reed from file class and object
    public static void main(String[] args) {
        //Create list courtCase what we read from file
        WorkWithFiles workWithFiles = new WorkWithFiles();
        ArrayList<CourtCase> casesArrayList;
        casesArrayList = workWithFiles.readFromExcelFile(fileLocation);
        CourtCase courtCase = new CourtCase();
        courtCase.setDateAndTime("1111");
        courtCase.setJudges("Vasyl B");
        courtCase.setCaseNumber("blab bla");
        courtCase.setProceedingsNumber("singleeeee");
        courtCase.setClaimantDefendant("simplesimple");
        courtCase.setGistClaim("what is");
        courtCase.setCourtroom("1");


        //Add this list to json
        StringBuilder jsonString = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            jsonString.append(objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(casesArrayList));


        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("This is jsom: "+jsonString.toString());
    }


}
