package datetime;

import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, formatter);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(appointmentDate);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int time = Integer.parseInt(appointmentDate.format(DateTimeFormatter.ofPattern("HH")));
        return time >= 12 && time <= 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {

        DayOfWeek dayOfWeek = appointmentDate.getDayOfWeek();
        Month month = appointmentDate.getMonth();
        int monthDay = appointmentDate.getDayOfMonth();
        int year = appointmentDate.getYear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("K:mm a", Locale.ENGLISH);

        String time = appointmentDate.format(formatter);
        System.out.println(time);
        return String.format("You have an appointment on %s, %s %s, %s, at %s.",
                dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH) ,month.getDisplayName(TextStyle.FULL, Locale.ENGLISH),  monthDay, year, time);
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }

    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        System.out.println(scheduler.schedule("7/25/2019 11:45:00"));
        System.out.println(scheduler.hasPassed(scheduler.schedule("7/25/2019 13:45:00")));
        System.out.println(scheduler.isAfternoonAppointment(scheduler.schedule("7/25/2019 13:45:00")));
        System.out.println(scheduler.getDescription(scheduler.schedule("7/25/2019 10:45:00")));

    }
}