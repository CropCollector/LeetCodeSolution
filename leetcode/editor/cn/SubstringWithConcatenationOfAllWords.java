package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：串联所有单词的子串
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        // TO TEST
        System.out.println(solution.findSubstring("ababaab", new String[]{"ab","ba","ba"}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();

        int len = 0;
        StringBuffer sb = new StringBuffer();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            len += words[i].length();
            sb.append(words[i]);
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        if (s.length() < len) {
            return list;
        }

        int[] wordsCast = getCharCount(sb.toString());

        String initStr = s.substring(0, len);
        int[] cast = getCharCount(initStr);
        if (isCharCountEqual(cast, wordsCast)) {
            if (doCheck(initStr, map)) {
                list.add(0);
            }
        }

        for (int i = 1; i + len <= s.length(); i++) {
            cast[s.charAt(i - 1) - 'a'] --;
            cast[s.charAt(i + len - 1) - 'a'] ++;
            if (isCharCountEqual(cast, wordsCast)) {
                if (doCheck(s.substring(i, i + len), map)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    private boolean doCheck(String str, HashMap<String, Integer> map) {
        int len = map.keySet().iterator().next().length();
        HashMap<String, Integer> tmp = new HashMap<>();
        for (int i = 0; i < str.length(); i += len) {
            String subStr = str.substring(i, i + len);
            tmp.put(subStr, tmp.getOrDefault(subStr, 0) + 1);
        }
        return tmp.equals(map);
    }

    private boolean isCharCountEqual(int[] cast, int[] wordsCast) {
        for (int i = 0; i < cast.length; i++) {
            if (cast[i] != wordsCast[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCharCount(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a'] ++;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}