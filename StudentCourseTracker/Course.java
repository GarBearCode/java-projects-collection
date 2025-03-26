// File: Course.java
// Just a basic Course class used to represent course data
// We'll use this to store name, grade, and number of credits for each course

public class Course implements Comparable<Course> {
    String name;
    String grade;
    int credits;

    public Course(String name, String grade, int credits) {
        this.name = name;
        this.grade = grade;
        this.credits = credits;
    }

    // used for sorting courses alphabetically
    @Override
    public int compareTo(Course other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    // nice readable format for file saving and printing
    @Override
    public String toString() {
        return name + ", " + grade + ", " + credits;
    }
}
