package org.list_of_deals.modal.entity;

import java.util.Comparator;
import java.util.Date;

//This class describe Case intended for consideration
public class CourtCase implements Comparator <CourtCase>, Comparable<CourtCase> {

    private Date dateAndTime;
    private String judges;
    private String caseNumber;//Number of case
    private String proceedingsNumber;//Number of proceedings
    private String claimantDefendant;//The parties to the case
    private String gistClaim; //The essence of the lawsuit; Суть позову
    private String courtroom;

    public CourtCase(){}

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getJudges() {
        return judges;
    }

    public void setJudges(String judges) {
        this.judges = judges;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getProceedingsNumber() {
        return proceedingsNumber;
    }

    public void setProceedingsNumber(String proceedingsNumber) {
        this.proceedingsNumber = proceedingsNumber;
    }

    public String getClaimantDefendant() {
        return claimantDefendant;
    }

    public void setClaimantDefendant(String claimantDefendant) {
        this.claimantDefendant = claimantDefendant;
    }

    public String getGistClaim() {
        return gistClaim;
    }

    public void setGistClaim(String gistClaim) {
        this.gistClaim = gistClaim;
    }

    public String getCourtroom() {
        return courtroom;
    }

    public void setCourtroom(String courtroom) {
        this.courtroom = courtroom;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "CourtCase{" +
                "dateAndTime='" + dateAndTime + '\'' +
                ", judges='" + judges + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                ", proceedingsNumber='" + proceedingsNumber + '\'' +
                ", claimantDefendant='" + claimantDefendant + '\'' +
                ", gistClaim='" + gistClaim + '\'' +
                ", courtroom='" + courtroom + '\'' +
                '}';
    }

    @Override
    public int compare(CourtCase o1, CourtCase o2) {
        return o1.getDateAndTime().compareTo(o2.getDateAndTime());
    }

    @Override
    public int compareTo(CourtCase o) {
        return getDateAndTime().compareTo(o.getDateAndTime());
    }
}
