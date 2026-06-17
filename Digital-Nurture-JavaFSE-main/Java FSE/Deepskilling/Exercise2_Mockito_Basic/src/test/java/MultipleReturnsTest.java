import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MultipleReturnsTest {

    @Test
    public void testMultipleReturnValues() {
        // 1. Create a mock object
        List<String> mockList = mock(List.class);
        
        // 2. Stub to return different values on consecutive calls
        when(mockList.get(0)).thenReturn("First");
        when(mockList.get(1)).thenReturn("Second");
        when(mockList.get(2)).thenReturn("Third");
        
        // 3. Test the different returns
        assertEquals("First", mockList.get(0));
        assertEquals("Second", mockList.get(1));
        assertEquals("Third", mockList.get(2));
    }
    
    @Test
    public void testConsecutiveReturns() {
        List<String> mockList = mock(List.class);
        
        // Chain multiple returns for the same method call
        when(mockList.size())
            .thenReturn(1)
            .thenReturn(2)
            .thenReturn(3);
        
        // Each call returns different value
        assertEquals(1, mockList.size());
        assertEquals(2, mockList.size());
        assertEquals(3, mockList.size());
    }
}
