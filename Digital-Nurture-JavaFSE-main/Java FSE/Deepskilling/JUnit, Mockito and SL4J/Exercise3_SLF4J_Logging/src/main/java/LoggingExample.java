import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Create the logger instance
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);
    
    public static void main(String[] args) {
        // Exercise 1: Logging Error Messages and Warning Levels
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.info("This is an info message");
        logger.debug("This is a debug message");
    }
}