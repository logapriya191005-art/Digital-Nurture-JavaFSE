public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");

        // Create an Email notification using the factory
        Notification emailNotif = NotificationFactory.createNotification("EMAIL");
        if (emailNotif != null) {
            emailNotif.notifyUser();
        }

        // Create an SMS notification using the factory
        Notification smsNotif = NotificationFactory.createNotification("SMS");
        if (smsNotif != null) {
            smsNotif.notifyUser();
        }

        // Create a Push notification using the factory
        Notification pushNotif = NotificationFactory.createNotification("PUSH");
        if (pushNotif != null) {
            pushNotif.notifyUser();
        }

        System.out.println("\n=== Analysis ===");
        System.out.println("The Factory Pattern allows us to create objects without exposing the creation logic to the client.");
        System.out.println("The client just asks the factory for 'EMAIL' or 'SMS', and the factory returns the correct object.");
        System.out.println("This follows the Open-Closed Principle (OCP) - we can add new notification types without changing existing code.");
    }
}
