package org.myJava.myMath;

import java.lang.Math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.myJava.myLang.MyMath;

class MyMathTests {
    @Test
    void PowVariableBaseAndExponentTest() {
        // straight value comparisons start diverting around 18^18, but the difference is negligible
        // 13^17 expected: <8.650415919381338E18> but was: <8.650415919381339E18>

        // expected from Math.pow starts returning infinity around 145^145 and -144^-144
        for (int i = -143; i < 144; ++i) {
            for (int j = -143; j < 144; ++j) {
                double expected = Math.pow(i, j);
                double actual = MyMath.pow(i, j);
                if (i == 0) {
                    assertEquals(expected, actual);
                } else {
                    double accuracy = (Double.min(expected, actual) / Double.max(expected, actual)) * 100.0;
                    assertTrue(accuracy > 99.999999999,
                            "expected: " + expected + " actual: " + actual +
                                    " i: " + i + " j: " + j + " accuracy: " + accuracy);
                }
            }
        }
    }

    @Test
    void PowVariableExponentTest() {
        // for this test, expected and actual are equal for all exponents between Integer.MIN_VALUE and
        // Integer.MAX_VALUE, but that takes over 7 minutes to run both.
        // limits chosen are to keep the whole test execution time around 5 seconds
        for (int i = -25000000; i < 25000000; ++i) {
            double expected = Math.pow(2, i);
            double actual = MyMath.pow(2, i);
            assertEquals(expected, actual, "i: " + i);
        }
    }

    @Test
    void PowVariableBasePositiveExponentTest() {
        // straight value comparisons start diverting around -200 and 200 due to rounding issues,
        // but the difference is negligible
        // 201^7 expected: <1.3254776280841402E16> but was: <1.32547762808414E16>

        // actual is within expected tolerance between Integer.MIN_VALUE and Integer.MAX_VALUE,
        // but it takes over 13 minutes to run.
        // limits chosen are to keep the whole test execution time around 5 seconds
        for (int i = -10000000; i < 10000000; ++i) {
            int exponent = 7; // chosen arbitrarily
            double expected = Math.pow(i, exponent);
            double actual = MyMath.pow(i, exponent);
            if (i == 0) {
                assertEquals(expected, actual);
            } else {
                double accuracy = (Double.min(expected, actual) / Double.max(expected, actual)) * 100.0;
                assertTrue(accuracy > 99.999999999999,
                        "expected: " + expected + " actual: " + actual +
                                " i: " + i + " accuracy: " + accuracy);
            }
        }
    }

    @Test
    void PowVariableBaseNegativeExponentTest() {
        // actual is within expected tolerance between Integer.MIN_VALUE and Integer.MAX_VALUE,
        // but it takes over 13 minutes to run.
        // limits chosen are to keep the whole test execution time around 5 seconds
        for (int i = -100000000; i < 100000000; ++i) {
            int exponent = -7; // chosen arbitrarily
            double expected = Math.pow(i, exponent);
            double actual = MyMath.pow(i, exponent);
            if (i == 0) {
                assertEquals(expected, actual);
            } else {
                double accuracy = (Double.min(expected, actual) / Double.max(expected, actual)) * 100.0;
                assertTrue(accuracy > 99.999999999999,
                        "expected: " + expected + " actual: " + actual +
                                " i: " + i + " accuracy: " + accuracy);
            }
        }
    }
}