package leetcode.editor.cn;

//Java：替换所有的问号
public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String modifyString(String s) {
            char[] arr = s.toCharArray();
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                if (arr[i] == '?') {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if ((i == 0 || arr[i - 1] != j) && (i == len - 1 || arr[i + 1] != j)) {
                            arr[i] = j;
                            break;
                        }
                    }
                }
            }
            return String.valueOf(arr);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}