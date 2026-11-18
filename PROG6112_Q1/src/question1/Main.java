package question1;

import java.util.Scanner;

// Main class - it handles user input using 1D and 2D arrays
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1D array for product names
        String[] productNames = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        // 2D array: 3 products times 3 months
        int[][] productSales = new int[3][3];

        // Collecting sales data from user
        for (int i = 0; i < productNames.length; i++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month " + (month + 1) + " for " + productNames[i] + ": ");
                productSales[i][month] = input.nextInt();
            }
            System.out.println(); // Blank line in between products
        }

        // Now to Create Product and PrintProduct objects
        Product product = new Product(productNames, productSales);
        PrintProduct printer = new PrintProduct();

        // Overall Display report
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("************************************");
        printer.printTotalProductSales(product);
        printer.printAverageProductSales(product);
        printer.printMostPopularProduct(product);

        input.close();
    }
}