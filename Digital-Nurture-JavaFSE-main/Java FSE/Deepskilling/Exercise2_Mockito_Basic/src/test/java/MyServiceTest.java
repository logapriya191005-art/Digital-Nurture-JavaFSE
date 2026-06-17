import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    
    @Test
    public void testExternalApi() {
        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        
        // Stub the method to return predefined value
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Create service with mock
        MyService service = new MyService(mockApi);
        
        // Test
        String result = service.fetchData();
        
        // Verify
        assertEquals("Mock Data", result);
        
        // Verify interaction
        verify(mockApi).getData();
    }
}