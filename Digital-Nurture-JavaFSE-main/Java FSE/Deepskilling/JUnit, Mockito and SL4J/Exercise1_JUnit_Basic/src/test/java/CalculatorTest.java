import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    // Exercise 4: Test Fixture / Setup Method
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        // Exercise 3: assertNotNull
        assertNotNull(calculator, "Calculator instance should not be null");
    }

    // Exercise 4: Arrange-Act-Assert (AAA) Pattern
    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 8;

        // Act
        int actual = calculator.add(a, b);

        // Assert
        assertEquals(expected, actual, "Addition failed");
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
    }

    // Exercise 3: assertThrows
    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
    }

    // Exercise 3: assertTrue / assertFalse
    @Test
    public void testIsEven() {
        assertTrue(calculator.isEven(4), "4 should be even");
        assertFalse(calculator.isEven(3), "3 should not be even");
    }
}