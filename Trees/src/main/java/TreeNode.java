/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec Define TreeNode for Trees problems
 * @since 2024-01-08
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
