package net.jonaskf.models;

import net.jonaskf.models.person.Temp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Substitution {
    private boolean isPublicSector;
    private String description;
    private Address workLocation;
    private Company employer;
    private String category;

    // Project duration
    private LocalDate fromDate;
    private LocalDate toDate;
    private WorkingTime workingTime;

    private String positionType;
    private String[] qualifications;
    private String saleryConditions;
    private String workingConditions;
    private ContactInformation contactInformation;

    private ArrayList<Temp> applicants;

    public Substitution(boolean isPublicSector, String description, Address workLocation, Company employer, String category, LocalDate fromDate, LocalDate toDate, WorkingTime workingTime, String positionType, String[] qualifications, String saleryConditions, String workingConditions, ContactInformation contactInformation, ArrayList<Temp> applicants) {
        this.isPublicSector = isPublicSector;
        this.description = description;
        this.workLocation = workLocation;
        this.employer = employer;
        this.category = category;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.workingTime = workingTime;
        this.positionType = positionType;
        this.qualifications = qualifications;
        this.saleryConditions = saleryConditions;
        this.workingConditions = workingConditions;
        this.contactInformation = contactInformation;
        this.applicants = applicants;
    }

    @Override
    public String toString() {
        return "Substitution{" +
                "isPublicSector=" + isPublicSector +
                ", description='" + description + '\'' +
                ", workLocation=" + workLocation +
                ", employer=" + employer +
                ", category='" + category + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", workingTime=" + workingTime +
                ", positionType='" + positionType + '\'' +
                ", qualifications=" + Arrays.toString(qualifications) +
                ", saleryConditions='" + saleryConditions + '\'' +
                ", workingConditions='" + workingConditions + '\'' +
                ", contactInformation=" + contactInformation +
                ", applicants=" + applicants +
                '}';
    }

    public boolean isPublicSector() {
        return isPublicSector;
    }

    public void setPublicSector(boolean publicSector) {
        isPublicSector = publicSector;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(Address workLocation) {
        this.workLocation = workLocation;
    }

    public Company getEmployer() {
        return employer;
    }

    public void setEmployer(Company employer) {
        this.employer = employer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public WorkingTime getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(WorkingTime workingTime) {
        this.workingTime = workingTime;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String[] getQualifications() {
        return qualifications;
    }

    public void setQualifications(String[] qualifications) {
        this.qualifications = qualifications;
    }

    public String getSaleryConditions() {
        return saleryConditions;
    }

    public void setSaleryConditions(String saleryConditions) {
        this.saleryConditions = saleryConditions;
    }

    public String getWorkingConditions() {
        return workingConditions;
    }

    public void setWorkingConditions(String workingConditions) {
        this.workingConditions = workingConditions;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public ArrayList<Temp> getApplicants() {
        return applicants;
    }

    public void setApplicants(ArrayList<Temp> applicants) {
        this.applicants = applicants;
    }
}
