package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：字符串的排列
public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> ans = new ArrayList<>();

        public String[] permutation(String s) {
            dfs(s.toCharArray(), 0, new StringBuffer());
            return ans.toArray(new String[ans.size()]);
        }

        private void dfs(char[] s, int i, StringBuffer cur) {
            if (i == s.length) {
                ans.add(cur.toString());
                return;
            }
            next:
            for (int j = i; j < s.length; j++) {
                for (int k = j - 1; k >= i; k--) {
                    if (s[k] == s[j]) {
                        continue next;
                    }
                }
                swap(s, i, j);
                cur.append(s[i]);
                dfs(s, i + 1, cur);
                cur.deleteCharAt(cur.length() - 1);
                swap(s, j, i);
            }
        }

        private void swap(char[] s, int i, int j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}