import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2023-12-27
 */
public class daily_temperature_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // initialization
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // traverse the array
        for (int i = 0; i < n; i++) {
            // while stack is not empty and cur temperature is greater than the temperature in stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            // push cur index into stack
            stack.push(i);
        }

        return result;
    }
}
