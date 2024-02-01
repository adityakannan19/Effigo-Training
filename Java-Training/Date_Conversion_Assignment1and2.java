import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.*;

class dateConversion{

    public static void IstToUnix(String ist){
        
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ZonedDateTime ISTDateTime = ZonedDateTime.parse(ist, inputFormatter.withZone(ZoneId.of("Asia/Kolkata")));
        long unixTimestamp = ISTDateTime.toEpochSecond();
        System.out.println(unixTimestamp);
    }

    public static void IstToUtc(String ist){
        
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ZonedDateTime ISTDateTime = ZonedDateTime.parse(ist, inputFormatter.withZone(ZoneId.of("Asia/Kolkata")));
        ZonedDateTime utcDateTime = ISTDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        String utcDateString = utcDateTime.format(inputFormatter);
        System.out.println(utcDateString);
    }

    public static void UtcToIst(String utc){
        
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ZonedDateTime UTCDateTime = ZonedDateTime.parse(utc, inputFormatter.withZone(ZoneId.of("UTC")));
        ZonedDateTime itcConvertedDateTime = UTCDateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
        String ITCconvertedDateString = itcConvertedDateTime.format(inputFormatter);
        System.out.println(ITCconvertedDateString);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(choice != 5){
            System.out.println("1. IST to Unix Timestamp");
            System.out.println("2. IST to UTC");
            System.out.println("3. UTC to IST");
            System.out.print("4. \r\n" + //
                    "- Add one day \r\n" + //
                    "- Substract 10 days\r\n" + //
                    "- Add 1 hour\r\n" + //
                    "- Substract 5 hours, 30 mins\r\n" + //
                    "");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    String istinput;
                    System.out.print("Enter time in IST format (29/01/2024 01:00):");
                    istinput = scanner.nextLine();
                    IstToUnix(istinput);
                    break;
                
                case 2:
                    String istinp;
                    System.out.print("Enter time in IST format (29/01/2024 01:00):");
                    istinp = scanner.nextLine();
                    IstToUtc(istinp);
                    break;

                case 3:
                    String utcinput;
                    System.out.print("Enter time in UTC format (29/01/2024 01:00):");
                    utcinput = scanner.nextLine();
                    UtcToIst(utcinput);
                    break;
                case 4:
                    String dateTimeInput;
                    System.out.print("Enter date-time: ");
                    dateTimeInput = scanner.nextLine();
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                    ZonedDateTime istDateTime = ZonedDateTime.parse(dateTimeInput, inputFormatter.withZone(ZoneId.of("Asia/Kolkata")));
                    ZonedDateTime PlusOneDay = istDateTime.plusDays(1);
                    System.out.println("Add 1 day: " + PlusOneDay);
                    ZonedDateTime MinusTenDays = istDateTime.minusDays(10);
                    System.out.println("Subtract 10 days: " + MinusTenDays);
                    ZonedDateTime PlusOneHour = istDateTime.plusHours(1);
                    System.out.println("Add 1 hour: " + PlusOneHour);
                    ZonedDateTime MinusFiveHoursThirtyMinutes = istDateTime.minusHours(5).minusMinutes(30);
                    System.out.println("Subtract 5:30: " + MinusFiveHoursThirtyMinutes);

            }
        }
    }
}




