package Project;

import java.util.Scanner;
import java.util.Scanner;

public class LoanTrackerTest {

    // "Database" af vores items
    static LoanTracker[] availableBooks = {
            new Books("Harry Potter",       14, "J.K. Rowling"),
            new Books("The Hobbit",      14, "J.R.R. Tolkien"),
            new Books("Wheel of Time",   21, "Rober Jordan"),
            new Books("Dune",            21, "Frank Herbert"),
            new Books("The Name of Wind",14, "Patrick Rothfuss")
    };

    static LoanTracker[] availableVideos = {
            new Video("Harry Potter",    7, "J.K. Rowling"),
            new Video("The Hobbit",      7, "J.R.R. Tolkien"),
            new Video("Wheel of Time",   14, "Rober Jordan"),
            new Video("Dune",            14, "Frank Herbert"),

    };

    static LoanTracker[] availableElectronics = {
            new Electronics("Canon Camera", 7, "J.K. Rowling"),
            new Electronics("ipad",         14, "J.R.R. Tolkien"),
            new Electronics("Raspberry Pi", 21, "Rober Jordan"),
            new Electronics("Arduino Kit",  14, "Frank Herbert"),
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Welcome to the Loan System ===");
        System.out.println("How many items would you like to loan? ");
        int totalLoans = Integer.parseInt(sc.nextLine().trim());

        ArrayList<LoanTracker> borrowedItems = new ArrayList<>();

        // Keep asking until we have all loans
        while (borrowedItems.size() < totalLoans) {
            int remaining = totalLoans - borrowedItems.size();
            System.out.println("\nItems still to loan: " + remaining);
            System.out.print("What type would you like to loan? (book / video / electronics): ");
            String type = sc.nextLine().trim().toLowerCase();

            LoanTracker[] catalog = getCatalog(type);
            if (catalog == null) {
                System.out.println("Unknown type. Please type book, video, or electronics.");
                continue;
            }
        }

        // show the list
        System.out.println("\nAvailable " + type + "s:");
        for (int i = 0; i < catalog.length; i++) {
            System.out.println(" " + (i + 1) + ". " + catalog[i]);
        }

        // Pick a number
        System.out.print("Enter the number of the item you want to loan: ");
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            continue;
        }

        if (choice < 1 || choice > catalog.length) {
            System.out.println("Number out of range, try again.");
            continue;
        }

        LoanTracker chosen = catalog[choice - 1];
        borrowedItems.add(chosen);
        System.out.println("Added: " + chosen.getTitle());
    }

    // Convert list to array and sort
    LoanTracker[] loanedArray = borrowedItems.toArray(new LoanTracker[0]);
    sortByLoan(loanedArray);

    // Print summary
    printSummary(loanedArray);
        sc.close();
}

// Returns the right catalog based on type string
static LoanTracker[] getCatalog(String type) {
    switch (type) {
        case "book":        return availableBooks;
        case "video":       return availableVideos;
        case "electronics": return availableElectronics;
        default:            return null;
    }
}

// Bubble sort by loan duration (shortest first)
static void sortByLoan(LoanTracker[] items) {
    for (int i = 0; i < items.length - 1; i++) {
        for (int j = 0; j < items.length - 1 - i; j++) {
            if (items[j].getLoan() > items[j + 1].getLoan()) {
                LoanTracker temp = items[j];
                items[j]     = items[j + 1];
                items[j + 1] = temp;
            }
        }
    }
}

// Summary printout
static void printSummary(LoanTracker[] items) {
    System.out.println("\n========== LOAN SUMMARY ==========");
    System.out.println("You borrowed " + items.length + " item(s), sorted by expiry:\n");
    for (int i = 0; i < items.length; i++) {
        System.out.println("  " + (i + 1) + ". " + items[i]);
    }
    System.out.println("==================================");
}


