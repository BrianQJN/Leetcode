/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-11
 */
public class Validate_Binary_Search_Tree_98 {
    /**
     * @implSpec Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     * A valid BST is defined as follows:
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * @author Brian Qu
     * @param root the root of a binary tree
     * @return boolean - return true if the given binary tree is a BST, else false
     * @since 2024-01-11 14:38
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
