/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-03
 */
public class median_of_two_sorted_arrays_4 {
    /**
     * @implSpec Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     * @author Brian Qu
     * @param nums1 sorted integer array of size m
     * @param nums2 sorted integer array of size n
     * @return double - the median of the two sorted arrays
     * @since 2024-01-03 22:11
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // make sure the nums1 is the shorter array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // initialization
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            // calculate the length of each partition
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            // calculate the max and min value in each partition
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // check the conditions to determine the shrink direction
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("No such solution");
    }
}
