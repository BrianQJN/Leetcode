/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-04
 */
public class Happy_Number_202 {
    /**
     * @param n the number to be determined
     * @return boolean - return true if the number is a happy number
     * @implSpec Write an algorithm to determine if a number n is happy.
     * A happy number is a number defined by the following process:
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     * Return true if n is a happy number, and false if not.
     * @author Brian Qu
     * @since 2024-05-04 15:14
     */
    public boolean isHappy(int n) {
        // initialize two pointers
        int slow = n;
        int fast = getSumOfSquares(n);

        // loop to detect the cycle
        while (fast != 1 && slow != fast) {
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        }

        return fast == 1;
    }

    private int getSumOfSquares(int n) {
        // helper function to get the sum of squares of the number's digits
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}
