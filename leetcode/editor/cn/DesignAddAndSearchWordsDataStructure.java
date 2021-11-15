package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;

//Java：添加与搜索单词 - 数据结构设计
public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary solution = new DesignAddAndSearchWordsDataStructure().new WordDictionary();
        // TO TEST
        solution.addWord("a");
        solution.addWord("ab");
//        solution.addWord("an");
//        solution.addWord("add");
        System.out.println(solution.search("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        private class Node {
            Character val;
            boolean isEnd = false;
            HashMap<Character, Node> child = new HashMap<>();

            Node(Character c) {
                val = c;
            }
        }

        private Node tree = new Node(null);


        public WordDictionary() {

        }

        public void addWord(String word) {
            addNode(tree, word, 0);
        }

        private void addNode(Node node, String word, int i) {
            if (i == word.length()) {
                node.isEnd = true;
                return;
            }
            char c = word.charAt(i);
            if (c == '.') {
                for (char j = 'a'; j <= 'z'; j++) {
                    Node n = node.child.getOrDefault(j, new Node(j));
                    node.child.put(j, n);
                    addNode(node.child.get(j), word, i + 1);
                }
            } else {
                Node n = node.child.getOrDefault(c, new Node(c));
                node.child.put(c, n);
                addNode(n, word, i + 1);
            }
        }

        public boolean search(String word) {
            return getNode(tree, word, 0);
        }

        private boolean getNode(Node node, String word, int i) {
            if (i == word.length()) {
                return node.isEnd;
            }
            char c = word.charAt(i);
            if (c == '.') {
                for (char j = 'a'; j <= 'z'; j++) {
                    Node n = node.child.get(j);
                    if (n == null) continue;
                    if (getNode(node.child.get(j), word, i + 1)) {
                        return true;
                    }
                }
            } else {
                Node n = node.child.get(c);
                if (n == null) return false;
                return getNode(n, word, i + 1);
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}