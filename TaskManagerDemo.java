// Interface for Task Creation
interface TaskCreation {
    void createTask(String taskName);
    void deleteTask(String taskName);
}

// Interface for Task Assignment
interface TaskAssignment {
    void assignTask(String taskName, String assignee);
}

// Interface for Task Completion
interface TaskCompletion {
    void markTaskAsComplete(String taskName);
}

// Concrete class implementing only TaskCreation interface
class TaskCreator implements TaskCreation {

    @Override
    public void createTask(String taskName) {
        System.out.println("Task " + taskName + " created.");
    }

    @Override
    public void deleteTask(String taskName) {
        System.out.println("Task " + taskName + " deleted.");
    }
}

// Concrete class implementing only TaskAssignment interface
class TaskAssigner implements TaskAssignment {

    @Override
    public void assignTask(String taskName, String assignee) {
        System.out.println("Task " + taskName + " assigned to " + assignee + ".");
    }
}

// Concrete class implementing only TaskCompletion interface
class TaskCompleter implements TaskCompletion {

    @Override
    public void markTaskAsComplete(String taskName) {
        System.out.println("Task " + taskName + " marked as complete.");
    }
}

// Test class to demonstrate usage
public class TaskManagerDemo {
    public static void main(String[] args) {
        TaskCreation taskCreator = new TaskCreator();
        TaskAssignment taskAssigner = new TaskAssigner();
        TaskCompletion taskCompleter = new TaskCompleter();

        taskCreator.createTask("Design database schema");
        taskAssigner.assignTask("Design database schema", "John Doe");
        taskCompleter.markTaskAsComplete("Design database schema");
    }
}
