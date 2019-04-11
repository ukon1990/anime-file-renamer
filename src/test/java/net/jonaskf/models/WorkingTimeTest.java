package net.jonaskf.models;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class WorkingTimeTest {

    @Test
    void canUpdateWorkDayDuration() {
        WorkingTime workingTime = new WorkingTime(
                LocalTime.of(8, 0),
                LocalTime.of(16, 0)
        );

        assertEquals(8, workingTime.getDuration());
    }

    @Test
    void canUpdateWorkDayDurationWhenAnUnevenHour() {
        WorkingTime workingTime = new WorkingTime(
                LocalTime.of(8, 30),
                LocalTime.of(16, 0)
        );

        assertEquals(7.5, workingTime.getDuration());
    }
}