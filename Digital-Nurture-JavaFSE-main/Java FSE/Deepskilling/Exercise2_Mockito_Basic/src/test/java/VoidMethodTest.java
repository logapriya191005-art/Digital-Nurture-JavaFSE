import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class VoidMethodTest {

    @Test
    public void testVoidMethod() {
        // 1. Create a mock object
        List<String> mockList = mock(List.class);

        // 2. Stub the void method 
        // (Void methods do nothing by default in Mockito, but we use doNothing() to be explicit)
        doNothing().when(mockList).clear();

        // 3. Call the void method
        mockList.clear();

        // 4. Verify the interaction happened
        verify(mockList).clear();
    }
}