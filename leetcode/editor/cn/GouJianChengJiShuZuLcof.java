package leetcode.editor.cn;

//Java：构建乘积数组
public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            int len = a.length;
            if (len == 0) {
                return new int[0];
            }
            int[] l = new int[len], r = new int[len];
            l[0] = 1;
            for (int i = 1; i < len; i++) {
                l[i] = l[i - 1] * a[i - 1];
            }

            r[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                r[i] = r[i + 1] * a[i + 1];
            }

            int[] ans = new int[len];
            for (int i = 0; i < len; i++) {
                ans[i] = l[i] * r[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}