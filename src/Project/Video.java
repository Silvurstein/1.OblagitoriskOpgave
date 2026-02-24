package Project;

public class Video extends LoanTracker{
    // variabel for længden af videoen i minutter
    private int duration;

    // Constructor - bruges når vi laver et nyt Video objekt
    public Video(String title, int loan, int duration) {
        super(title, loan); // kalder constructoren i LoanTracker
        this.duration = duration; // gemmer længden af videoen
    }

    // getter - bruges til at hente varighed
    public int getDuration() {
        return duration;
    }

    // vi override getFee fra loantracker fordi den er på 0, med override så henter vi koden men kan nu give den ny værdi
    @Override
    public int getLateFee() {
        return 30; // bøde pr. dag for videoer
    }
    // @Override betyder vi overskriver en method fra LoanTracker
    // denne method viser info om Videoen
    @Override
    public void displayInfo() {
        System.out.println(toString());
    }
    // toString laver en slags tekst skabelon som bruges til at printe det pænt ud
    @Override
    public String toString() {
        // super.toString() henter tekst fra LoanTracker
        return "Video | " + super.toString() + " | Duration: " + duration + "\n";
    }
}
