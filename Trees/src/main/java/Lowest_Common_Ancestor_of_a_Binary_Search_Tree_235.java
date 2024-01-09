/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-09
 */
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {
    /**
     * @implSpec Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     * @author Brian Qu
     * @param root the root of a binary search tree
     * @param p a TreeNode
     * @param q a TreeNode
     * @return TreeNode - the lowest common ancestor of TreeNode p and q in the BST.
     * @since 2024-01-09 18:11
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                // both p and q are in the right subtree
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                // both p and q are in the left subtree
                cur = cur.left;
            } else {
                return cur;
            }
        }

        return null;
    }
}
