// File: Expense.java
// Just a basic class that holds expense info
// Will be used to store category and amount spent

public class Expense {
    String category;
    double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    // nice format for printing
    public String toString() {
        return category + ": $" + amount;
    }
}
