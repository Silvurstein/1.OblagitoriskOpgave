package Project;

public class Fiction extends Books {

    // You can add more fields specific to Fiction if needed
    private String genre;

    public Fiction(String title, int loan, String author, String genre) {
        super(title, loan, author);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void displayInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + " | Genre: " + genre + "\n";
    }
}