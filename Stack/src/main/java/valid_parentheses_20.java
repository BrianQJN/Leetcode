import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-26
 */
public class valid_parentheses_20 {
    /**
     * @implSpec Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * 3. Every close bracket has a corresponding open bracket of the same type.
     * @author Brian Qu
     * @param s a string contains just the given type of chars
     * @return boolean - return true if the string s is a valid parentheses
     * @since 2023-12-26 17:07
     */
    public boolean isValid(String s) {
        // initialize a stack
        Stack<Character> stack = new Stack<>();

        // traverse through the string s
        for (char c: s.toCharArray()) {
            // if cur char is open bracket
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
