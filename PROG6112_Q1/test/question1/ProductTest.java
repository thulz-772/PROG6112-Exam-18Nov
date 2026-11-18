package question1;

import org.junit.Test;
import static org.junit.Assert.*;

// Unit tests for Product class - Q1.4 - JUnit 4 for Ant
public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        // Arrange - sample data from question paper
        String[] names = {"Cozy Nights Monarch mattress", "Restonic Barbados mattress", "Sealy Phuket mattress"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        Product product = new Product(names, sales);

        // Act + Assert - total should be 153
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Arrange - sample data from question paper
        String[] names = {"Cozy Nights Monarch mattress", "Restonic Barbados mattress", "Sealy Phuket mattress"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        Product product = new Product(names, sales);

        // Act + Assert - average should be 17.0 (153 / 9)
        assertEquals(17.0, product.GetAverageProductSold(), 0.001);
    }
}
// Note: I used AI To Help With The Test File Class