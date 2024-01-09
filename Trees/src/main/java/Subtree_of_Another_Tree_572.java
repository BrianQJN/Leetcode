/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-09
 */
public class Subtree_of_Another_Tree_572 {
    /**
     * @implSpec Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
     * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants. The tree could also be considered as a subtree of itself.
     * @author Brian Qu
     * @param root the root of the main binary tree
     * @param subRoot the root of the binary tree to check if it is a subtree of the main binary tree.
     * @return boolean - if the subRoot is a subtree of the root, return true, else false.
     * @since 2024-01-09 17:32
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
