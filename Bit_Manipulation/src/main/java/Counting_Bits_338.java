/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-06
 */
public class Counting_Bits_338 {
    /**
     * @param n an integer
     * @return int[] - ans[i] is the number of 1's in the binary representation of i
     * @implSpec Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
     * @author Brian Qu
     * @since 2024-05-06 16:43
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0) {
                res[i] = res[i/2];
            } else {
                res[i] = res[i/2] + 1;
            }
        }

        return res;
    }
}
