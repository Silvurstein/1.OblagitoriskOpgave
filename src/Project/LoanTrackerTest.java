package Project;

public class LoanTrackerTest {
    public static void main(String[] args) {
        System.out.println("Velkommen\n\nMenu:\n1. Lån\n2. Bøder");
    }

    // ---------------------------------------
    // Sort by Loan (lowest first)
    // ---------------------------------------
    public static void sortByLoan(Student[] students) {

        for (int i = 0; i < students.length - 1; i++) {

            for (int j = 0; j < students.length - 1; j++) {

                // If first student is older → swap
                if (students[j].getAge() > students[j + 1].getAge()) {

                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
}
