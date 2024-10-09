package com.pluralsight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

public class FormatDates {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format 1: MM/dd/yyyy (e.g., 09/05/2021)
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate1 = currentDateTime.format(format1);
        System.out.println(formattedDate1);

        // Format 2: yyyy-MM-dd (e.g., 2021-09-05)
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate2 = currentDateTime.format(format2);
        System.out.println(formattedDate2);

        // Format 3: MMMM d, yyyy (e.g., September 5, 2021)
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDate3 = currentDateTime.format(format3);
        System.out.println(formattedDate3);

        // Format 4: EEEE, MMM d, yyyy HH:mm (GMT time)
        ZonedDateTime currentDateTimeInGMT = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        String formattedDate4 = currentDateTimeInGMT.format(format4);
        System.out.println(formattedDate4 + " GMT");

        // CHALLENGE: Format 5: h:mm 'on' dd-MMM-yyyy (Local time zone)
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("h:mm 'on' dd-MMM-yyyy");
        String formattedDate5 = currentDateTime.format(format5);
        System.out.println(formattedDate5);
    }
}
