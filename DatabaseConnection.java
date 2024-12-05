public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    
    private DatabaseConnection() {
        System.out.println("Database Connection Established.");
    }

    public static DatabaseConnection getConnection() {
        if (instance == null) {  // First check (before synchronizing)
            synchronized (DatabaseConnection.class) {
                if (instance == null) {  // Second check (after synchronizing)
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
    
    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getConnection();
        connection1.connect();
        
        DatabaseConnection connection2 = DatabaseConnection.getConnection();
        connection2.connect();
        
        System.out.println(connection1 == connection2);  
    }
}
