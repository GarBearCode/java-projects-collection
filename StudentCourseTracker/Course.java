// File: Course.java
// Just a basic Course class used to represent course data

public class Course implements Comparable<Course> {
    String name;
    String grade;
    int credits;

    public Course(String name, String grade, int credits) {
        this.name = name;
        this.grade = grade;
        this.credits = credits;
    }

    @Override
    public int compareTo(Course other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + ", " + grade + ", " + credits;
    }
}
