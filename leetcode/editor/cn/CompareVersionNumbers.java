package leetcode.editor.cn;

//Java：比较版本号
public class CompareVersionNumbers {
    public static void main(String[] args) {
        Solution solution = new CompareVersionNumbers().new Solution();
        // TO TEST
        System.out.println(solution.compareVersion("0.1", "1.1"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
            int n1 = 0, n2 = 0;
            if (i < s1.length) {
                n1 = Integer.parseInt(s1[i]);
            }
            if (i < s2.length) {
                n2 = Integer.parseInt(s2[i]);
            }
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}