import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.mockito.InOrder;

public class InteractionOrderTest {

    @Test
    public void testInteractionOrder() {
        // 1. Create a mock object
        List<String> mockList = mock(List.class);
        
        // 2. Call methods in a specific order
        mockList.add("First");
        mockList.add("Second");
        mockList.add("Third");
        
        // 3. Create an InOrder object to verify the sequence
        InOrder inOrder = inOrder(mockList);
        
        // 4. Verify the methods were called in the exact order
        inOrder.verify(mockList).add("First");
        inOrder.verify(mockList).add("Second");
        inOrder.verify(mockList).add("Third");
    }
}