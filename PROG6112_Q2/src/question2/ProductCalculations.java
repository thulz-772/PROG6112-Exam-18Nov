package question2;

// ProductCalculations - calculates VAT, Commission and Total - Q2.5
public class ProductCalculations implements IProductCalculations {
    private double price;

    // Constructor - receives product price
    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        return price * 0.15;
    }

    @Override
    public double GetCommission() {
        return price * 0.05;
    }

    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}