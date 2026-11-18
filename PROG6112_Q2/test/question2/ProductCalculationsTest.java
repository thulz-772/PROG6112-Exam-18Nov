package question2;

import org.junit.Test;
import static org.junit.Assert.*;

// Unit tests for ProductCalculations - Q2.6 - JUnit 4  for Ant
public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(525.0, calc.GetVat(), 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(4200.0, calc.GetTotal(), 0.001);
    }
}