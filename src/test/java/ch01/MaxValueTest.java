package ch01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MaxValueTest {

    @Test
    void max(){
        int a =MaxValue.max(1,2,3);
        assertEquals(3,a);
    }


}
