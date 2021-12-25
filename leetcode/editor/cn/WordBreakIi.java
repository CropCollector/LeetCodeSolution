package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        System.out.println(solution.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class TreeNode {
            int letter;
            TreeNode[] children = new TreeNode[26];
            boolean isEnd;

            public TreeNode() {
            }

            public TreeNode(char letter) {
                this.letter = letter - 'a';
            }
        }

        private List<String> ans = new ArrayList<>();

        private TreeNode root;

        private String s;

        public List<String> wordBreak(String s, List<String> wordDict) {
            this.root = createTree(wordDict);
            this.s = s;
            dfs(0, new StringBuffer());
            return ans;
        }

        private void dfs(int start, StringBuffer sb) {
            if (start == s.length()) {
                ans.add(sb.substring(0, sb.length() - 1));
                return;
            }
            for (int i = start + 1; i <= s.length(); i++) {
                String word = s.substring(start, i);
                if (containWord(root, word)) {
                    sb.append(word).append(" ");
                    dfs(i, sb);
                    sb = sb.delete(sb.length() - (word.length() + 1), sb.length());
                }
            }
        }

        private boolean containWord(TreeNode root, String word) {
            TreeNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (p.children[c - 'a'] != null) {
                    if (i == word.length() - 1) {
                        return p.children[c - 'a'].isEnd;
                    } else {
                        p = p.children[c - 'a'];
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        private TreeNode createTree(List<String> wordDict) {
            TreeNode root = new TreeNode(), p = root;
            for (int i = 0; i < wordDict.size(); i++) {
                String word = wordDict.get(i);
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    p.children[c - 'a'] = p.children[c - 'a'] == null ? new TreeNode(c) : p.children[c - 'a'];
                    if (j == word.length() - 1) {
                        p.children[c - 'a'].isEnd = true;
                    } else {
                        p = p.children[c - 'a'];
                    }
                }
                p = root;
            }
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
