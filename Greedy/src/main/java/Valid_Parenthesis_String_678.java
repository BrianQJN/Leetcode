/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-14
 */
public class Valid_Parenthesis_String_678 {
    /**
     * @param s a string contains only three types of chars: '(', ')' and '*'
     * @return boolean - return true if s is valid
     * @implSpec Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
     * The following rules define a valid string:
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
     * @author Brian Qu
     * @since 2024-03-14 18:03
     */
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) low--;
                high--;
            } else {
                if (low > 0) low--;
                high++;
            }

            if (high < 0) {
                // if high is negative, means there are more closing parenthesis than opening parenthesis
                return false;
            }
        }

        return low == 0;
    }
}
