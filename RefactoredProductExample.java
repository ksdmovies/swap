// Step 1: Create a Product class to hold product-related information
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Step 2: Create a TaxCalculator class to handle tax calculations
class TaxCalculator {
    private static final double TAX_RATE = 0.15; // Example tax rate

    public double calculateTax(Product product) {
        return product.getPrice() * TAX_RATE;
    }

    public double calculateTotalPrice(Product product) {
        return product.getPrice() + calculateTax(product);
    }
}

// Step 3: Use the classes in a main method
public class RefactoredProductExample {
    public static void main(String[] args) {
        Product product = new Product("Laptop", 1000.00);
        TaxCalculator taxCalculator = new TaxCalculator();

        double tax = taxCalculator.calculateTax(product);
        double totalPrice = taxCalculator.calculateTotalPrice(product);

        System.out.println("Product: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Tax: " + tax);
        System.out.println("Total Price: " + totalPrice);
    }
}
