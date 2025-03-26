// File: StudentCourseTracker.java
// Main logic for the Student Course Tracker project

import java.io.*;
import java.util.*;

public class StudentCourseTracker {
    static final String FILE_NAME = "courses.txt"; // file where we'll save course data

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courseList = loadCourses(); // load from file if it exists

        while (true) {
            // simple menu loop so user can interact
            System.out.println("\n1. Add Course\n2. View Courses\n3. Search Course\n4. Save and Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // gather new course info from user
                System.out.print("Course name: ");
                String name = scanner.nextLine();
                System.out.print("Grade: ");
                String grade = scanner.nextLine();
                System.out.print("Credits: ");
                int credits = scanner.nextInt();
                scanner.nextLine();
                courseList.add(new Course(name, grade, credits)); // add to list

            } else if (choice == 2) {
                // sort and display all courses
                Collections.sort(courseList);
                for (Course c : courseList) {
                    System.out.println(c);
                }

            } else if (choice == 3) {
                // simple course search by name
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
                // save before exiting
                saveCourses(courseList);
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    // try to load course data from file if it exists
    static ArrayList<Course> loadCourses() throws IOException {
        ArrayList<Course> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list; // no saved file, just return empty list

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

    // saves all current courses to file in simple format
    static void saveCourses(ArrayList<Course> list) throws IOException {
        PrintWriter out = new PrintWriter(FILE_NAME);
        for (Course c : list) {
            out.println(c);
        }
        out.close();
    }
}
