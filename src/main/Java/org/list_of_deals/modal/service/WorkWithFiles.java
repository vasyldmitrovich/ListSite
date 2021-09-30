package org.list_of_deals.modal.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.list_of_deals.modal.entity.CourtCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WorkWithFiles {

    private ArrayList<CourtCase> courtCases = new ArrayList<>();

    public WorkWithFiles(){}

    public ArrayList<CourtCase> getCourtCases() {
        return courtCases;
    }

    public void setCourtCases(ArrayList<CourtCase> courtCases) {
        this.courtCases = courtCases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkWithFiles that = (WorkWithFiles) o;
        return Objects.equals(courtCases, that.courtCases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courtCases);
    }


    //In this method we will read .xlsx file on PC
    // and return array objects court cases intended for consideration.
    public ArrayList<CourtCase> readFromExcelFile(String fileLocation, String dataFormat, int maxLengthStr) {
        ArrayList<CourtCase> arrayListCases = new ArrayList<>();

        FileInputStream fileInputStream = null;
        XSSFWorkbook xssfWorkbook = null;

        //initialize threads
        try {
            fileInputStream  = new FileInputStream(new File(fileLocation));
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Parse the first sheet of the input file into an object model
        assert xssfWorkbook != null;
        Sheet sheet = xssfWorkbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();

        //We go through the whole sheet
        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.iterator();
            //We skip first two row, because in these rows only description data
            if (row.getRowNum() >= 2) {
                CourtCase courtCase = new CourtCase();
                //We go through the whole row
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    CellType cellType = cell.getCellType();

                    //Condition is data String or not;
                        switch (cellType) {
                            case BLANK:break;
                            case STRING:
                                switch (cell.getColumnIndex()) {
                                    case 0: courtCase.setDateAndTime(parseDateFromString(cell.getStringCellValue(),dataFormat));break;
                                    case 1: courtCase.setJudges(cell.getStringCellValue());break;
                                    case 2: courtCase.setCaseNumber(cell.getStringCellValue());break;
                                    case 3: courtCase.setProceedingsNumber(cell.getStringCellValue());break;
                                    case 4: courtCase.setClaimantDefendant(maxLengthString(cell.getStringCellValue(),maxLengthStr));break;
                                    case 5: courtCase.setGistClaim(cell.getStringCellValue());break;
                                    case 6: courtCase.setCourtroom(cell.getStringCellValue());break;
                                }
                        }
                }
                //See is object empty or not
                if (courtCase.getCaseNumber() != null) {
                    if (courtCase.getJudges() == null) courtCase.setJudges("");
                    if (courtCase.getProceedingsNumber() == null) courtCase.setProceedingsNumber("");
                    if (courtCase.getClaimantDefendant() == null) courtCase.setClaimantDefendant("");
                    if (courtCase.getGistClaim() == null) courtCase.setGistClaim("");
                    if (courtCase.getCourtroom() == null) courtCase.setCourtroom("");

                    arrayListCases.add(courtCase);
                }
            }
        }
        //Sort array of objects on field of date
        Collections.sort(arrayListCases);
        return arrayListCases;
    }

    private static Date parseDateFromString (String string, String dataFormat) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataFormat);
        if (string != null) {
            try {
                date = simpleDateFormat.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    private static String maxLengthString (String string, int maxLength) {
        if (string != null && string.length() > maxLength) {
            string = string.substring(0,maxLength);
            string.trim();
            int lastSpaceInStr = string.lastIndexOf(" ");
            string = string.substring(0,lastSpaceInStr);
            string += " ...";
        }
        return string;
    }
}
