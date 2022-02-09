package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：字母异位词分组
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String hash = getHash(str);
                List<String> list = map.getOrDefault(hash, new ArrayList<>());
                list.add(str);
                map.put(hash, list);
            }
            return map.values().stream().collect(Collectors.toList());
        }

        private String getHash(String str) {
            HashMap<Character, Integer> map = new HashMap<>();
            int len = str.length();
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            StringBuffer sb = new StringBuffer();
            List<Character> list = map.keySet().stream().collect(Collectors.toList());
            Collections.sort(list);
            for (Character c : list) {
                sb.append(map.get(c)).append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}