package leetcode.editor.cn;

import java.util.Arrays;

//Java：雪糕的最大数量
public class MaximumIceCreamBars {
    public static void main(String[] args) {
        Solution solution = new MaximumIceCreamBars().new Solution();
        // TO TEST
        System.out.println(solution.maxIceCream(new int[]{1,6,3,1,2,5}, 20));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = 0;
        Arrays.sort(costs);
        for (int i = 0; i < costs.length && coins >= costs[i]; i++) {
            n ++;
            coins -= costs[i];
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}