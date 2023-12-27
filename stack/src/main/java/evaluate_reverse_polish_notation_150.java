import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-26
 */
public class evaluate_reverse_polish_notation_150 {
    /**
     * @implSpec You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
     * Evaluate the expression. Return an integer that represents the value of the expression.
     * Note that:
     * The valid operators are '+', '-', '*', and '/'.
     * Each operand may be an integer or another expression.
     * The division between two integers always truncates toward zero.
     * There will not be any division by zero.
     * The input represents a valid arithmetic expression in a reverse polish notation.
     * The answer and all the intermediate calculations can be represented in a 32-bit integer
     * @author Brian Qu
     * @param tokens an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation
     * @return int - the value of the expression
     * @since 2023-12-26 19:21
     */
    public int evalRPN(String[] tokens) {
        // initialization
        Stack<Integer> stack = new Stack<>();

        // traverse through the tokens
        for (String token: tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
    
    /**
     * @implSpec Helper function to check if the token is an operator
     * @author Brian Qu
     * @param token a string
     * @return boolean - if the token is an operator, return true
     * @since 2023-12-26 19:24
     */
    public boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
    
    /**
     * @implSpec Helper function to do the operation
     * @author Brian Qu
     * @param token the operator
     * @param operand1 the operand
     * @param operand2 the operand
     * @return int - the operation result
     * @since 2023-12-26 19:28
     */
    public int applyOperation(String token, int operand1, int operand2) {
        switch (token) {
            case "+" -> {
                return operand1 + operand2;
            }
            case "-" -> {
                return operand1 - operand2;
            }
            case "*" -> {
                return operand1 * operand2;
            }
            case "/" -> {
                return operand1 / operand2;
            }
            default -> {
                throw new IllegalArgumentException("Invalid Operator");
            }
        }
    }
}
