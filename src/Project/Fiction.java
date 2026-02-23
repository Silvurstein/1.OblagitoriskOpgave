package Project;

// Fiction arver fra Books = Books arver fra LoanTracker
// så Fiction får ALLE felter og metoder fra begge
public class Fiction extends Books {

    // You can add more fields specific to Fiction if needed
    private String genre;

    // Constructor, bruges når vi laver en ny Fiction bog (alle vores bøger)
    public Fiction(String title, int loan, String author, String genre) {
        super(title, loan, author); /* kalder constructoren fra books som kalder fra LoanTracker
        fordi Fiction extends books og books extends LoanTracker */
        this.genre = genre; // gemmer genre i denne klasse
    }

    // getter bruges til at hente genre
    public String getGenre() {
        return genre;
    }

    // @Override betyder vi overskriver en method fra LoanTracker
    // denne method viser info om genre
    @Override
    public void displayInfo() {
        System.out.println(toString());
    }

    // toString laver en slags tekst skabelon som bruges til at printe det pænt ud
    @Override
    public String toString() {
        // super.toString() henter tekst fra LoanTracker
        return super.toString() + " | Genre: " + genre + "\n";
    }
}