import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceVerifyTest {
    
    @Test
    public void testVerifyInteraction() {
        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        
        // Create service with mock
        MyService service = new MyService(mockApi);
        
        // Call the method
        service.fetchData();
        
        // Verify the interaction happened
        verify(mockApi).getData();
    }
}