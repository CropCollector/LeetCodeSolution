package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Stream;

//Java：超级洗衣机
public class SuperWashingMachines {
    public static void main(String[] args) {
        Solution solution = new SuperWashingMachines().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        int len = machines.length;
        if (sum % len != 0) {
            return -1;
        }
        int avg = sum  / len;
        int ans = 0, preSum = 0;
        for (int i = 0; i < machines.length; i++) {
            machines[i] -= avg;
            preSum += machines[i];
            ans = Math.max(Math.max(machines[i] , Math.abs(preSum)), ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}