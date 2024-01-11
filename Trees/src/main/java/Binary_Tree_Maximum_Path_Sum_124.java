/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-11
 */
public class Binary_Tree_Maximum_Path_Sum_124 {
    private int maxPathSum = Integer.MIN_VALUE;

    /**
     * @implSpec A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
     * The path sum of a path is the sum of the node's values in the path.
     * Given the root of a binary tree, return the maximum path sum of any non-empty path.
     * @author Brian Qu
     * @param root the root of a binary tree
     * @return int - the maximum path sum in the given binary tree
     * @since 2024-01-11 16:40
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // max path sum starting from left child
        int leftGain = Math.max(maxGain(node.left), 0);

        // max path sum starting from right child
        int rightGain = Math.max(maxGain(node.right), 0);

        // max path sum passing through this node
        int curGain = node.val + leftGain + rightGain;

        // update the global maximum
        maxPathSum = Math.max(maxPathSum, curGain);

        // for recursion: return the maximum gain the node and one of its subtrees can add
        return node.val + Math.max(leftGain, rightGain);
    }
}
