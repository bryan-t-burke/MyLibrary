package org.personal.myMath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestClass {
    @Test
    void PassTest() {
        assertEquals(0,0);
    }

    //@Test
    void FailTest() {
        assertEquals(0, 1);
    }
}