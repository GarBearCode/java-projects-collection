// File: ExpenseTracker.java
// Main logic for the Expense Tracker program

import java.util.*;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>(); // where we store all expenses

        while (true) {
            // simple options for interacting with the tool
            System.out.println("\n1. Add Expense\n2. View All\n3. Category Report\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // input a new expense
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                expenses.add(new Expense(category, amount));

            } else if (choice == 2) {
                // show everything recorded so far
                for (Expense e : expenses) {
                    System.out.println(e);
                }

            } else if (choice == 3) {
                // totals by category (like a basic report)
                HashMap<String, Double> totals = new HashMap<>();
                for (Expense e : expenses) {
                    totals.put(e.category, totals.getOrDefault(e.category, 0.0) + e.amount);
                }
                for (String cat : totals.keySet()) {
                    System.out.println(cat + ": $" + totals.get(cat));
                }

            } else if (choice == 4) {
                break; // quit the program
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
