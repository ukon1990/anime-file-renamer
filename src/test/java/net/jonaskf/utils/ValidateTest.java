package net.jonaskf.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    @Test
    void validEmailsShouldBeDetectedAsValid() {
        assertTrue(
                Validate.isValidEmail("some@mail.net"));
    }

    @Test
    void invalidEmailsShouldBeDetectedAsValid() {
        assertFalse(
                Validate.isValidEmail("mail.net"));
    }
}