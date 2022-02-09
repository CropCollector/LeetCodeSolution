package leetcode.editor.cn;

import java.util.Set;

//Java：单词长度的最大乘积
public class AseY1I {
    public static void main(String[] args) {
        Solution solution = new AseY1I().new Solution();
        // TO TEST
        System.out.println(solution.maxProduct(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            int len = words.length;
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    arr[i] |= 1 << c - 'a' + 1;
                }
            }

            int ans = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if ((arr[i] & arr[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}