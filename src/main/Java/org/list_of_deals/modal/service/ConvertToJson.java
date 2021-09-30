package org.list_of_deals.modal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.list_of_deals.modal.entity.CourtCase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConvertToJson {

    //This method create json from array Court Cases
    public String arrCourtCaseToJson (ArrayList<CourtCase> arrayList, String dateFormatStr) {
        StringBuilder jsonString = new StringBuilder();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
            objectMapper.setDateFormat(dateFormat);
                jsonString.append(objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(arrayList));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString.toString();
    }
}
