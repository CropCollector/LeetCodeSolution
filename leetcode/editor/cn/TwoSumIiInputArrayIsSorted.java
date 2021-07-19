package leetcode.editor.cn;

//Java：两数之和 II - 输入有序数组
public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j;) {
            int sum = numbers[i] + numbers[j];
            if (target == sum) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j --;
            } else {
                i ++;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}