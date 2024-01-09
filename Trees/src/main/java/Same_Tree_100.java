/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-09
 */
public class Same_Tree_100 {
    /**
     * @implSpec Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     * @author Brian Qu
     * @param p the root of a binary tree
     * @param q the root of a binary tree
     * @return boolean - if the given binary trees are the same, return true, else false.
     * @since 2024-01-09 17:16
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if both of the nodes are null
        if (p == null && q == null) {
            return true;
        }

        // if one of them is null, or their values are different
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // recursively compare the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
