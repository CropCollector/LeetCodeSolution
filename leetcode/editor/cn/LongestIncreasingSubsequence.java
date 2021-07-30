package leetcode.editor.cn;

//Java：最长递增子序列
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        // TO TEST
        solution.lengthOfLIS(new int[]{0,1,0,3,2,3});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length + 1];
        int len = 1;
        d[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {
                len ++;
                d[len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}