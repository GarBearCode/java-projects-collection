// File: CurrencyConverter.java
// One file since the logic is small and self-contained
// Converts between predefined currencies using static rates

import java.util.*;

public class CurrencyConverter {
    static final Map<String, Double> rates = new HashMap<>(); // map of exchange rates

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // setup basic exchange rates
        rates.put("USD", 1.0);
        rates.put("EUR", 0.92);
        rates.put("JPY", 150.0);
        rates.put("INR", 83.0);

        while (true) {
            // user inputs "from" and "to" currencies
            System.out.print("From currency (USD, EUR, JPY, INR or Q to quit): ");
            String from = scanner.next().toUpperCase();
            if (from.equals("Q")) break;

            System.out.print("To currency: ");
            String to = scanner.next().toUpperCase();

            // quick check for invalid inputs
            if (!rates.containsKey(from) || !rates.containsKey(to)) {
                System.out.println("Invalid currency input.");
                continue;
            }

            // ask for the amount to convert
            System.out.print("Amount: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid number. Try again.");
                scanner.next();
                continue;
            }
            double amount = scanner.nextDouble();

            // do the conversion and print it
            double result = convert(from, to, amount);
            System.out.printf("Converted amount: %.2f %s\n", result, to);
        }
        scanner.close();
    }

    // basic conversion using formula: (amount / fromRate) * toRate
    static double convert(String from, String to, double amount) {
        return amount / rates.get(from) * rates.get(to);
    }
}
