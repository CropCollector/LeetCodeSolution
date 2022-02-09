package leetcode.editor.cn;

import java.util.*;
import java.util.logging.XMLFormatter;

//Java：两句话中的不常见单词
public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();
            String[] arr1 = s1.split(" ");
            String[] arr2 = s2.split(" ");
            for (String s : arr1) {
                map1.put(s, map1.getOrDefault(s, 0) + 1);
            }
            for (String s : arr2) {
                map2.put(s, map2.getOrDefault(s, 0) + 1);
            }

            List<String> ans = new ArrayList<>();
            for (String s : map1.keySet()) {
                if (map1.get(s) > 1) {
                    continue;
                }
                if (!map2.containsKey(s)) {
                    ans.add(s);
                }
            }
            for (String s : map2.keySet()) {
                if (map2.get(s) > 1) {
                    continue;
                }
                if (!map1.containsKey(s)) {
                    ans.add(s);
                }
            }
            return ans.toArray(new String[ans.size()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}