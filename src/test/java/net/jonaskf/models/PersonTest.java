package net.jonaskf.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void canCheckIfTwoObjectsLookTheSame() {
        Person person1 = new Person("Truls", 21, "Student");
        Person person2 = new Person("Truls", 21, "Student");
        Person person3 = new Person("Truls", 22, "Student");
        assertTrue(person1.isEqual(person2));
        assertFalse(person1.isEqual(person3));
    }
}