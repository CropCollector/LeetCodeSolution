package leetcode.editor.cn;

import java.math.BigDecimal;
import java.util.Arrays;

//Java：加一
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        // TO TEST
        solution.plusOne(new int[]{1, 2, 3});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int[] arr = new int[digits.length + 1];
        digits[digits.length - 1] ++;

        int plus = 0;
        for (int i = digits.length - 1; i >= 0; i --) {
            int n = digits[i];
            if (n + plus > 9) {
                arr[i + 1] = n + plus - 10;
                plus = 1;
            } else {
                arr[i + 1] = n + plus;
                plus = 0;
            }
        }

        if (plus == 1) {
            arr[0] = 1;
        } else {
            arr = Arrays.copyOfRange(arr, 1, arr.length);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}