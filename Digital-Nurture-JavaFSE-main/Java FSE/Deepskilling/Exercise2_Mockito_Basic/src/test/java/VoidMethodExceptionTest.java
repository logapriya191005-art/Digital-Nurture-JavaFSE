import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class VoidMethodExceptionTest {

    @Test
    public void testVoidMethodThrowsException() {
        // 1. Create a mock object
        List<String> mockList = mock(List.class);
        
        // 2. Stub the void method to throw an exception
        doThrow(new RuntimeException("Test Exception"))
            .when(mockList).clear();
        
        // 3. Verify that calling the method throws the exception
        assertThrows(RuntimeException.class, () -> {
            mockList.clear();
        });
        
        // 4. Verify the interaction happened
        verify(mockList).clear();
    }
}