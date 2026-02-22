package Project;

public abstract class Books extends LoanTracker {

    String author;

     public Books(String title, int loan, String author) {
        super(title, loan);
        this.author = author;
    }
    public String getAuthor() {
         return author;
    }

    @Override
    public void displayInfo() {
         System.out.println(toString());
    }

    @Override
    public String toString() {
         return "Book | " + super.toString() + " Author: " + author;

    }
}
