package org.personal.myMath;

public class MyMath {

    public static double abs(double a) {
        if (a < 0.0) {
            return a * -1.0;
        }
        return a;
    }

    public static float abs(float a) {
        if (a < 0.0f) {
            return a * -1.0f;
        }
        return a;
    }

    public static int abs(int a) {
        if (a < 0) {
            return a * -1;
        }
        return a;
    }

    public static long abs(long a) {
        if (a < 0L) {
            return a * -1L;
        }
        return a;
    }

    // Calling a Math method would defeat the purpose of this endeavor
    @SuppressWarnings("ManualMinMaxCalculation")
    public static int min(int first, int second) {
        return first < second ? first : second;
    }

    // Calling a Math method would defeat the purpose of this endeavor
    @SuppressWarnings("ManualMinMaxCalculation")
    public static int max(int first, int second) {
        return first < second ? second : first;
    }

    public static double pow(double base, int exponent) {
        long exp = exponent; // min int causes a rollover when you multiply by -1
        if (exp < 0) {
            base = 1/base;
            exp *= -1;
        }

        // just doing a for loop is fine for small values of exponent, but it will take time for large value
        // instead we can take advantage of the fact that a given exponent n can be written as 2 * (n/2)
        // x^n == (x^2)^(n/2) for n % 2 == 0;
        // x^n == (x)(x^2)^((n-1)/2) for n % 2 == 1;

        // 2^10
        // (2^2)^(10/2)
        // 4^5
        // (4)(4^4)
        // (4)(4^2)^(4/2)
        // (4)(16)^2
        // (4)(16^2)^(2/2)
        // (4)(256)^1
        // (4)(256)(256^0)
        // (4)(256)(1)

        // recursive worse space wise than iterative

        double answer = 1;

        while (exp != 0) {
            if (exp % 2 == 1) {
                answer *= base;
                exp -= 1;
            }
            base *= base;
            exp /= 2;
        }

        return answer;
    }
}
