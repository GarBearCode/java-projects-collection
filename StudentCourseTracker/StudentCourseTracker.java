// File: StudentCourseTracker.java
// Main logic for the Student Course Tracker project

import java.io.*;
import java.util.*;

public class StudentCourseTracker {
    static final String FILE_NAME = "courses.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courseList = loadCourses();

        while (true) {
            System.out.println("\n1. Add Course\n2. View Courses\n3. Search Course\n4. Save and Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Course name: ");
                String name = scanner.nextLine();
                System.out.print("Grade: ");
                String grade = scanner.nextLine();
                System.out.print("Credits: ");
                int credits = scanner.nextInt();
                scanner.nextLine();
                courseList.add(new Course(name, grade, credits));
            } else if (choice == 2) {
                Collections.sort(courseList);
                for (Course c : courseList) {
                    System.out.println(c);
                }
            } else if (choice == 3) {
                System.out.print("Enter course name to search: ");
                String search = scanner.nextLine();
                boolean found = false;
                for (Course c : courseList) {
                    if (c.name.equalsIgnoreCase(search)) {
                        System.out.println("Found: " + c);
                        found = true;
                    }
                }
                if (!found) System.out.println("Course not found.");
            } else if (choice == 4) {
                saveCourses(courseList);
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    static ArrayList<Course> loadCourses() throws IOException {
        ArrayList<Course> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String[] parts = fileScanner.nextLine().split(", ");
            if (parts.length == 3) {
                list.add(new Course(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        }
        fileScanner.close();
        return list;
    }

    static void saveCourses(ArrayList<Course> list) throws IOException {
        PrintWriter out = new PrintWriter(FILE_NAME);
        for (Course c : list) {
            out.println(c);
        }
        out.close();
    }
}
