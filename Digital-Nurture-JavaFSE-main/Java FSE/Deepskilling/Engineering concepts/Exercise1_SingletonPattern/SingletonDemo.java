public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("--- First Request ---");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.executeQuery("SELECT * FROM users");

        System.out.println("\n--- Second Request ---");
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.executeQuery("SELECT * FROM products");

        System.out.println("\n--- Verification ---");
        System.out.println("Are db1 and db2 the exact same object in memory? " + (db1 == db2));
    }
}