package leetcode.editor.cn;

//Java：压缩字符串
public class StringCompression {
    public static void main(String[] args) {
        Solution solution = new StringCompression().new Solution();
        // TO TEST
        System.out.println(solution.compress(new char[]{'a', 'b', 'c'}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        char beforeChar = chars[0], curChar = chars[0];
        int count = 1;
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i < chars.length; i++) {
            curChar = chars[i];
            if (curChar == beforeChar) {
                count ++;
            } else {
                ans.append(beforeChar);
                if (count != 1) {
                    ans.append(count);
                }
                beforeChar = curChar;
                count = 1;
            }
        }
        ans.append(curChar);
        if (count != 1) {
            ans.append(count);
        }
        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }
        return ans.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}