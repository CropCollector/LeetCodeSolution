package leetcode.editor.cn;

import java.util.Random;

//Java：按权重随机选择
public class RandomPickWithWeight {
    public static void main(String[] args) {
        Solution solution = new RandomPickWithWeight().new Solution(new int[]{1});
        System.out.println(solution.pickIndex());
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int sum;

    private int[] w;

    public Solution(int[] w) {
        this.w = w;
        for (int i : w) {
            sum += i;
        }
    }
    
    public int pickIndex() {
        Random r = new Random();
        int n = r.nextInt(sum) + 1;
        for (int i = 0; i < w.length; i++) {
            if (w[i] < n) {
                n -= w[i];
            } else {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}