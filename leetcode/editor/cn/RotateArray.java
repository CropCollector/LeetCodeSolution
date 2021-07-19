package leetcode.editor.cn;

//Java：旋转数组
public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        // TO TEST
        int[] arr = new int[]{1,2,3,4,5,6,7};
        solution.rotate(arr, 3);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        k = (int) k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
            l ++;
            r --;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}