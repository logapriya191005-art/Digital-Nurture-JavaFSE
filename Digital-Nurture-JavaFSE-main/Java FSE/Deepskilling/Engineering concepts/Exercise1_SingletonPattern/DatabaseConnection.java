public class DatabaseConnection {
    // This holds our single instance
    private static DatabaseConnection instance;

    // Private constructor so no one can create a new object using 'new'
    private DatabaseConnection() {
        System.out.println("Connecting to the database...");
    }

    // Public method to get the single instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }
}