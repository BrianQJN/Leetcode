import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-26
 */
public class min_stack_155 {
    private final Stack<Integer> mainStack;
    private final Stack<Integer> minStack;

    /**
     * @implSpec Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * Implement the MinStack class:
     * MinStack() initializes the stack object.
     * You must implement a solution with O(1) time complexity for each function.
     * @author Brian Qu
     * @since 2023-12-26 18:39
     */
    public min_stack_155() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * @implSpec Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * Implement the MinStack class:
     * void push(int val) pushes the element val onto the stack.
     * @author Brian Qu
     * @param val the integer value to push into the stack
     * @since 2023-12-26 18:42
     */
    public void push(int val) {
        // push into mainStack
        mainStack.push(val);
        // update the minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * @implSpec Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * Implement the MinStack class:
     * void pop() removes the element on the top of the stack.
     * @author Brian Qu
     * @since 2023-12-26 18:45
     */
    public void pop() {
        // update minStack
        if (minStack.peek().equals(mainStack.peek())) {
            minStack.pop();
        }
        // pop from mainStack
        mainStack.pop();
    }

    /**
     * @implSpec Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * Implement the MinStack class:
     * int top() gets the top element of the stack.
     * @author Brian Qu
     * @return int - the top element of the stack
     * @since 2023-12-26 18:49
     */
    public int top() {
        return mainStack.peek();
    }

    /**
     * @implSpec Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * Implement the MinStack class:
     * int getMin() retrieves the minimum element in the stack.
     * @author Brian Qu
     * @return int - the minimum element in the stack
     * @since 2023-12-26 18:50
     */
    public int getMin() {
        return minStack.peek();
    }
}
