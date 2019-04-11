package net.jonaskf.models;

import net.jonaskf.models.person.Temp;

public class WorkingCondition {
    private String id;
    private Temp temp;
    private Substitution substitution;

    public WorkingCondition(String id, Temp temp, Substitution substitution) {
        this.id = id;
        this.temp = temp;
        this.substitution = substitution;
    }

    @Override
    public String toString() {
        return "WorkingCondition{" +
                "id='" + id + '\'' +
                ", temp=" + temp +
                ", substitution=" + substitution +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Substitution getSubstitution() {
        return substitution;
    }

    public void setSubstitution(Substitution substitution) {
        this.substitution = substitution;
    }
}
