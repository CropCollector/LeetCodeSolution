package leetcode.editor.cn;

import java.util.Arrays;

//Java：二分查找
public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i < 0 ? -1 : i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}