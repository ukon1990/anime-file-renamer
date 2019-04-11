package net.jonaskf.models;

import net.jonaskf.models.person.Temp;

import java.util.ArrayList;

public class Company {
    private String id;
    private String name;
    private String industry;
    private Address address;
    private ArrayList<Temp> temps;

    public Company(String id, String name, String industry, Address address, ArrayList<Temp> temps) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.address = address;
        this.temps = temps;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                ", address=" + address +
                ", temps=" + temps +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Temp> getTemps() {
        return temps;
    }

    public void setTemps(ArrayList<Temp> temps) {
        this.temps = temps;
    }
}
