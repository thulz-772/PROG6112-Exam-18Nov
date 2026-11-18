package question1;

// The Product class holds sales data and calculates report values
// It uses 1D array for names and 2D array for sales [product][month]
public class Product implements IProduct {
    private String[] productNames;
    private int[][] productSales; 

    // Constructor - receives data from Main
    public Product(String[] productNames, int[][] productSales) {
        this.productNames = productNames;
        this.productSales = productSales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                total += productSales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int numberOfEntries = productSales.length * productSales[0].length;
        return (double) total / numberOfEntries;
    }

    @Override
    public String GetMostPopularProduct() {
        int highestTotal = -1;
        int popularIndex = 0;

        // Now Finding product with the highest TOTAL sales (not single month)
        for (int i = 0; i < productSales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < productSales[i].length; j++) {
                productTotal += productSales[i][j];
            }
            if (productTotal > highestTotal) {
                highestTotal = productTotal;
                popularIndex = i;
            }
        }
        return productNames[popularIndex] + " (" + highestTotal + ")";
    }
}