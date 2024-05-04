/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-04
 */
public class Plus_One_66 {
    /**
     * @param digits a large integer represented as an integer array digits
     * @return int[] - the large integer increases by one
     * @implSpec You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     * @author Brian Qu
     * @since 2024-05-04 16:28
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // process digits from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }

            digits[i] = 0;
        }

        // there is a leftover digit
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;

        return newDigits;
    }
}
