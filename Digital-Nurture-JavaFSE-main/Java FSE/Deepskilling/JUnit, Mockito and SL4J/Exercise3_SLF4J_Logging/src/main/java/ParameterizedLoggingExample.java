import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);
    
    public static void main(String[] args) {
        String username = "john_doe";
        int age = 25;
        double salary = 50000.50;
        
        // Parameterized logging using {} placeholders (More efficient than string concatenation)
        logger.info("User {} is {} years old with salary ${}", username, age, salary);
        
        // Error logging with parameters
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Error occurred while processing user {}: {}", username, e.getMessage());
        }
    }
}