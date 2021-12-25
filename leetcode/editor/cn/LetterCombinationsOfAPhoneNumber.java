//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1614 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> ans = new ArrayList<>();

        private int len;

        private String[] arr;

        private String[] enums = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            len = digits.length();
            if (len == 0) {
                return new ArrayList<>();
            }
            arr = digits.split("");
            dfs("", 0);
            return ans;
        }

        private void dfs(String s, int i) {
            if (i == len) {
                ans.add(s);
                return;
            }
            Integer num = Integer.valueOf(arr[i]);
            String sList = enums[num];
            for (int k = 0; k < sList.length(); k++) {
                dfs(s + "" + sList.charAt(k), i + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
