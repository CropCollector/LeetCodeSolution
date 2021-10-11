package leetcode.editor.cn;

import java.util.Arrays;

//Java：摆动排序 II
public class WiggleSortIi {
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int len = nums.length;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[-- len];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[-- len];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}