import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-12
 */
public class Word_SearchII_212 {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    private char[][] _board = null;
    private ArrayList<String> _result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // Step 1: Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (char letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word; // Store word at the leaf node
        }

        this._board = board;
        // Step 2: Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtrack(row, col, root);
                }
            }
        }

        return this._result;
    }

    private void backtrack(int row, int col, TrieNode parent) {
        char letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // Check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null; // Make sure we don't print the same word multiple times
        }

        // Mark the current letter before the EXPLORATION
        this._board[row][col] = '#';

        // Explore the neighbor cells: up, down, left, right
        int[] rowOffset = {-1, 1, 0, 0};
        int[] colOffset = {0, 0, -1, 1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtrack(newRow, newCol, currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}
