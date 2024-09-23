package StudentGrade_java;
import java.util.Scanner;
import java.util.Random;

public class Studentgrade {
		
		 public static String calculateGrade(double averagePercentage) {
		        if (averagePercentage >= 90) {
		            return "A";
		        } else if (averagePercentage >= 80) {
		            return "B";
		        } else if (averagePercentage >= 70) {
		            return "C";
		        } else if (averagePercentage >= 60) {
		            return "D";
		        } else {
		            return "F";
		        }
		    }

		    // Main method to calculate total marks, average percentage, and grade
		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        // Input the number of subjects
		        System.out.print("Enter the number of subjects: ");
		        int numSubjects = sc.nextInt();

		        // Array to store marks obtained in each subject
		        double[] marksObtained = new double[numSubjects];
		        double totalMarks = 0;

		        // Input the marks for each subject and calculate the total marks
		        for (int i = 0; i < numSubjects; i++) {
		            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
		            marksObtained[i] = sc.nextDouble();
		            totalMarks += marksObtained[i];
		        }

		        // Calculate the average percentage
		        double averagePercentage = totalMarks / numSubjects;

		        // Calculate the grade based on the average percentage
		        String grade = calculateGrade(averagePercentage);

		        // Display the results
		        System.out.println("\nTotal Marks: " + totalMarks);
		        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
		        System.out.println("Grade: " + grade);

		        sc.close();
		   }
}
