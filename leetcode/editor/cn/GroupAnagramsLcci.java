package leetcode.editor.cn;

import java.util.*;

//Java：变位词组
public class GroupAnagramsLcci {
    public static void main(String[] args) {
        Solution solution = new GroupAnagramsLcci().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = getKey(strs[i]);
            List list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }

    private String getKey(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}