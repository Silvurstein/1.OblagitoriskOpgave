package Project;

public class Electronics extends LoanTracker {

    String model;

    public Electronics(String title, int expiryDays, int loan, String model, int baseValue, String kitLevel) {
        super(title, expiryDays, loan, model, baseValue, kitLevel);
    }

    public void rentItem() {
        System.out.println(getTitle() + " item rented ");
    }

    @Override
    public void useItem() {
        rentItem();
    }

    @Override
    public String toString() {
        return "Electronics" + super.toString();
    }
}

