/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-09
 */
public class Balanced_Binary_Tree_110 {
    /**
     * @implSpec Given a binary tree, determine if it is height-balanced. A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
     * @author Brian Qu
     * @param root the root of a binary Tree
     * @return boolean - if the binary tree is height balanced, return true, else false.
     * @since 2024-01-09 16:29
     */
    public boolean isBalanced(TreeNode root) {
        return calculateHeight(root) != -1;
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = calculateHeight(root.left);
        // if left subtree is unbalanced
        if (leftHeight == -1) return -1;

        int rightHeight = calculateHeight(root.right);
        // if right subtree is unbalanced
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
