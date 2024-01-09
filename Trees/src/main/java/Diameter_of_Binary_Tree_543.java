/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-09
 */
public class Diameter_of_Binary_Tree_543 {
    private int diameter = 0;

    /**
     * @implSpec Given the root of a binary tree, return the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     * The length of a path between two nodes is represented by the number of edges between them.
     * @author Brian Qu
     * @param root the root of a binary tree
     * @return int - the length of the diameter of the binary tree
     * @since 2024-01-09 16:03
     */
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // calculate the height of the left and right subtrees
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        // diameter of a node is leftHeight + rightHeight
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // return the height of this node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
