package net.jonaskf.models;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

public class WorkingTime {
    private LocalTime start;
    private LocalTime end;
    private float duration;

    public WorkingTime(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;

        this.updateDuration();
    }

    @Override
    public String toString() {
        return "WorkingTime{" +
                "start=" + start +
                ", end=" + end +
                ", duration=" + duration +
                '}';
    }

    private void updateDuration() {
        this.duration = (float) this.start.until(this.end, MINUTES) / 60;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
