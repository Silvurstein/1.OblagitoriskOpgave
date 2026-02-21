package Project;

public abstract class LoanTracker {
    private String title;
    private int loan;
    private int fine;

    // Constructor
    public LoanTracker(String title, int loan) {
        this.title = title;
        this.loan = loan;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public int getLoan() {
        return loan;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setExpiryDays(int loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Loan days: " + loan;
    }

}