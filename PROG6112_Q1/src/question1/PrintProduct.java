package question1;

// PrintProduct class - only for printing the report
public class PrintProduct {

    // Printing the total product sales
    public void printTotalProductSales(Product product) {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Printing the average product sales
    public void printAverageProductSales(Product product) {
        // Cast to int for display to match sample: 17 not 17.0
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
    }

    // Printing the most popular product
    public void printMostPopularProduct(Product product) {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}