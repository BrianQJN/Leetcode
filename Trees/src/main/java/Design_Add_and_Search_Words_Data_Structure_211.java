/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-12
 */
public class Design_Add_and_Search_Words_Data_Structure_211 {
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public  Design_Add_and_Search_Words_Data_Structure_211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i+1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.children[ch - 'a'] == null) {
                    return false;
                }
                node = node.children[ch - 'a'];
            }
        }

        return node.isEndOfWord;
    }
}
