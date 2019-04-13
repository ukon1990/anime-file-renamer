package net.jonaskf.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompanyTableObjectTest {

    @Test
    void canDetectDuplicateEmail() {
        ArrayList<CompanyTableObject> list = new ArrayList<>();
        CompanyTableObject a = new CompanyTableObject("Test", "noe", "mail@jonaskf.net", false);
        CompanyTableObject b = new CompanyTableObject("Test", "noe", "mail@jonaskf.net", false);
        list.add(a);
        list.add(b);
        assertTrue(b.mailExistsInList(list));
    }

    @Test
    void canDetectThatThereAreNoDuplicateEmail() {
        ArrayList<CompanyTableObject> list = new ArrayList<>();
        CompanyTableObject a = new CompanyTableObject("Test", "noe", "mail@jonaskf.net", false);
        CompanyTableObject b = new CompanyTableObject("Test", "noe", "post@jonaskf.net", false);
        list.add(a);
        list.add(b);
        assertFalse(b.mailExistsInList(list));
    }
}