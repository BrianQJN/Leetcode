/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-06
 */
public class Reverse_Bits_190 {
    /**
     * @param n the input 32 bits unsigned integer
     * @return int - the reverse bits of a given 32 bits unsigned integer
     * @implSpec Reverse bits of a given 32 bits unsigned integer.
     * Note:
     * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
     * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
     * @author Brian Qu
     * @since 2024-05-06 17:43
     */
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            System.out.println(res);
            res <<= 1; // shift res to the left by 1 bit to make room for next bit
            res |= (n & 1); // add the LSB of n to the res
            n >>>= 1; // shift n to the right by 1 bit to move to next bit
        }

        return res;
    }
}
