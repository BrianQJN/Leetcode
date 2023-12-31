/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2023-12-30
 */
public class koko_eating_bananas_875 {
    /**
     * @implSpec Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     * @author Brian Qu
     * @param piles ith pile has piles[i] bananas
     * @param h the hours guard
     * @return the minimum integer k such that she can eat all the bananas within h hours
     * @since 2023-12-30 21:11
     */
    public int minEatingSpeed(int[] piles, int h) {
        // initialize the left and right boundaries
        int left = 1, right = 1;
        for (int pile: piles) {
            right = Math.max(right, pile);
        }

        // shrink the boundaries
        while (left < right) {
            // get the mid value
            int mid = (left + right) / 2;
            int hourSpent = 0;

            // calculate the hours spent
            for (int pile: piles) {
                hourSpent += (int) Math.ceil((double) pile / mid);
            }

            if (hourSpent > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
