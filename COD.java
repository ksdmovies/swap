import java.util.ArrayList;
import java.util.List;

interface Employee {
    void showDetails();
    void performTask(String task);
}

class Worker implements Employee {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name);
    }

    @Override
    public void performTask(String task) {
        System.out.println(name + " is performing task: " + task);
    }
}

class Manager implements Employee {
    private String name;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name);
        for (Employee employee : subordinates) {
            employee.showDetails();
        }
    }

    @Override
    public void performTask(String task) {
        System.out.println(name + " is delegating task: " + task);
        for (Employee employee : subordinates) {
            employee.performTask(task);
        }
    }
}

public class COD {
    public static void main(String[] args) {
        Employee worker1 = new Worker("Alice");
        Employee worker2 = new Worker("Bob");

        Manager manager1 = new Manager("John");
        manager1.addSubordinate(worker1);
        manager1.addSubordinate(worker2);

        Manager generalManager = new Manager("Sara");
        generalManager.addSubordinate(manager1);

        generalManager.showDetails();
        generalManager.performTask("Prepare Annual Report");
    }
}
