/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-23
 */
public class valid_palindrome_125 {
    /**
     * @implSpec A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * @author Brian Qu
     * @param s a phrase consists only of printable ASCII chars
     * @return boolean, return true if the string is a palindrome
     * @since 2023-12-23 15:22
     */
    public boolean isPalindrome(String s) {
        // initialize two pointers and convert string s to lowercase
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();

        // update two pointers and compare characters
        while (left < right) {
            // skip the non-alphanumeric chars
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare the chars at two pointers
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // update two pointers
            left++;
            right--;
        }

        return true;
    }
}
