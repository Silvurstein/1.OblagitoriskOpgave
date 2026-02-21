package Project;

import java.util.Scanner;

public class LoanTrackerTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = askForCount(sc);

        LoanTracker[] loanTrackerArray = createLoanTrackerArray(sc, count);

        printLoanTracker(loanTrackerArray);

        sortByLoan(loanTrackerArray);

        System.out.println("\n--- Sorted by loan ---");
        printLoanTracker(loanTrackerArray);

        sc.close();
    }

    // Ask user for number of furniture items
    public static int askForCount(Scanner sc) {

        int count = 0;

        while (true) {
            System.out.print("How many items do you want to lend ");

            if (sc.hasNextInt()) {
                count = sc.nextInt();
                sc.nextLine();

                if (count > 0) break;
                else System.out.println("Enter a positive number!");
            } else {
                System.out.println("Invalid number!");
                sc.nextLine();
            }
        }

        return count;
    }

    // Create furniture objects
    public static LoanTracker[] createLoanTrackerArray(Scanner sc, int count) {

        LoanTracker[] arr = new LoanTracker[count];

        for (int i = 0; i < count; i++) {

            System.out.println("\nType (book/video/electronics): ");
            String type = sc.nextLine();

            System.out.print("title: ");
            String title = sc.nextLine();

            System.out.print("loan: ");
            int loan = sc.nextInt();
            sc.nextLine();



            if (type.equalsIgnoreCase("books")) {

                System.out.println("Enter Author");
                String author = sc.nextLine();

                arr[i] = new Books(title, loan, author);

            } else if (type.equalsIgnoreCase("Video")) {

                arr[i] = new Video(title, loan);

            } else if (type.equalsIgnoreCase("electronics")) {

                arr[i] = new Electronics(title, loan, 3);

            } else {

                System.out.println("Unknown type. Defaulting to Chair.");
                arr[i] = new Books(title, loan, 4);
            }
        }

        return arr;
    }

    // Print array
    public static void printLoanTracker(LoanTracker[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // Manual bubble sort by price
    public static void sortByLoan(LoanTracker[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j].getLoan() > arr[j + 1].getLoan()) {

                    LoanTracker temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


}





