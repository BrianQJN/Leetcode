/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-12
 */
public class Hand_of_Straights_846 {
    /**
     * @param hand the value written on the ith card
     * @param groupSize an integer groupSize represents the cards in each group
     * @return boolean - return true if she can rearrange the cards
     * @implSpec Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
     * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
     * @author Brian Qu
     * @since 2024-03-12 18:26
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }


    }
}
