/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-09
 */
public class Maximum_Depth_of_Binary_Tree_104 {
    /**
     * @implSpec Given the root of a binary tree, return its maximum depth.
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * @author Brian Qu
     * @param root the root of a binary tree
     * @return int - the maximum depth of the given binary tree
     * @since 2024-01-09 15:50
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
