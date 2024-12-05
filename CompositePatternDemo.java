import java.util.ArrayList;
import java.util.List;

interface Employee {
    void showDetails();
}

class IndividualEmployee implements Employee {
    private String name;
    private String position;

    public IndividualEmployee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void showDetails() {
        System.out.println("Employee Name: " + name + ", Position: " + position);
    }
}

class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Add subordinates (employees under this manager)
    public void add(Employee employee) {
        subordinates.add(employee);
    }

    // Remove subordinates
    public void remove(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager Name: " + name + ", Position: " + position);
        System.out.println("Subordinates:");
        for (Employee employee : subordinates) {
            employee.showDetails(); // Display details of all subordinates
        }
    }
}

// Step 4: Main Class to Test the Composite Structure
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create Individual Employees
        Employee employee1 = new IndividualEmployee("John", "Developer");
        Employee employee2 = new IndividualEmployee("Jane", "Tester");

        // Create a Manager
        Manager manager1 = new Manager("Alice", "Engineering Manager");

        // Create another Employee and Manager under the Engineering Manager
        Employee employee3 = new IndividualEmployee("Mike", "Developer");
        Manager manager2 = new Manager("Bob", "Product Manager");

        // Add employees and managers to the hierarchy
        manager1.add(employee1);
        manager1.add(employee2);
        manager1.add(employee3);

        manager2.add(new IndividualEmployee("Sarah", "Designer"));

        // Display the details of the entire hierarchy
        System.out.println("Company Employee Structure:");
        manager1.showDetails();
        manager2.showDetails();
    }
}
