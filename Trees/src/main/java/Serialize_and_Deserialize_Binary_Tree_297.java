import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-11
 */
public class Serialize_and_Deserialize_Binary_Tree_297 {
    /**
     * @implSpec Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     * @author Brian Qu
     * @param root the root of a binary tree
     * @return String - the serialized binary tree
     * @since 2024-01-11 17:29
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /**
     * @implSpec Helper function to serialize binary tree in preorder
     * @author Brian Qu
     * @param node the root of a binary tree
     * @param sb the StringBuilder
     * @since 2024-01-11 17:34
     */
    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }

        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    /**
     * @implSpec Deserialize the binary tree
     * @author Brian Qu
     * @param data serialized binary tree
     * @return TreeNode - deserialized binary tree
     * @since 2024-01-11 18:35
     */
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }

    private TreeNode deserialize(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }
}
