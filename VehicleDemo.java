
interface Engine {
    void startEngine();
    void stopEngine();
}


class PetrolEngine implements Engine {
    @Override
    public void startEngine() {
        System.out.println("Starting petrol engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping petrol engine...");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void startEngine() {
        System.out.println("Starting electric engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping electric engine...");
    }
}


abstract class Vehicle {
    protected Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    abstract void startVehicle();

    abstract void stopVehicle();
}


class Car extends Vehicle {
    public Car(Engine engine) {
        super(engine);
    }

    @Override
    void startVehicle() {
        System.out.print("Car: ");
        engine.startEngine();
    }

    @Override
    void stopVehicle() {
        System.out.print("Car: ");
        engine.stopEngine();
    }
}

class Motorbike extends Vehicle {
    public Motorbike(Engine engine) {
        super(engine);
    }

    @Override
    void startVehicle() {
        System.out.print("Motorbike: ");
        engine.startEngine();
    }

    @Override
    void stopVehicle() {
        System.out.print("Motorbike: ");
        engine.stopEngine();
    }
}


public class VehicleDemo {
    public static void main(String[] args) {
        Engine petrolEngine = new PetrolEngine();
        Engine electricEngine = new ElectricEngine();

        Vehicle car = new Car(petrolEngine);
        Vehicle motorbike = new Motorbike(electricEngine);

        car.startVehicle();
        car.stopVehicle();

        motorbike.startVehicle();
        motorbike.stopVehicle();
    }
}
