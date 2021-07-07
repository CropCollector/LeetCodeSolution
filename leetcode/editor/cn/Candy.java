package leetcode.editor.cn;

import sun.security.util.Length;

//Java：分发糖果
public class Candy {
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
        // TO TEST
        System.out.println(solution.candy(new int[]{1, 0, 2}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                left[i] = 1;
            } else {
                if (ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i == ratings.length - 1) {
                right[i] = 1;
            } else {
                if (ratings[i] > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = 1;
                }
            }
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}