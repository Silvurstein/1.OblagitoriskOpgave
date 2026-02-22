package Project;

// Electronics arver fra LoanTracker så den får title, loan og metoder derfra
public class Electronics extends LoanTracker {
    // private = kan kun bruges inde i denne klasse
    // gemmer modelnavn på enheden (fx "Ipad Pro 2025")
    private String model;

    // Constructor
    public Electronics(String title, int loan, String model) {
        super(title, loan); // kalder constructoren fra LoanTracker
        this.model = model; // gemmer model i denne klasse
    }

    // getter bruges til at hente model navnet
    public String getModel() {
        return model;
    }

    // @Override betyder vi overskriver en method fra LoanTracker
    // denne method viser info om Electronics
    @Override
    public void displayInfo() {
        System.out.println(toString());
    }

    // toString laver en slags tekst skabelon som bruges til at printe det pænt ud
    @Override
    public String toString() {
        // super.toString() henter tekst fra LoanTracker
        return "Electronics | " + super.toString() + " | Model: " + model + "\n";
    }
}

