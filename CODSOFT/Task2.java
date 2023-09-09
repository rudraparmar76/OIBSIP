import java.util.Scanner;

public class Task2 {
    static void displayResult(float avg, int roll, String grade, String name) {

        centerHeader("=====Result of " + name + "=====");
        System.out.println("\n");

        System.out.println("==Roll no: " + roll);
        System.out.println("\n");

        System.out.println("==Average Percentage: " + avg + "%");
        System.out.println("\n");

        System.out.println("==Grade: " + grade);
        System.out.println("\n");

    }

    static void centerHeader(String header) {
        int consoleWidth = 150; // Change this to match your console's width

        int spacesCount = (consoleWidth - header.length()) / 2;
        String centeredHeader = " ".repeat(spacesCount) + header;

        System.out.println(centeredHeader);
    }

    public static void main(String[] args) {
        int eng, maths, sci, evs, rollno;
        String grade = "", name;

        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        String message = "Welcome to Result Section";
        int boxWidth = message.length() + 4;

        centerHeader("╔" + "═".repeat(boxWidth - 2) + "╗");
        centerHeader("║ " + message + " ║ ");
        centerHeader("╚" + "═".repeat(boxWidth - 2) + "╝");
        System.out.println("==Enter your full name:");
        name = input.nextLine();
        System.out.println("\n");

        System.out.println("==Enter your roll number:");
        rollno = input.nextInt();
        System.out.println("\n");

        while (true) {
            System.out.print("==Enter your English marks: ");
            eng = input.nextInt();
            System.out.println("\n");

            System.out.print("==Enter your Maths marks: ");
            maths = input.nextInt();
            System.out.println("\n");

            System.out.print("==Enter your Science marks: ");
            sci = input.nextInt();
            System.out.println("\n");

            System.out.print("==Enter your EVS marks: ");
            evs = input.nextInt();
            System.out.println("\n");

            if ((eng >= 0 && eng <= 100) && (maths >= 0 && maths <= 100) && (sci >= 0 && sci <= 100)
                    && (evs >= 0 && evs <= 100)) {
                float sum = eng + maths + sci + evs;
                float avg = sum / 4f;

                if (avg >= 93.50 && avg <= 100) {
                    grade = "A";
                } else if (avg >= 89.50 && avg <= 93.49) {
                    grade = "A-";
                } else if (avg >= 86.50 && avg <= 89.49) {
                    grade = "B+";
                } else if (avg >= 82.50 && avg <= 86.49) {
                    grade = "B";
                } else if (avg >= 79.50 && avg <= 82.49) {
                    grade = "B-";
                } else if (avg >= 76.50 && avg <= 79.49) {
                    grade = "C+";
                } else if (avg >= 72.50 && avg <= 76.49) {
                    grade = "C";
                } else if (avg >= 69.50 && avg <= 72.49) {
                    grade = "C-";
                } else if (avg >= 66.50 && avg <= 69.49) {
                    grade = "D+";
                } else if (avg >= 62.50 && avg <= 66.49) {
                    grade = "D";
                } else if (avg >= 59 && avg <= 62.49) {
                    grade = "D-";
                } else if (avg >= 0 && avg <= 59) {
                    grade = "F";
                }
                displayResult(avg, rollno, grade, name);
                break;
            } else {
                System.out.println("==Invalid Marks Entered");
                System.out.println("\n");

                System.out.println("==Please enter valid marks:");
                System.out.println("\n");

            }
        }
        input.close();
    }
}
