package Project;

import java.util.ArrayList; // liste der kan vokse dynamisk
import java.util.Scanner; // bruges til bruger input

public class LoanTrackerTest {
    // arrays med alle ting man kan låne
    static LoanTracker[] availableBooks = {
            new Fiction("Harry Potter", 14, "J.K. Rowling", "Fiction"),
            new Fiction("The Hobbit", 14, "J.R.R. Tolkien", "Fiction"),
            new Fiction("Wheel of Time", 21, "Robert Jordan", "Fiction"),
            new Fiction("Dune", 21, "Frank Herbert", "Fiction"),
            new Fiction("The Name of Wind", 14, "Patrick Rothfuss", "Fiction")
    };

    static LoanTracker[] availableVideos = {
            new Video("Harry Potter & the prisoners of azkaban", 7, 120),
            new Video("The Hobbit, an unexpected journey", 7, 150),
            new Video("Wheel of Time", 14, 180),
            new Video("Dune part 1", 14, 140)
    };

    static LoanTracker[] availableElectronics = {
            new Electronics("Canon Camera", 7, "Model X"),
            new Electronics("iPad", 14, "Pro 2025"),
            new Electronics("Raspberry Pi", 21, "Model 4B"),
            new Electronics("Arduino Kit", 14, "Model A"),
    };
    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Velkommen til lånesystemet ===");

        // Maks antal man kan låne
        int maxLoans =
                availableBooks.length +
                        availableVideos.length +
                        availableElectronics.length;

        // Spørger hvor mange ting man vil låne og giver en limit
        System.out.println("Hvor mange ting vil du låne? (maks " + maxLoans + ")");
        int totalLoans = Integer.parseInt(sc.nextLine());

        ArrayList<LoanTracker> borrowedItems = new ArrayList<>();

        // while loop der kører indtil du har valgt dine ting
        while (borrowedItems.size() < totalLoans) {

            System.out.println("\nVælg type: book / video / electronics");
            String type = sc.nextLine().toLowerCase();

            LoanTracker[] catalog = getCatalog(type);

            if (catalog == null) {
                System.out.println("Ukendt type.");
                continue;
            }

            printCatalog(catalog);

            System.out.println("Indtast nummer:");
            int choice = Integer.parseInt(sc.nextLine());

            LoanTracker chosen = catalog[choice - 1];
            borrowedItems.add(chosen);

            System.out.println("Tilføjet: " + chosen.getTitle());
        }

        sortByLoan(borrowedItems);

        printSummary(borrowedItems);

    }


    /* Denne metode vælger det rigtige katalog ud fra det man skriver.
    Hvis brugeren skriver "book", får de book-arrayet osv.
    Den returnerer null hvis typen ikke findes, fx hvis du skriver boook */
    static LoanTracker[] getCatalog(String type) {

        if (type.equals("book")) {
            return availableBooks;
        }
        else if (type.equals("video")) {
            return availableVideos;
        }
        else if (type.equals("electronics")) {
            return availableElectronics;
        }
        return null;
    }

    /* Går igennem arrayet med et "for" loop og viser dem med nummer,
     så man kan vælge 1, 2, 3 osv */
    static void printCatalog(LoanTracker[] catalog) {
        for (int i = 0; i < catalog.length; i++) {
            System.out.println((i + 1) + ". " + catalog[i]);
        }
    }

    // bubble sort
    // sorterer items så laveste loan days kommer først
    static void sortByLoan(ArrayList<LoanTracker> items) {
        for (int i = 0; i < items.size() - 1; i++) {
            for (int j = 0; j < items.size() - 1 - i; j++) {
                if (items.get(j).getLoan() > items.get(j + 1).getLoan()) {
                    LoanTracker temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }

    // printer en samlet liste til sidst
    static void printSummary(ArrayList<LoanTracker> items) {
        System.out.println("\n========== Låne Opsummering ==========");
        System.out.println("Du lånte " + items.size() + " Ting sorteret efter udløbsdato:\n");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + items.get(i));
        }
        System.out.println("==================================");
    }
}