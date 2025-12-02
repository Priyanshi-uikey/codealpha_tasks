import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== STUDENT GRADE TRACKER =====");

        while (true) {
            System.out.print("\nEnter student name (or type 'exit' to finish): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) break;

            System.out.print("Enter marks for " + name + ": ");
            int marks = sc.nextInt();
            sc.nextLine();  // For buffer clear

            students.add(new Student(name, marks));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            return;
        }

        // Calculate stats
        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (Student s : students) {
            int score = s.getScore();
            total += score;

            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }

        double average = (double) total / students.size();

        // Output Summary
        System.out.println("\n===== SUMMARY REPORT =====");
        for (Student s : students) {
            System.out.println("Student: " + s.getName() + " | Score: " + s.getScore());
        }

        System.out.println("\nTotal students: " + students.size());
        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);

        System.out.println("\nTask Completed Successfully!");
    }
}
