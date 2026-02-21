package Project;

public class Books extends LoanTracker {

    String author;

     public Books(String title, int loan, String author) {
        super(title, loan);
        this.author = author;
    }
    public void lendItem(){
         System.out.println(getTitle() + author);
    }

    @Override
    public void displayInfo() {
         lendItem();
    }

    @Override
    public String toString(String athour) {
         return "Book |" + super.toString() + athour;

    }
}
