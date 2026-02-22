package Project;

// abstract = man kan IKKE lave et objekt direkte af Books
// den skal arves (extends) af en anden klasse,  fx LoanTracker eller Fiction
public abstract class Books extends LoanTracker {
    String author;

    // Constructor, den kalder vi på når vi laver et nyt book objekt
     public Books(String title, int loan, String author) {
        super(title, loan); // kalder constructoren fra LoanTracker
        this.author = author; // gemmer forfatteren i denne klasse
    }

    // Getter, gir sig selv
    // bruges til at hente forfatterens navn
    public String getAuthor() {
         return author;
    }

    // @Override betyder vi overskriver en method fra LoanTracker
    // denne method viser info om bogen
    @Override
    public void displayInfo() {
         System.out.println(toString());
    }

    // toString laver en slags tekst skabelon som bruges til at printe det pænt ud
    @Override
    public String toString() {
        // super.toString() henter tekst fra LoanTracker
         return "Book | " + super.toString() + " Author: " + author;

    }
}
