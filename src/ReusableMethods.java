import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.FileReader;


public class ReusableMethods {

    public static String trimSpaces(String inputParticipantName) {
        inputParticipantName = inputParticipantName.strip().trim();
        return inputParticipantName;
    }


    public static String titlecase(String Name) {
        Name = Name.substring(0, 1).toUpperCase() + Name.substring(1).toLowerCase();// levi  "L" + "evi"
        return Name;
    }

    public static String lowerCaseEmail(String inputParticipantEmail) {
        inputParticipantEmail = inputParticipantEmail.toLowerCase();
        return inputParticipantEmail;
    }

    public static String validEmail(String inputPartcipantEmail, Scanner scanner) {


        boolean validEmail;

        do {
            int position = inputPartcipantEmail.indexOf("@");
            int validDomain = inputPartcipantEmail.lastIndexOf(".");

            if (inputPartcipantEmail.contains("@") && position < inputPartcipantEmail.length() - 1 && position > 0 && inputPartcipantEmail.contains(".")
                    && validDomain < inputPartcipantEmail.length() - 1 && validDomain - position > 1) {
                validEmail = true;
            } else {
                validEmail = false;
                System.out.println("Invalid Email Address");
                System.out.println("Please enter a email address: ");
                inputPartcipantEmail = scanner.nextLine();
            }

        } while (!validEmail);
        return inputPartcipantEmail;

    }


    public static boolean compareIgnoreCase(String value1, String value2) {
        return value1.equalsIgnoreCase(value2);
    }

    public static void nameSearch(String wantedSearch) {


        boolean found = false;

        for (String Name : MainMenu.registeredParticipantNames) {

            if (Name == null) {
                continue;
            }

            if (Name.toLowerCase().contains(wantedSearch.toLowerCase())) {
                System.out.println("Participant found: ");
                System.out.println(Name);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No exact name found for " + wantedSearch);
        }

    }

    public static <T> void displayItems(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    public static void exportReport() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reports/registration_report.csv"))) {

            writer.write("SKILLS WORKSHOP MANAGEMENT SYSTEM - Registration Report\n");
            writer.newLine();

            LocalDateTime currentDateTime = LocalDateTime.now();
            writer.write("Report generated at: " + currentDateTime);
            writer.newLine();

            writer.write("Participant ID, Participant Name, Workshop Title, Workshop Date, Amount Payable, Status");
            writer.newLine();

            for (int i = 0; i < MainMenu.registeredParticipantNames.size(); i++) {

                writer.write(MainMenu.registeredParticipantIds.get(i) + "," + MainMenu.registeredParticipantNames.get(i) + "," + MainMenu.getWorkshopTitles()[MainMenu.registeredParticipantWorkshopIndex.get(i)]
                        + "," + MainMenu.getWorkshopDates()[MainMenu.registeredParticipantWorkshopIndex.get(i)] + "," + MainMenu.getWorkshopFees()[MainMenu.registeredParticipantWorkshopIndex.get(i)] + "," + "Confirmed");
                writer.newLine();


            }
        } catch (Exception e) {
            System.out.println("Error: Could not write data to the CSV file.");
            e.printStackTrace();
        }
        System.out.println("Success: Data exported successfully!");

    }

    public static void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("workshops.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Just printing it out for now to test it!
            }


        } catch (IOException e) {
            System.out.println("Error: Could not load data from file.");

        }
    }
}













































