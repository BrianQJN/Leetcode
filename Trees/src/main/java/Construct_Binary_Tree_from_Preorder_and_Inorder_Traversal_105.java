import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-11
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    /**
     * @implSpec Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
     * @author Brian Qu
     * @param preorder the preorder traversal of a binary tree
     * @param inorder the inorder traversal of a binary tree
     * @return TreeNode - the root of binary tree built by the preorder and inorder traversal
     * @since 2024-01-11 15:22
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();

        // build a HashMap to store the value -> index relations of inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtrees
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }
}
