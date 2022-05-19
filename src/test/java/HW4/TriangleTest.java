package HW4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void successCalculationTest() throws Exception {
        Assertions.assertEquals(TheAreaOfTheTriangle.calculateArea(1, 2, 2), 2);
    }
}
