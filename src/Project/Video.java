package Project;

public class Video extends LoanTracker{
    private int duration;

    public Video(String title, int loan, int duration) {
        super(title, loan);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
    @Override
    public void displayInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Video | " + super.toString() + " | Duration: " + duration + "\n";
    }
}
