// Step 1: Create an abstract class or interface for Vehicle
interface Vehicle {
    void drive();
}

// Step 2: Implement Concrete Vehicle classes (Car and Bike)
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car!");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike!");
    }
}

// Step 3: Create the VehicleFactory class
abstract class VehicleFactory {
    // Factory Method
    public abstract Vehicle createVehicle(String vehicleType);

    // You can also have a default method that delegates creation
    public Vehicle getVehicle(String vehicleType) {
        return createVehicle(vehicleType);
    }
}

// Step 4: Concrete Factory implementation
class ConcreteVehicleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();  // Return Car object
        } else if (vehicleType.equalsIgnoreCase("Bike")) {
            return new Bike();  // Return Bike object
        }
        
        return null;
    }
}

// Step 5: Test the Factory Method pattern
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        // Create a factory
        VehicleFactory vehicleFactory = new ConcreteVehicleFactory();

        // Create a Car using the factory
        Vehicle vehicle1 = vehicleFactory.getVehicle("Car");
        vehicle1.drive(); // Outputs: Driving a car!

        // Create a Bike using the factory
        Vehicle vehicle2 = vehicleFactory.getVehicle("Bike");
        vehicle2.drive(); // Outputs: Riding a bike!
    }
}
