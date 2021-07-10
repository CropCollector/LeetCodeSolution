package leetcode.editor.cn;

//Java：主要元素
public class FindMajorityElementLcci {
    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();
        // TO TEST
        solution.majorityElement(new int[]{1, 2, 3, 2});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int x = -1, cnt = 0;
        for (int i : nums) {
            if (cnt == 0) {
                x = i;
                cnt = 1;
            } else {
                cnt += x == i ? 1 : -1;
            }
        }
        cnt = 0;
        for (int i : nums) if (x == i) cnt++;
        return cnt > n / 2 ? x : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}