/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-04
 */
public class Power_50 {
    /**
     * @param x the base number
     * @param n the power
     * @return double - the x raised to the power n
     * @implSpec Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     * @author Brian Qu
     * @since 2024-05-04 21:33
     */
    public double myPow(double x, int n) {
        // edge case: if n is the minimum value for an integer, if we reverse it, it will overflow
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }

        // handle negative exponent by converting it to positive
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        // handle special case
        if (n == 0) return 1.0;
        if (n == 1) return x;

        double half = fastPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
