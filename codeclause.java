import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class codeclause {
    public static void main(String[] args) { // entry point of java programm
        Scanner sc = new Scanner(System.in); //for user input used scanner 

        // Taking user input for local time zone
        System.out.print("Enter your local time zone or own country time \n(e.g. Asia/Kolkata, Asia/Tashkent, Asia/Kuwait): ");
        String localZoneIdStr = sc.nextLine();
        ZoneId localZoneId = ZoneId.of(localZoneIdStr);

        // Taking user input for country time zone
        System.out.print("Enter the country time zone \n(e.g. America/New_York, Europe/London, Asia/Tokyo): ");
        String countryZoneIdStr = sc.nextLine();
        ZoneId countryZoneId = ZoneId.of(countryZoneIdStr);

        // Convert local time to country time
        LocalDateTime localDateTime = LocalDateTime.now(localZoneId);
        LocalDateTime countryDateTime = localDateTime.atZone(localZoneId).withZoneSameInstant(countryZoneId).toLocalDateTime();

        // Formating Date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = formatter.format(localDateTime);
        String countryTime = formatter.format(countryDateTime);

        // Showing output for the time conversion
        System.out.println("Local time (" + localZoneId + "): " + localTime);
        System.out.println("Country time (" + countryZoneId + "): " + countryTime);
        sc.close();;
    }
}