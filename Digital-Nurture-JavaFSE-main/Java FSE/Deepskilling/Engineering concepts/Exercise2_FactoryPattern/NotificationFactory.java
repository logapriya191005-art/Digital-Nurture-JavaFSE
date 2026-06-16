public class NotificationFactory {
    // Factory method that returns different Notification objects based on the type
    public static Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) {
            return null;
        }
        
        switch (channel.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification channel: " + channel);
        }
    }
}