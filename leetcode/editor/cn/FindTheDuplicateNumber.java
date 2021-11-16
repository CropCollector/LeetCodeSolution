package leetcode.editor.cn;

//Java：寻找重复数
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        // TO TEST
        System.out.println(solution.findDuplicate(new int[]{1,3,4,2,2}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int lt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    lt ++;
                }
            }
            if (lt <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}