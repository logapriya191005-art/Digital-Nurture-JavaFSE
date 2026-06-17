import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ArgumentMatcherTest {

    @Test
    public void testArgumentMatchers() {
        // Create a mock List
        List<String> mockList = mock(List.class);
        
        // Add an item to the list
        mockList.add("Hello");
        
        // 1. Verify it was called with the EXACT string
        verify(mockList).add("Hello");
        
        // 2. Verify it was called with ANY string (This is the Argument Matcher!)
        verify(mockList).add(anyString());
    }
}