package Project;

public class Electronics extends LoanTracker {

    String model;
    int baseValue;
    String kitLevel;

    public Electronics(String title, int expiryDays, int loan, String model, int baseValue, String kitLevel) {
        super(title, expiryDays, loan, model, baseValue, kitLevel);
        this.model = model;
        this.baseValue = baseValue;
        this.kitLevel = kitLevel;
    }

    public void lendItem() {
        System.out.println(getTitle() + " item rented ");
    }

    @Override
    public void displayInfo() {
        lendItem();
    }

    @Override
    public String toString() {
        return "Electronics" + super.toString();
    }
}

