// Step 1: Create a base Pizza class
interface Pizza {
    String getDescription();
    double cost();
}

// Step 2: Implement a basic pizza (ConcreteComponent)
class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double cost() {
        return 5.00; // Base cost for a plain pizza
    }
}

// Step 3: Create the PizzaDecorator class (Abstract Decorator)
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double cost() {
        return pizza.cost();
    }
}

// Step 4: Create the Topping decorators

// Cheese Topping Decorator
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double cost() {
        return pizza.cost() + 1.50; // Additional cost for cheese
    }
}

// Olives Topping Decorator
class OlivesDecorator extends PizzaDecorator {
    public OlivesDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double cost() {
        return pizza.cost() + 1.00; // Additional cost for olives
    }
}

// Mushrooms Topping Decorator
class MushroomsDecorator extends PizzaDecorator {
    public MushroomsDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double cost() {
        return pizza.cost() + 2.00; // Additional cost for mushrooms
    }
}

// Step 5: Demo class to test the decorators
public class PizzaDecoratorDemo {
    public static void main(String[] args) {
        Pizza myPizza = new BasicPizza(); // Start with a basic pizza
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.cost());

        // Add cheese
        myPizza = new CheeseDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.cost());

        // Add olives
        myPizza = new OlivesDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.cost());

        // Add mushrooms
        myPizza = new MushroomsDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.cost());
    }
}
