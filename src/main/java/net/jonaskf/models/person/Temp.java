package net.jonaskf.models.person;

import net.jonaskf.models.Address;
import net.jonaskf.models.ContactInformation;

public class Temp extends Person {
    public Temp(String firstName, String lastName, Address address, ContactInformation contactInformation) {
        super(firstName, lastName, address, contactInformation);
    }

    public Temp(String firstName, String lastName, int age, String gender, Address address, ContactInformation contactInformation) {
        super(firstName, lastName, age, gender, address, contactInformation);
    }
}
