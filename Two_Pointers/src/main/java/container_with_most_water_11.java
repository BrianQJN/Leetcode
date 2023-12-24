/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-23
 */
public class container_with_most_water_11 {
    /**
     * @implSpec You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     * Notice that you may not slant the container.
     * @author Brian Qu
     * @param height an integer array height of length n
     * @return int, the max area that two lines can form with the x-axis
     * @since 2023-12-23 21:51
     */
    public int maxArea(int[] height) {
        // initialize two pointers and the maxArea
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        // move two pointers to the center
        while (left < right) {
            int areaHeight = Math.min(height[left], height[right]);
            int len = right - left;

            // update the max area
            maxArea = Math.max(maxArea, len * areaHeight);

            // if height left smaller than right, move left to right, else move right to the left
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
