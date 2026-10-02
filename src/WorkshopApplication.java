import java.util.Scanner;
import java.util.ArrayList;

public class WorkshopApplication {

    public static int workshopId ;
    public static String workshopTitle;
    public static String facilitatorName ;
    public static String workshopDate ;
    public static double workshopFee ;
    public static int maximumCapacity;
    public static int numberOfRegistrations;
    public static int availableSpaces;
    public static WorkshopCategory workshopCategory;

    // Participant variables

    public static int participantId ;
    public static String participantFullName;
    public static String participantName;
    public static String participantSurname;
    public static String participantEmail;
    public static String registrationStatus;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        final int MAX_STANDARD_WORKSHOPS = 5;

        // Calculation

        availableSpaces = maximumCapacity - numberOfRegistrations;

        System.out.println("Available spaces: " + availableSpaces);

        ApplicationHeading.heading();

        MainMenu.workshopHashMapMap.put(1, new Workshop(1, "Introduction to Java", WorkshopCategory.PROGRAMMING , "TBA", "2026-11-10", 30,
                0, true, 1000));

        MainMenu.workshopHashMapMap.put(2, new Workshop(2, "Web Development Fundamentals", WorkshopCategory.PROGRAMMING, "TBA", "2026-12-01",25,
                0, true, 1050));

        MainMenu.workshopHashMapMap.put(3, new Workshop(3, "Database Design", WorkshopCategory.DATABASE, "TBA", "2026-08-15",20,
                0, true, 1100));

        MainMenu.workshopHashMapMap.put(4, new Workshop(4, "Networking Basics", WorkshopCategory.NETWORKING, "TBA", "2026-11-25",20,
                0, true, 1150));

        MainMenu.workshopHashMapMap.put(5, new Workshop(5, "Cybersecurity Awareness", WorkshopCategory.CYBERSECURITY, "TBA", "2026-10-15",30,
                0, true, 1200));

        MainMenu.workshopHashMapMap.put(6, new Workshop(6, "Data Analytics", WorkshopCategory.DATA_SCIENCE, "TBA", "2026-09-01",25,
                0, true, 1250));


        String value_1 = "confirmed";
        String value_2 = "CONFIRMED";
        ReusableMethods.compareIgnoreCase(value_1, value_2);
        System.out.println("Statuses match (ignoring case): " + ReusableMethods.compareIgnoreCase(value_1, value_2));
        MainMenu.menu(scanner);
    }
}
