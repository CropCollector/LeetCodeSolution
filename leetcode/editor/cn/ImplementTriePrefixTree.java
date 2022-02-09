package leetcode.editor.cn;

//Java：实现 Trie (前缀树)
public class ImplementTriePrefixTree {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        private class TreeNode {
            TreeNode[] children = new TreeNode[26];
            boolean isEnd;
        }

        private TreeNode root;

        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode p = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TreeNode();
                }
                p = p.children[c - 'a'];
            }
            p.isEnd = true;
        }

        public boolean search(String word) {
            TreeNode p = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (p.children[c - 'a'] != null) {
                    p = p.children[c - 'a'];
                } else {
                    return false;
                }
            }
            return p.isEnd;
        }

        public boolean startsWith(String prefix) {
            TreeNode p = root;
            int len = prefix.length();
            for (int i = 0; i < len; i++) {
                char c = prefix.charAt(i);
                if (p.children[c - 'a'] != null) {
                    p = p.children[c - 'a'];
                } else {
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}