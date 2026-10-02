public class Workshop {

    public int workshop_ID;
    public String workshop_Title;
    public WorkshopCategory  workshop_Category;
    public String workshop_Facilitator;
    public String workshop_Date;
    public int workshop_Capacity;
    public int workshop_NumberOfRegistrations;
    public boolean workshop_ActiveStatus;
    public int workshop_Fee;


    public Workshop(int workshop_ID, String workshop_Title, WorkshopCategory workshop_Category, String workshop_Facilitator, String workshop_Date, int workshop_Capacity, int workshop_NumberOfRegistrations, boolean workshop_ActiveStatus, int workshop_Fee) {
        this.workshop_ID = workshop_ID;
        this.workshop_Title = workshop_Title;
        this.workshop_Category = workshop_Category;
        this.workshop_Facilitator = workshop_Facilitator;
        this.workshop_Date = workshop_Date;
        this.workshop_Capacity = workshop_Capacity;
        this.workshop_NumberOfRegistrations = workshop_NumberOfRegistrations;
        this.workshop_ActiveStatus = workshop_ActiveStatus;
        this.workshop_Fee = workshop_Fee;
    }

    @Override
    public String toString() {
        return "Workshop :" + "\n" +
                "Workshop ID = " + workshop_ID + "\n" +
                "Workshop Title = '" + workshop_Title + "\n" +
                "Workshop Category = " + workshop_Category + "\n" +
                "Workshop Facilitator = '" + workshop_Facilitator + "\n" +
                "Workshop Date = '" + workshop_Date + "\n" +
                "Workshop Capacity = " + workshop_Capacity + "\n" +
                "Workshop Number Of Registrations = " + workshop_NumberOfRegistrations + "\n" +
                "Workshop Active Status = " + workshop_ActiveStatus + "\n" +
                "Workshop Fee = " + workshop_Fee + "\n" ;
    }
}
