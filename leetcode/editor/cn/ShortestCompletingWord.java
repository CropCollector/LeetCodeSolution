package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最短补全词
public class ShortestCompletingWord {
    public static void main(String[] args) {
        Solution solution = new ShortestCompletingWord().new Solution();
        // TO TEST
        System.out.println(solution.shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            Map<Character, Integer> map = new HashMap<>();
            Map<Character, Integer> wordsMap = new HashMap<>();

            for (int i = 0; i < licensePlate.length(); i++) {
                char c = licensePlate.charAt(i);
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }

            int len = words.length, minLen = Integer.MAX_VALUE;
            String ans = "";
            for (int i = 0; i < len; i++) {
                String s = words[i];
                for (int j = 0; j < s.length(); j++) {
                    char c = Character.toLowerCase(s.charAt(j));
                    wordsMap.put(c, wordsMap.getOrDefault(c, 0) + 1);
                }
                boolean flag = true;
                for (Character c : map.keySet()) {
                    if (map.get(c) > wordsMap.getOrDefault(c, 0)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && (s.length() < minLen)) {
                    ans = s;
                    minLen = s.length();
                }
                wordsMap.clear();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}