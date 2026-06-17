import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DifferentAppendersExample {
    private static final Logger logger = LoggerFactory.getLogger(DifferentAppendersExample.class);
    
    public static void main(String[] args) {
        logger.info("This message goes to both console and file");
        logger.warn("Warning message logged");
        logger.error("Error message logged");
        
        System.out.println("\nCheck the 'app.log' file in your project folder!");
    }
}