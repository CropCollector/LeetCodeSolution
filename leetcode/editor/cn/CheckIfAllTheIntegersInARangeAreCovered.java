package leetcode.editor.cn;

//Java：检查是否区域内所有整数都被覆盖
public class CheckIfAllTheIntegersInARangeAreCovered {
    public static void main(String[] args) {
        Solution solution = new CheckIfAllTheIntegersInARangeAreCovered().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] count = new int[51];
        for (int i = 0; i < ranges.length; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                count[j] = 1;
            }
        }
        for (int i = left; i <= right; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}