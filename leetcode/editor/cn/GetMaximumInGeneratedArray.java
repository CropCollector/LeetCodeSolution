package leetcode.editor.cn;

//Java：获取生成数组中的最大值
public class GetMaximumInGeneratedArray {
    public static void main(String[] args) {
        Solution solution = new GetMaximumInGeneratedArray().new Solution();
        // TO TEST
        System.out.println(solution.getMaximumGenerated(15));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (2 * i > n) {
                break;
            }
            arr[2 * i] = arr[i];
            if (2 * i + 1 > n) {
                break;
            }
            arr[2 * i + 1] = arr[i] + arr[i + 1];
            ans = Math.max(arr[2 * i + 1], ans);
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}