package leetcode.editor.cn;

//Java：数组中数字出现的次数
public class ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        // TO TEST
        solution.singleNumbers(new int[]{4,1,4,6});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            // 异或 不一样返回1 一样返回0
            int r = 0;
            for (int num : nums) {
                r ^= num;
            }
            // 一个数与上它的相反数得到最低位为1的二进制表示
            int mask = r & (-r);
            int ans1 = 0, ans2 = 0;
            for (int num : nums) {
                if ((mask & num) == 0) {
                    ans1 ^= num;
                } else {
                    ans2 ^= num;
                }
            }
            return new int[]{ans1, ans2};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}