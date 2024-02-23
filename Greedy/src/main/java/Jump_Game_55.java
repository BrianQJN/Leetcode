/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-21
 */
public class Jump_Game_55 {
    /**
     * @param nums an integer array
     * @return boolean - return true if we can reach the last index
     * @implSpec You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     * @author Brian Qu
     * @since 2024-02-21 01:07
     */
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        return lastPos == 0;
    }
}