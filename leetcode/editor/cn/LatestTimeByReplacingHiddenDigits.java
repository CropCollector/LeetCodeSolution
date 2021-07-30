package leetcode.editor.cn;

//Java：替换隐藏数字得到的最晚时间
public class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        Solution solution = new LatestTimeByReplacingHiddenDigits().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            if (chars[1] < '4' || chars[1] == '?') {
                chars[0] = '2';
            } else {
                chars[0] = '1';
            }
        }
        if (chars[1] == '?') {
            if (chars[0] != '2') {
                chars[1] = '9';
            } else {
                chars[1] = '3';
            }
        }
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}