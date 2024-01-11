import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-10
 */
public class Binary_Tree_Level_Order_Traversal_102 {
    /**
     * @implSpec Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     * @author Brian Qu
     * @param root the root of a binary tree
     * @return List - the level order traversal of its nodes' values
     * @since 2024-01-10 22:57
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(curLevel);
        }

        return res;
    }
}
