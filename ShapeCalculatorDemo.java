// Step 1: Define the Shape interface with a method to calculate the area
interface Shape {
    double area();
}

// Step 2: Implement concrete shape classes

// Circle class
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Triangle class (new shape added)
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// Step 3: ShapeCalculator that can work with any Shape object
class ShapeCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}

// Step 4: Test the functionality with different shapes
public class ShapeCalculatorDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(10, 20);
        Shape triangle = new Triangle(8, 5);

        ShapeCalculator calculator = new ShapeCalculator();

        System.out.println("Area of Circle: " + calculator.calculateArea(circle));
        System.out.println("Area of Rectangle: " + calculator.calculateArea(rectangle));
        System.out.println("Area of Triangle: " + calculator.calculateArea(triangle));
    }
}
