package leetcode.editor.cn;

import java.util.Arrays;

//Java：零钱兑换
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        // TO TEST
        System.out.println(solution.coinChange(new int[]{1}, 0));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < arr.length) {
                arr[coins[i]] = 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            if (min != Integer.MAX_VALUE) {
                continue;
            }
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 1) {
                    min = Math.min(min, arr[i - coins[j]]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                arr[i] = min + 1;
            }
        }

        if (arr[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return arr[amount];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}