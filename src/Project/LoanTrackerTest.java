package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class LoanTrackerTest {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n==== Velkommen til lånesystemet ===");
        System.out.println("Hvor mange ting vil du gerne låne? ");
        int totalLoans = Integer.parseInt(sc.nextLine().trim());

        ArrayList<LoanTracker> borrowedItems = new ArrayList<>();
        String type = "";

        while (borrowedItems.size() < totalLoans) {
            int remaining = totalLoans - borrowedItems.size();
            System.out.println("\nTing du mangler at låne: " + remaining);
            System.out.print("Hvilken type vil du gerne låne? (book / video / electronics): ");
            type = sc.nextLine().trim().toLowerCase();

            LoanTracker[] catalog = getCatalog(type);
            if (catalog == null) {
                System.out.println("Ukendt type, Skriv book, video, eller electronics.");
                continue;
            }

            // show the list
            System.out.println("\nTilgængelige " + type + "s");
            for (int i = 0; i < catalog.length; i++) {
                System.out.println(" " + (i + 1) + ". " + catalog[i]);
            }

            // Pick a number
            System.out.print("Indtast nummeret på den ting du gerne vil låne: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Indtast venligts et gyldigt nr.");
                continue;
            }

            if (choice < 1 || choice > catalog.length) {
                System.out.println("Nummeret er ude af rækkevide, prøv igen");
                continue;
            }

            LoanTracker chosen = catalog[choice - 1];
            borrowedItems.add(chosen);
            System.out.println("Tilføjet: " + chosen.getTitle());
        }

        // Convert list to array and sort
        LoanTracker[] loanedArray = borrowedItems.toArray(new LoanTracker[0]);
        sortByLoan(loanedArray);

        // Print summary
        printSummary(loanedArray);
        sc.close();
    }

    static LoanTracker[] getCatalog(String type) {
        switch (type) {
            case "book": return availableBooks;
            case "video": return availableVideos;
            case "electronics": return availableElectronics;
            default: return null;
        }
    }

    static void sortByLoan(LoanTracker[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - 1 - i; j++) {
                if (items[j].getLoan() > items[j + 1].getLoan()) {
                    LoanTracker temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
    }

    static void printSummary(LoanTracker[] items) {
        System.out.println("\n========== Låne Opsummering ==========");
        System.out.println("Du lånte " + items.length + " Ting sorteret efter udløbsdato:\n");
        for (int i = 0; i < items.length; i++) {
            System.out.println("  " + (i + 1) + ". " + items[i]);
        }
        System.out.println("==================================");
    }
}
