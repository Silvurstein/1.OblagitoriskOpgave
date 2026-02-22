package Project;

public class Electronics extends LoanTracker {

    private String model;


    public Electronics(String title, int loan, String model) {
        super(title, loan);
        this.model = model;

    }

    public String getModel() {
        return model;
    }

    @Override
    public void displayInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Electronics | " + super.toString() + " | Model: " + model + "\n";
    }
}

