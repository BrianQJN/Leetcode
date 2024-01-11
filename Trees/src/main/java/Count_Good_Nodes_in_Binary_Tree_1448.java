/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-10
 */
public class Count_Good_Nodes_in_Binary_Tree_1448 {
    /**
     * @implSpec Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
     * Return the number of good nodes in the binary tree.
     * @author Brian Qu
     * @param root the root of a binary tree
     * @return int - the number of good nodes in the binary tree
     * @since 2024-01-10 23:49
     */
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int goodNodesCount = 0;

        if (node.val >= maxSoFar) {
            goodNodesCount++;
        }

        maxSoFar = Math.max(maxSoFar, node.val);
        goodNodesCount += dfs(node.left, maxSoFar);
        goodNodesCount += dfs(node.right, maxSoFar);

        return goodNodesCount;
    }
}
