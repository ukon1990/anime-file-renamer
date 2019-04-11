package net.jonaskf.models.person;

import net.jonaskf.models.Address;
import net.jonaskf.models.ContactInformation;
import net.jonaskf.models.WorkExperience;

import java.util.ArrayList;

public class Applicant extends Person {
    private ContactInformation contactInformation;
    private String education;
    private ArrayList<WorkExperience> workExperience;
    private ArrayList<Person> references;
    private int minimumSalary;
    private String preferedWorkCategory;

    public Applicant(String firstName, String lastName, int age, String gender, Address address, ContactInformation contactInformation, ContactInformation contactInformation1, String education, ArrayList<WorkExperience> workExperience, ArrayList<Person> references, int minimumSalary, String preferedWorkCategory) {
        super(firstName, lastName, age, gender, address, contactInformation);
        this.contactInformation = contactInformation1;
        this.education = education;
        this.workExperience = workExperience;
        this.references = references;
        this.minimumSalary = minimumSalary;
        this.preferedWorkCategory = preferedWorkCategory;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "contactInformation=" + contactInformation +
                ", education='" + education + '\'' +
                ", workExperience=" + workExperience +
                ", references=" + references +
                ", minimumSalary=" + minimumSalary +
                ", preferedWorkCategory='" + preferedWorkCategory + '\'' +
                '}';
    }

    @Override
    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    @Override
    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public ArrayList<WorkExperience> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(ArrayList<WorkExperience> workExperience) {
        this.workExperience = workExperience;
    }

    public ArrayList<Person> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<Person> references) {
        this.references = references;
    }

    public int getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(int minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public String getPreferedWorkCategory() {
        return preferedWorkCategory;
    }

    public void setPreferedWorkCategory(String preferedWorkCategory) {
        this.preferedWorkCategory = preferedWorkCategory;
    }
}
