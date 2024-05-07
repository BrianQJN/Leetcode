/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-06
 */
public class Reverse_Integer_7 {
    /**
     * @param x a signed 32-bit integer.
     * @return x with its digits reversed.
     * @implSpec Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     * @author Brian Qu
     * @since 2024-05-06 23:04
     */
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int tail = x % 10; // extract the last digit
            int newRes = res * 10 + tail; // prepare for the next digit

            // check for overflow
            if ((newRes-tail) / 10 != res) {
                return 0;
            }

            res = newRes;
            x = x / 10; // reduce x by removing the LSB
        }

        return res;
    }
}
