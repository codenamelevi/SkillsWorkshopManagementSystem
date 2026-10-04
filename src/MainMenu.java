import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public class MainMenu {

    private static final String[] WorkshopTitles = {
            "Introduction to Java",
            "Web Development Fundamentals",
            "Database Design",
            "Networking Basics",
            "Cybersecurity Awareness",
            "Data Analytics"
    };



    private static final int[] workshopCapacities = {
            30,
            25,
            20,
            20,
            30,
            25
    };

    private static final int[] workshopFees  = {
            1000,
            1050,
            1100,
            1150,
            1200,
            1250
    };

    private static final String[] workshopDates = {
            "2026-11-10",
            "2026-12-01",
            "2026-08-15",
            "2026-11-25",
            "2026-10-15",
            "2026-09-01"
    };


    private static final WorkshopCategory[] workshopCategories = {
            WorkshopCategory.PROGRAMMING,
            WorkshopCategory.PROGRAMMING,
            WorkshopCategory.DATABASE,
            WorkshopCategory.NETWORKING,
            WorkshopCategory.CYBERSECURITY,
            WorkshopCategory.DATA_SCIENCE,

    };

    private static final boolean[] workshopActive = {
      true,
      true,
      true,
      true,
      true,
      true
    };

    public static boolean[] getWorkshopActive() {

        return workshopActive;
    }

    public static String[] getWorkshopTitles() {

        return WorkshopTitles;
    }
    public static int[] getWorkshopCapacities() {

        return workshopCapacities;
    }

    public static String[] getWorkshopDates() {

        return workshopDates;
    }

    public static int[] getWorkshopFees() {

        return workshopFees;
    }

    public static WorkshopCategory[] getWorkshopCategories() {

        return workshopCategories;
    }



    public static int[] registeredParticipantPerWorkshop = new int[WorkshopTitles.length];

    public static ArrayList<String> registeredParticipantNames = new ArrayList<>();
    public static ArrayList<Integer> registeredParticipantWorkshopIndex= new ArrayList<>();
    public static ArrayList<Integer> registeredParticipantIds = new ArrayList<>();

    public static HashMap<Integer, Workshop> workshopHashMapMap = new HashMap<>();
    public static HashMap<Integer, Participant> participantHashMap = new HashMap<>();

    public static HashSet<String> registeredParticipantEmail = new HashSet<>();
    public static HashSet<Integer> registeredParticipantID = new HashSet<>();
    public static HashSet<Integer> registeredWorkshopID = new HashSet<>();



    public static void menu(Scanner scanner) {



        int choice = 0;

        do {

        System.out.println("1. Manage workshops ");
        System.out.println("2. Manage participants ");
        System.out.println("3. Register participant for workshop ");
        System.out.println("4. Search records ");
        System.out.println("5. Display registration summary ");
        System.out.println("6. Export report ");
        System.out.println("7. Load saved data ");
        System.out.println("8. Database operations ");
        System.out.println("9. Exit ");

        String strChoice =scanner.nextLine().trim();


        try {

            choice = Integer.parseInt(strChoice);

            switch (choice) {
                case 1:
                    System.out.println("Manage workshops selected.\n");


                    System.out.println("1. View All Workshops");
                    System.out.println("2. Browse by category");
                    System.out.println("3. Create new workshop");


                    int workshopMenuChoice = scanner.nextInt();
                    scanner.nextLine();


                    switch (workshopMenuChoice) {
                        case 1:
                            System.out.println("\nPlease select a Workshop: ");


                            for (int i = 0; i < getWorkshopTitles().length; i++) {
                                System.out.println((i + 1) + ". " + WorkshopTitles[i] + " - " + workshopCategories[i]);
                            }
                            int choiceWorkShopTitle = scanner.nextInt();
                            scanner.nextLine();

                            if (choiceWorkShopTitle >= 1 && choiceWorkShopTitle <= WorkshopTitles.length) {
                                System.out.println("Welcome to " + WorkshopTitles[choiceWorkShopTitle - 1]);
                            } else {
                                System.out.println("Invalid option chosen");
                            }
                            break;

                        case 2:
                            System.out.println("1. PROGRAMMING");
                            System.out.println("2. DATABASE");
                            System.out.println("3. NETWORKING");
                            System.out.println("4. CYBERSECURITY");
                            System.out.println("5. DATA_SCIENCE");
                            int categoryChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (categoryChoice >= 1 && categoryChoice <= 5) {
                                WorkshopCategory selected;
                                switch (categoryChoice) {
                                    case 1:
                                        selected = WorkshopCategory.PROGRAMMING;
                                        break;
                                    case 2:
                                        selected = WorkshopCategory.DATABASE;
                                        break;
                                    case 3:
                                        selected = WorkshopCategory.NETWORKING;
                                        break;
                                    case 4:
                                        selected = WorkshopCategory.CYBERSECURITY;
                                        break;
                                    case 5:
                                        selected = WorkshopCategory.DATA_SCIENCE;
                                        break;
                                    default:
                                        selected = null;
                                        break;
                                }
                                WorkshopApplication.workshopCategory = selected;
                                System.out.println("Category: " + selected);

                                System.out.println("Workshops in this category:");
                                for (int i = 0; i < WorkshopTitles.length; i++) {
                                    if (workshopCategories[i] == selected) {
                                        System.out.println((i + 1) + ". " + WorkshopTitles[i]);
                                    }
                                }
                            } else {
                                System.out.println("Invalid option chosen");
                            }
                            break;

                        case 3:
                            System.out.println("Please enter workshop ID: \n");

                            WorkshopApplication.workshopId = scanner.nextInt();
                            scanner.nextLine();

                            if(registeredWorkshopID.contains(WorkshopApplication.workshopId)){
                            System.out.println("Workshop ID is already registered.");
                            break;
                        }

                            System.out.println("Please enter workshop title: \n");

                            WorkshopApplication.workshopTitle = scanner.nextLine();

                            for (String a : getWorkshopTitles()){
                                if(WorkshopApplication.workshopTitle.equals(a)){
                                    System.out.println("Workshop Title is already registered.");
                                    break;
                                }
                            }

                            System.out.println("Please select a workshop category: \n");

                            int i = 1;

                            for(WorkshopCategory a :  WorkshopCategory.values()){
                                System.out.println(i + ". " + a);
                                i++;
                            }

                            int categoryChoice2 = scanner.nextInt();
                            scanner.nextLine();

                            if(categoryChoice2 > 5 || categoryChoice2 < 1){
                                System.out.println("Invalid choice");
                                break;
                            }else{
                                WorkshopApplication.workshopCategory = WorkshopCategory.values()[categoryChoice2 - 1];
                            }

                            System.out.println("Please enter workshop facilitator: \n");

                            WorkshopApplication.facilitatorName = scanner.nextLine();

                            System.out.println("Please enter workshop date: \n");

                            WorkshopApplication.workshopDate = scanner.nextLine();

                            for(String date : workshopDates){
                                if(WorkshopApplication.workshopDate.equals(date)){
                                    System.out.println("Workshop date is unavailable.");
                                    break;
                                }
                            }


                            System.out.println("Please enter workshop capacity: \n");

                            WorkshopApplication.maximumCapacity = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Please enter the number of registrations the workshop will take: \n");
                            WorkshopApplication.numberOfRegistrations = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Please enter workshop Fee: \n");

                            WorkshopApplication.workshopFee = scanner.nextInt();
                            scanner.nextLine();


                            System.out.println("Please enter whether this workshop will be active upon creation: \n");

                            System.out.println("1. True");
                            System.out.println("2. False");

                            int act = scanner.nextInt();
                            scanner.nextLine();

                            boolean newWorkshopStatus ;

                            if(act == 1){
                                 newWorkshopStatus = true;
                            }else{
                                 newWorkshopStatus = false;

                            }
                            MainMenu.workshopHashMapMap.put(WorkshopApplication.workshopId, new Workshop(WorkshopApplication.workshopId, WorkshopApplication.workshopTitle, WorkshopApplication.workshopCategory, WorkshopApplication.facilitatorName, WorkshopApplication.workshopDate,WorkshopApplication.maximumCapacity,
                                    WorkshopApplication.numberOfRegistrations, newWorkshopStatus, WorkshopApplication.workshopFee));

                            registeredWorkshopID.add(WorkshopApplication.workshopId);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Manage participants selected.");

                    if (registeredParticipantNames.isEmpty()) {
                        System.out.println("No participants registered yet.");
                    } else {
                        ReusableMethods.displayItems(registeredParticipantNames);
                    }
                    break;

                case 3:

                    System.out.println("Register participant for workshop selected");

                    System.out.println("Please enter a participant ID: ");

                    WorkshopApplication.participantId = scanner.nextInt();
                    scanner.nextLine();

                    if (WorkshopApplication.participantId > 0) {
                        System.out.println("Valid Participant Id: " + WorkshopApplication.participantId);
                    } else {
                        System.out.println("Invalid Participant Id");
                        break;
                    }
                    if(registeredParticipantID.contains(WorkshopApplication.participantId)){
                        System.out.println("Participant ID is already registered.");
                        break;
                    }

                    System.out.println("Please enter a participant Full Name: ");
                    WorkshopApplication.participantFullName = scanner.nextLine();
                    WorkshopApplication.participantFullName = ReusableMethods.trimSpaces(WorkshopApplication.participantFullName);
                    if (WorkshopApplication.participantFullName.isEmpty()) {
                        System.out.println("Participant name may not be blank.");
                        break;
                    }
                    String[] parts = WorkshopApplication.participantFullName.split("\\s+");
                    for (int i = 0; i < parts.length; i++) {
                        parts[i] = ReusableMethods.titlecase(parts[i]);
                    }

                    WorkshopApplication.participantFullName = String.join(" ", parts);
                    System.out.println(WorkshopApplication.participantFullName);


                    System.out.println("Please enter a email address: ");
                    WorkshopApplication.participantEmail = scanner.nextLine();
                    WorkshopApplication.participantEmail = ReusableMethods.validEmail(WorkshopApplication.participantEmail, scanner);
                    WorkshopApplication.participantEmail = ReusableMethods.lowerCaseEmail(WorkshopApplication.participantEmail);

                    if (registeredParticipantEmail.contains(WorkshopApplication.participantEmail)) {
                        System.out.println("Email is already registered.");
                        break;
                    }

                    System.out.println("What Workshop would you like to join: ");
                    for (int i = 0; i < getWorkshopTitles().length; i++) {
                        System.out.println((i + 1) + ". " + WorkshopTitles[i] + " - " + workshopCategories[i]);
                    }
                    int participantWorkshopChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (getWorkshopActive()[participantWorkshopChoice - 1] == false) {
                        System.out.println("Workshop is not active");
                        break;
                    } else if (workshopCapacities[participantWorkshopChoice - 1] == registeredParticipantPerWorkshop[participantWorkshopChoice - 1]) {
                        System.out.println("Workshop is full");
                        break;
                    } else if (LocalDate.parse(workshopDates[participantWorkshopChoice - 1]).isBefore(LocalDate.now())) {
                        System.out.println("Workshop date has already passed.");
                        break;
                    } else if (participantWorkshopChoice >= 1 && participantWorkshopChoice <= WorkshopTitles.length) {
                        boolean alreadyRegistered = false;
                        for (int i = 0; i < registeredParticipantNames.size(); i++) {
                            if (ReusableMethods.compareIgnoreCase(WorkshopApplication.participantFullName, registeredParticipantNames.get(i)) && (participantWorkshopChoice - 1) == registeredParticipantWorkshopIndex.get(i)) {
                                System.out.println("Participant is already registered for this workshop");
                                alreadyRegistered = true;
                                break;
                            }
                        }
                        if (!alreadyRegistered) {
                            registeredParticipantPerWorkshop[participantWorkshopChoice - 1]++;

                            registeredParticipantNames.add(WorkshopApplication.participantFullName);
                            registeredParticipantWorkshopIndex.add(participantWorkshopChoice - 1);
                            System.out.println("Registration successful for " + WorkshopTitles[participantWorkshopChoice - 1]);

                            participantHashMap.put(WorkshopApplication.participantId, new Participant(WorkshopApplication.participantId, parts[0], parts[1], WorkshopApplication.participantEmail, "TBA", "Standard",
                                    true));

                            registeredParticipantEmail.add(WorkshopApplication.participantEmail);

                            registeredParticipantIds.add(WorkshopApplication.participantId);

                            registeredParticipantID.add(WorkshopApplication.participantId);

                            ReusableMethods.exportReport();


                        }
                    } else {
                        System.out.println("Invalid workshop choice.");
                    }


                    break;

                case 4:


                    System.out.println("Search records selected.\n");

                    System.out.println("1. Search participant by name");
                    System.out.println("2. Search workshop by ID");
                    System.out.println("3. Search participant by ID\n");
                    System.out.println("Select a choice:");

                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.println("Enter participant name to search: ");
                            String SearchName = scanner.nextLine();
                            ReusableMethods.nameSearch(SearchName);
                            break;
                        case 2:
                            System.out.println("Enter workshop ID to search: ");
                            int workshopSearchID = scanner.nextInt();
                            scanner.nextLine();

                            if (workshopHashMapMap.get(workshopSearchID) != null) {
                                System.out.println(workshopHashMapMap.get(workshopSearchID));

                            } else {
                                System.out.println("No workshop found with that ID.");
                            }
                            break;
                        case 3:
                            System.out.println("Enter participant ID to search: ");
                            int participantSearchID = scanner.nextInt();
                            scanner.nextLine();

                            if (participantHashMap.get(participantSearchID) != null) {
                                System.out.println(participantHashMap.get(participantSearchID));
                            } else {
                                System.out.println("No participant found with that ID.");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice chosen");
                            break;
                    }
                    break;

                case 5:
                    int totalRegistrations = 0;
                    double totalExpectedIncome = 0;

                    for (int i = 0; i < WorkshopTitles.length; i++) {
                        System.out.println(WorkshopTitles[i] + ": " + registeredParticipantPerWorkshop[i] + " registrations");
                        WorkshopApplication.availableSpaces = workshopCapacities[i] - registeredParticipantPerWorkshop[i];
                        System.out.println("Available spaces: " + WorkshopApplication.availableSpaces);

                        totalRegistrations += registeredParticipantPerWorkshop[i];
                        totalExpectedIncome += workshopFees[i] * registeredParticipantPerWorkshop[i];
                    }

                    System.out.println("Total registrations: " + totalRegistrations);
                    System.out.println("Total expected income: R" + totalExpectedIncome);

                    break;
                case 6:
                    System.out.println("Export report selected.");
                    ReusableMethods.exportReport();
                    break;
                case 7:
                    System.out.println("Load saved data selected.");
                    break;
                case 8:
                    System.out.println("Database operations selected.");
                    break;
                case 9:
                    System.out.println("Exiting the application.");
                    break;
            }

        }catch(NumberFormatException e){

            System.out.println("\n[Error] '" + strChoice + "' is not a valid number. Try again.\n");
        } catch (IOException e) {
            System.out.println("Error exporting report: " + e.getMessage());

        }

        }while(choice != 9);

    }

    public static HashMap<Integer, Participant> getParticipantHashMap() {
        return participantHashMap;
    }
}