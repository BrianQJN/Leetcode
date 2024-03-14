import java.util.Map;
import java.util.TreeMap;

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
     * @implSpec Alice has some number of cards, and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
     * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
     * @author Brian Qu
     * @since 2024-03-12 18:26
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // if the length of hand is not divisible of groupSize, we can't divide into k group
        if (hand.length % groupSize != 0) {
            return false;
        }

        // count the number of each card
        Map<Integer, Integer> cardCounts = new TreeMap<>();
        for (int card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        // try to regroup the cards
        for (int card : cardCounts.keySet()) {
            int count = cardCounts.get(card);
            if (count > 0) {
                // try to group based on current card
                for (int i = 1; i < groupSize; i++) {
                    int nextCard = card + i;
                    // check if we can regroup
                    if (!cardCounts.containsKey(nextCard) || cardCounts.get(nextCard) < count) {
                        // we don't have enough next card for regroup
                        return false;
                    }
                    cardCounts.put(nextCard, cardCounts.get(nextCard) - count);
                }
            }
        }

        return true;
    }
}
