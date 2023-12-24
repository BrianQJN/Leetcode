/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-24
 */
public class trapping_rain_water_42 {
    /**
     * @implSpec Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     * @author Brian Qu
     * @param height array of integers represents height
     * @return int, the water can be trapped
     * @since 2023-12-24 15:31
     */
    public int trap(int[] height) {
        // initialize two array to record the left and right max of position i
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        // record the left max and right max
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        // record the water trapped at each position
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }
}
