/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-11
 */
public class Kth_Smallest_Element_in_BST_230 {
    private int count = 0;
    private int res = 0;

    /**
     * @implSpec Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     * @author Brian Qu
     * @param root the root of a binary search tree
     * @param k the kth smallest element
     * @return int - the value of the kth smallest node in the BST
     * @since 2024-01-11 14:53
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraverse(root, k);
        return res;
    }

    private void inOrderTraverse(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.left, k);

        if (++count == k) {
            res = node.val;
            return;
        }

        inOrderTraverse(node.right, k);
    }
}
