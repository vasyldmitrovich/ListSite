package org.list_of_deals.modal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.list_of_deals.modal.entity.CourtCase;

import java.util.ArrayList;

public class ConvertToJson {

    //This method create json from array Court Cases
    public String arrCourtCaseToJson (ArrayList<CourtCase> arrayList) {
        StringBuilder jsonString = new StringBuilder();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
                jsonString.append(objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(arrayList));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString.toString();
    }
}
