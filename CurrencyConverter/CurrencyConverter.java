// File: CurrencyConverter.java
// One file since the logic is small and self-contained

import java.util.*;

public class CurrencyConverter {
    static final Map<String, Double> rates = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rates.put("USD", 1.0);
        rates.put("EUR", 0.92);
        rates.put("JPY", 150.0);
        rates.put("INR", 83.0);

        while (true) {
            System.out.print("From currency (USD, EUR, JPY, INR or Q to quit): ");
            String from = scanner.next().toUpperCase();
            if (from.equals("Q")) break;

            System.out.print("To currency: ");
            String to = scanner.next().toUpperCase();

            if (!rates.containsKey(from) || !rates.containsKey(to)) {
                System.out.println("Invalid currency input.");
                continue;
            }

            System.out.print("Amount: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid number. Try again.");
                scanner.next();
                continue;
            }
            double amount = scanner.nextDouble();

            double result = convert(from, to, amount);
            System.out.printf("Converted amount: %.2f %s\n", result, to);
        }
        scanner.close();
    }

    static double convert(String from, String to, double amount) {
        return amount / rates.get(from) * rates.get(to);
    }
}

