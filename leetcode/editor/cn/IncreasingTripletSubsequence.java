package leetcode.editor.cn;

//Java：递增的三元子序列
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Solution solution = new IncreasingTripletSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
        for (int three : nums) {
            if (three <= one) {
                one = three;
            } else if (three <= two) {
                two = three;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}