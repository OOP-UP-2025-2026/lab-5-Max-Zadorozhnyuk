package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        if (minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = minutes / 60;
            this.minutes = minutes % 60;
        }
    }

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            int totalMinutes = hours * 60 + minutes;
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }

    public TimeSpan(TimeSpan other) {
        if (other == null) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = other.hours;
            this.minutes = other.minutes;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;
        int total = getTotalMinutes() + hours * 60 + minutes;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    public void add(int minutes) {
        if (minutes < 0) return;
        add(0, minutes);
    }

    public void add(TimeSpan span) {
        if (span == null) return;
        add(span.getHours(), span.getMinutes());
    }

    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;
        int total = getTotalMinutes() - (hours * 60 + minutes);
        if (total < 0) return;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    public void subtract(int minutes) {
        if (minutes < 0) return;
        subtract(0, minutes);
    }

    public void subtract(TimeSpan span) {
        if (span == null) return;
        subtract(span.getHours(), span.getMinutes());
    }

    public void scale(int factor) {
        if (factor <= 0) return;
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    @Override
    public String toString() {
        return String.format("%d год %d хв", hours, minutes);
    }
}