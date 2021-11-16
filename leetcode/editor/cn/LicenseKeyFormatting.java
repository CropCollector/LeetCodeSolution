package leetcode.editor.cn;

//Java：密钥格式化
public class LicenseKeyFormatting {
    public static void main(String[] args) {
        Solution solution = new LicenseKeyFormatting().new Solution();
        // TO TEST
        System.out.println(solution.licenseKeyFormatting("2", 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "");
        int len = s.length();
        int first = len % k, num = len / k;
        StringBuffer ans = new StringBuffer();
        if (first != 0) {
            for (int i = 0; i < first; i++) {
                ans.append(s.charAt(i));
            }
            if (num > 0)
                ans.append("-");
        }
        for (int i = first; i < s.length(); i += k) {
            ans.append(s, i, i + k);
            if (i + k < s.length()) {
                ans.append("-");
            }
        }
        return ans.toString().toUpperCase();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}