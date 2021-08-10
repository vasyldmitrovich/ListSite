package org.list_of_deals.modal.entity;

//This class describe Case intended for consideration
public class CourtCase implements Comparable<CourtCase>{

    private String dateAndTime;
    private String judges;
    private String caseNumber;//Номер справи
    private String proceedingsNumber;//Номер провадження
    private String claimantDefendant;//The parties to the case; Сторони по справі
    private String gistClaim; //The essence of the lawsuit; Суть позову
    private String courtroom; //Зал судових засідань

    public CourtCase(){}

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
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
    //TODO need method what we will call from compareTo and that method separate field dateAndTime 04.08.2021 08:30
    //because i must sort only time

    @Override
    public int compareTo(CourtCase o) {
        return 0;
    }
}
