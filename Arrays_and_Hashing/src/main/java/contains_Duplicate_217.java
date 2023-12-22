import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-21
 */
public class contains_Duplicate_217 {
    /**
     * @implSpec Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     * @author Brian Qu
     * @param nums is an integer array
     * @return boolean, if the input array has duplicates
     * @since 2023-12-21 21:19
     */
    public boolean containsDuplicate(int[] nums) {
        // initialize a Hashset to record the elements shown
        Set<Integer> shown = new HashSet<>();

        // iterate through the array and record appearance
        for (int num: nums) {
            if (shown.contains(num)) {
                return true;
            }
            shown.add(num);
        }

        return false;
    }
}
