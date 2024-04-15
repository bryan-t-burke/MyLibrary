package org.personal.myMath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestClass {
    @Test
    void PassTest() {
        assertEquals(1, MyMath.abs(-1));
    }

    //@Test
    void FailTest() {
        assertEquals(0, 1);
    }
}