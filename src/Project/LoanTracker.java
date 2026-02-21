package Project;

public abstract class LoanTracker {

    private String title;
    private int loan;

    public LoanTracker(String title, int loan){
        this.title = title;
        this.loan = loan;

    }

    public String getTitle(){
        return title;
    }
    public double getLoan(){
        return loan;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setLoan(int loan){
        this.loan = loan;
    }
    public abstract void getDescription();

    @Override
    public String toString(){
        return "Furniture: " + title + "\nLoan: " + loan;

    }

}

