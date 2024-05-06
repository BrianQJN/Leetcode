/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-05
 */
public class Number_of_1_Bits_191 {
    /**
     * @param n a positive integer
     * @return int - the number of set bits it has
     * @implSpec Write a function that takes the binary representation of a positive integer and returns the number of set bits it has (also known as the Hamming weight).
     * @author Brian Qu
     * @since 2024-05-05 23:33
     */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += n & 1; // increment count if the last bit is a 1
            n >>>= 1; // right shift n by 1 using unsigned shift
        }

        return count;
    }
}
