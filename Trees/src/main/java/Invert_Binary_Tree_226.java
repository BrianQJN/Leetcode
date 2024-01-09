/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-08
 */
public class Invert_Binary_Tree_226 {
    /**
     * @implSpec Given the root of a binary tree, invert the tree, and return its root.
     * @author Brian Qu
     * @param root the root of a binary tree
     * @return TreeNode - the inverted tree root
     * @since 2024-01-08 23:06
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // swap the left and right children
        root.left = right;
        root.right = left;

        return root;
    }
}
