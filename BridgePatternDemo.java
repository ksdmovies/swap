
interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
    void drawRectangle(double x, double y, double width, double height);
}

class DrawingAPI1 implements DrawingAPI {

    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing Circle using DrawingAPI1 at (" + x + "," + y + ") with radius " + radius);
    }

    public void drawRectangle(double x, double y, double width, double height) {
        System.out.println("Drawing Rectangle using DrawingAPI1 at (" + x + "," + y + ") with width " + width + " and height " + height);
    }
}

// Step 3: Implement DrawingAPI2 (ConcreteImplementor)
class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing Circle using DrawingAPI2 at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawRectangle(double x, double y, double width, double height) {
        System.out.println("Drawing Rectangle using DrawingAPI2 at (" + x + "," + y + ") with width " + width + " and height " + height);
    }
}

abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();  // Abstract method to draw the shape
    public abstract void resize(double factor);  // Abstract method to resize the shape
}

class Circle extends Shape {
    private double x, y, radius;

    public Circle(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }

    public void resize(double factor) {
        radius *= factor;
    }
}

class Rectangle extends Shape {
    private double x, y, width, height;

    public Rectangle(double x, double y, double width, double height, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw() {
        drawingAPI.drawRectangle(x, y, width, height);
    }

    public void resize(double factor) {
        width *= factor;
        height *= factor;
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {
        DrawingAPI drawingAPI1 = new DrawingAPI1();
        DrawingAPI drawingAPI2 = new DrawingAPI2();

        Shape circle1 = new Circle(1, 2, 3, drawingAPI1);
        Shape rectangle1 = new Rectangle(5, 5, 4, 6, drawingAPI1);
        
        Shape circle2 = new Circle(2, 3, 4, drawingAPI2);
        Shape rectangle2 = new Rectangle(6, 7, 3, 8, drawingAPI2);

        System.out.println("Drawing with DrawingAPI1:");
        circle1.draw();
        rectangle1.draw();

        System.out.println("\nAfter resizing shapes:");
        circle1.resize(1.5);
        rectangle1.resize(1.5);

        circle1.draw();
        rectangle1.draw();

        System.out.println("\nDrawing with DrawingAPI2:");
        circle2.draw();
        rectangle2.draw();
    }
}
