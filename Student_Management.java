package StudentManagement_java;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
	
// Student class to represent individual students
class Student implements Serializable {
	private String name;
	private int rollNumber;
	private String grade;
	
	public Student(String name, int rollNumber, String grade) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Student [Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade + "]";
	}
}

	// StudentManagementSystem class to manage the collection of students
class StudentManagementSystem {
	private ArrayList<Student> students;
    private static final String FILE_NAME = "students.dat";
	    
    public StudentManagementSystem() {
	        students = new ArrayList<>();
	        loadStudentsFromFile(); // Load students from file when system starts
	    }

	    // Add a student
	    public void addStudent(String name, int rollNumber, String grade) {
	        Student newStudent = new Student(name, rollNumber, grade);
	        students.add(newStudent);
	        System.out.println("Student added successfully.");
	        saveStudentsToFile();
	    }

	    // Remove a student by roll number
	    public void removeStudent(int rollNumber) {
	        boolean removed = students.removeIf(student -> student.getRollNumber() == rollNumber);
	        if (removed) {
	            System.out.println("Student removed successfully.");
	        } else {
	            System.out.println("Student not found.");
	        }
	        saveStudentsToFile();
	    }

	    // Search for a student by roll number
	    public Student searchStudent(int rollNumber) {
	        for (Student student : students) {
	            if (student.getRollNumber() == rollNumber) {
	                return student;
	            }
	        }
	        return null;
	    }

	    // Display all students
	    public void displayAllStudents() {
	        if (students.isEmpty()) {
	            System.out.println("No students to display.");
	        } else {
	            System.out.println("Student List:");
	            for (Student student : students) {
	                System.out.println(student);
	            }
	        }
	    }

	    // Save student data to file
	    private void saveStudentsToFile() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
	            oos.writeObject(students);
	        } catch (IOException e) {
	            System.out.println("Error saving students to file.");
	        }
	    }

	    // Load student data from file
	    private void loadStudentsFromFile() {
	        File file = new File(FILE_NAME);
	        if (file.exists()) {
	            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
	                students = (ArrayList<Student>) ois.readObject();
	            } catch (IOException | ClassNotFoundException e) {
	                System.out.println("Error loading students from file.");
	            }
	        }
	    }
	}

	// Main class for user interface
	public class Student_Management {
	    private static StudentManagementSystem managementSystem = new StudentManagementSystem();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        while (true) {
	            showMenu();
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume newline
	            switch (choice) {
	                case 1:
	                    addStudent();
	                    break;
	                case 2:
	                    removeStudent();
	                    break;
	                case 3:
	                    searchStudent();
	                    break;
	                case 4:
	                    managementSystem.displayAllStudents();
	                    break;
	                case 5:
	                    System.out.println("Exiting the system. Goodbye!");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    // Show menu options to the user
	    private static void showMenu() {
	        System.out.println("\nStudent Management System");
	        System.out.println("1. Add Student");
	        System.out.println("2. Remove Student");
	        System.out.println("3. Search Student");
	        System.out.println("4. Display All Students");
	        System.out.println("5. Exit");
	        System.out.print("Choose an option: ");
	    }

	    // Get user input for adding a new student
	    private static void addStudent() {
	        System.out.print("Enter Student Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter Roll Number: ");
	        int rollNumber = scanner.nextInt();
	        scanner.nextLine();  // Consume newline
	        System.out.print("Enter Grade: ");
	        String grade = scanner.nextLine();
	        managementSystem.addStudent(name, rollNumber, grade);
	    }

	    // Get user input for removing a student
	    private static void removeStudent() {
	        System.out.print("Enter Roll Number of Student to Remove: ");
	        int rollNumber = scanner.nextInt();
	        managementSystem.removeStudent(rollNumber);
	    }

	    // Get user input for searching a student
	    private static void searchStudent() {
	        System.out.print("Enter Roll Number of Student to Search: ");
	        int rollNumber = scanner.nextInt();
	        Student student = managementSystem.searchStudent(rollNumber);
	        if (student != null) {
	            System.out.println("Student Found: " + student);
	        } else {
	            System.out.println("Student not found.");
	        }
	    }
	}
