import java.util.Scanner;

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num_Subjects;
        int[] Marks;
        double total_Marks = 0;
        double average_Percentage;

        System.out.print("Enter the number of subjects: ");
        num_Subjects = scanner.nextInt();

        Marks = new int[num_Subjects];

        for (int i = 0; i < num_Subjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            Marks[i] = scanner.nextInt();
            total_Marks += Marks[i];
        }

        average_Percentage = total_Marks / num_Subjects;

        System.out.println("\n-------- Results --------");
        System.out.println("Total Marks Obtained: " + total_Marks);
        System.out.println("Average Percentage: " + average_Percentage + "%");
        System.out.println("Grade: " + CalculateGrade(average_Percentage));

        scanner.close();
    }

    public static String CalculateGrade(double Percentage) {
        if (Percentage >= 90) {
            return "A+";
        } else if (Percentage >= 80) {
            return "A";
        } else if (Percentage >= 70) {
            return "B";
        } else if (Percentage >= 60) {
            return "C";
        } else if (Percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}