package leetcode.editor.cn;

//Java：至少有 K 个重复字符的最长子串
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        // TO TEST
        System.out.println(solution.longestSubstring("a", 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        return dfs(s, k);
    }

    private int dfs(String s, int k) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] ++;
        }

        String split = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] < k) {
                split = String.valueOf((char)(i + 'a'));
                break;
            }
        }

        if (split.length() == 0) {
            return s.length();
        } else {
            int max = 0;
            String[] sa = s.split(split);
            for (String ss : sa) {
                max = Math.max(max, dfs(ss, k));
            }
            return max;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}