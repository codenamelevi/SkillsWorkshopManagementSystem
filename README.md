# Skills Workshop Management System


A Java console application for managing workshops, participants, and registrations. It uses MySQL to store records and can export registration and summary reports.


## Features



- Manage workshop and participant records

- Register participants for workshops

- Search stored records

- Export registration details to CSV

- Export summary totals to a text file

- Load workshop and participant data from MySQL



## Requirements



- Java JDK 21 or later

- MySQL 8.0 or later

- MySQL Connector/J

- IntelliJ IDEA or another Java IDE



## Setup



1. Create the database and tables by running `database.sql` in MySQL Workbench or your preferred MySQL client.

2. Configure the database connection in `DatabaseConnection.java` with your MySQL host, database name, username, and password.

3. Add the MySQL Connector/J JAR to the project classpath.

4. Open the project in your IDE and run `WorkshopApplication.java`.



If no workshops are found in the database at startup, the application inserts its default workshops.


## Reports


Reports are exported from the application menu:



- `reports/registration_report.csv` — registration details

- `reports/summary_report.txt` — summary totals



Make sure the `reports` folder exists in the project root before exporting.


## Project Structure

SkillsWorkshopManagementSystem/
├── ApplicationHeading.java
├── DatabaseConnection.java
├── DatabaseOperations.java
├── MainMenu.java
├── Participant.java
├── ReusableMethods.java
├── Workshop.java
├── WorkshopApplication.java
├── WorkshopCategory.java
├── database.sql
├── reports/
└── README.md

## Notes and Limitations



- The application is console-based; it does not include a graphical interface.

- The workshop list used during registration is based on the six default workshops.

- Participant telephone numbers are currently stored as `TBA`.

- Participant IDs are entered by staff and must be unique positive integers.

- Workshop fees are stored as whole-number amounts in South African rand.



## Author


Levi Johnson — SODF102: Software Development Fundamentals
