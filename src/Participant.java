public class Participant {

    public int participant_ID;
    public String participant_FirstName;
    public String participant_Surname;
    public String participant_Email;
    public String participant_TelephoneNumber;
    public String participant_Type;
    public boolean participant_ActiveStatus;

    public Participant(int participant_ID, String participant_FirstName, String participant_Surname, String participant_Email, String participant_TelephoneNumber, String participant_Type, boolean participant_ActiveStatus) {
        this.participant_ID = participant_ID;
        this.participant_FirstName = participant_FirstName;
        this.participant_Surname = participant_Surname;
        this.participant_Email = participant_Email;
        this.participant_TelephoneNumber = participant_TelephoneNumber;
        this.participant_Type = participant_Type;
        this.participant_ActiveStatus = participant_ActiveStatus;
    }

    @Override
    public String toString() {
        return "Participant: " + "\n" +
                "Participant ID = " + participant_ID + "\n" +
                "Participant First Name = '" + participant_FirstName+ "\n" +
                "Participant Surname = '" + participant_Surname+ "\n" +
                "Participant Email = '" + participant_Email+ "\n" +
                "Participant Telephone Number = '" + participant_TelephoneNumber + "\n" +
                "Participant Type  '" + participant_Type+ "\n" +
                "Participant Active Status = " + participant_ActiveStatus + "\n" ;
    }
}
