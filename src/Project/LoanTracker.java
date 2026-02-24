package Project;

// abstract = man kan IKKE lave et objekt direkte af LoanTracker
// "skabelon" for andre klasser (Books, Electronics osv) når "super" bruges, kalder den her
public abstract class LoanTracker {

    // private giver sig selv, kun denne klasse må tilgå dem direkte
    // andre klasser skal bruge getters/setters
    private String title;
    private int loan;

    // Constructor
    public LoanTracker(String title, int loan){
        this.title = title;
        this.loan = loan;
    }
    // getter = bruges til at læse title
    public String getTitle(){
        return title;
    }
    // getter = læse loan dage
    public int getLoan(){
        return loan;
    }
    // setter = ændre title senere hvis nødvendigt
    public void setTitle(String title){
        this.title = title;
    }
    // setter = ændre loan dage
    public void setLoan(int loan){
        this.loan = loan;
    }
    public int getLateFee(){
        return 0;
    }
    /* abstract metode betyder, ALLE underklasser SKAL lave deres egen version
    LoanTracker ved ikke hvordan info skal vises, så Books/Electronics bestemmer selv */
    public abstract void displayInfo();

    // toString laver en slags tekst skabelon som bruges til at printe det pænt ud
    @Override
    public String toString(){
        // super.toString() henter tekst fra LoanTracker
        return "Title: " + title + "\nLoan days: " + loan;
    }
}

