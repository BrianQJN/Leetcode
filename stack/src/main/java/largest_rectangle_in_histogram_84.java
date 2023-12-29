import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2023-12-29
 */
public class largest_rectangle_in_histogram_84 {
    /**
     * @implSpec Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
     * @author Brian Qu
     * @param heights an array of integers heights representing the histogram's bar height.
     * @return int - the area of the largest rectangle in the histogram.
     * @since 2023-12-29 14:39
     */
    public int largestRectangleArea(int[] heights) {
        // initialization
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // if we reach the end, set cur height as 0
            int h = (i == n) ? 0 : heights[i];

            // while stack is not empty, and cur height is less than the stack top's height
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                // mean the stack's top found a possible max area, since there is a height less than it
                int height = heights[stack.pop()];
                // if the stack is empty, means there is no shorter bar than cur, so the width can extend from index 0 to cur index i
                // but if the stack is not empty, means the bar popped would be limited by the new stack's top, since the new stack's top
                // is shorter than the popped one. So, the width can't extend, it could only from the new top to cur index
                int width = stack.isEmpty() ? i: i - 1 - stack.peek();
                // update the maxArea
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
