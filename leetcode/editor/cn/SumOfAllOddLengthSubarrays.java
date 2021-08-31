package leetcode.editor.cn;

//Java：所有奇数长度子数组的和
public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        Solution solution = new SumOfAllOddLengthSubarrays().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sumArr = new int[arr.length];
        sumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumArr[i] = arr[i] + sumArr[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j + i - 1 < arr.length; j++) {
                ans += sumArr[j + i - 1];
                if (j - 1 >= 0) {
                    ans -= sumArr[j - 1];
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}