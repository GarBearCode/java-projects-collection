// File: Expense.java
// Just a basic class that holds expense info

public class Expense {
    String category;
    double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return category + ": $" + amount;
    }
}
