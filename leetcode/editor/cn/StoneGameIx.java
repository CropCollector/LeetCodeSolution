package leetcode.editor.cn;

//Java：石子游戏 IX
public class StoneGameIx {
    public static void main(String[] args) {
        Solution solution = new StoneGameIx().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean stoneGameIX(int[] stones) {
            int[] arr = new int[3];
            for (int i : stones) {
                arr[i % 3] ++;
            }

            // 全是3的倍数，B赢
            if (arr[1] == 0 && arr[2] == 0) {
                return false;
            }
            if ((arr[0] & 1) == 0) {
                return arr[1] > 0 && arr[2] > 0;
            } else {
                return Math.abs(arr[1] - arr[2]) >= 3;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}