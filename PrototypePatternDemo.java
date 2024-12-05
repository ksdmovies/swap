// Step 1: Define the Shape interface with a clone method
interface Shape extends Cloneable {
    Shape clone();
    void draw();
}

// Step 2: Implement Concrete Classes (Circle and Rectangle)

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        try {
            // Cloning the current Circle object
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius: " + radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

class Rectangle implements Shape {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public Shape clone() {
        try {
            // Cloning the current Rectangle object
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with length: " + length + " and width: " + width);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

// Step 3: Prototype Pattern Demo
public class PrototypePatternDemo {
    public static void main(String[] args) {
        // Create a Circle and clone it
        Circle circle1 = new Circle(5);
        circle1.draw();
        
        // Clone the circle and modify the cloned object
        Circle circle2 = (Circle) circle1.clone();
        circle2.setRadius(10);
        circle2.draw();

        // Create a Rectangle and clone it
        Rectangle rectangle1 = new Rectangle(10, 5);
        rectangle1.draw();
        
        // Clone the rectangle and modify the cloned object
        Rectangle rectangle2 = (Rectangle) rectangle1.clone();
        rectangle2.setLength(20);
        rectangle2.draw();
    }
}
