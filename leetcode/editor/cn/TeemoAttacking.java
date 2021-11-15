package leetcode.editor.cn;

//Java：提莫攻击
public class TeemoAttacking {
    public static void main(String[] args) {
        Solution solution = new TeemoAttacking().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            int t1 = timeSeries[i], t2 = timeSeries[i + 1];
            ans += Math.min(t2 - t1, duration);
        }
        return ans + duration;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}