package net.jonaskf.models;

import java.util.Iterator;
import java.util.List;

public class CompanyTableObject {
    private String name;
    private String description;
    private String email;
    private boolean isPublic;

    public CompanyTableObject(String name, String description, String email, boolean isPublic) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.isPublic = isPublic;
    }

    @Override
    public String toString() {
        return "CompanyTableObject{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }

    boolean mailExistsInList(List<CompanyTableObject> list) {
        long numberOfDuplicates = list.stream()
                .filter(this::isTheSameEMail).count();
         return numberOfDuplicates == 0;
    }

    private boolean isTheSameEMail(CompanyTableObject company) {
        boolean isEqual = !this.toString().equals(company.toString()) && company.getEmail().equals(this.getEmail());
        System.out.println("Print start");
        System.out.println(company.getEmail() + " - " + this.getEmail() + " - " + company.getEmail().equals(this.getEmail()));
        System.out.println(isEqual ? "true" : "false" + "  -  " + !this.toString().equals(company.toString()));
        return isEqual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
