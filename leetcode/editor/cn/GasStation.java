package leetcode.editor.cn;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

//Java：加油站
public class GasStation {
    public static void main(String[] args) {
        Solution solution = new GasStation().new Solution();
        // TO TEST
        System.out.println(solution.canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int l = gas.length;
        int[] gasp = new int[l * 2];
        System.arraycopy(gas, 0, gasp, 0, l);
        System.arraycopy(gas, 0, gasp, l, l);

        int[] costp = new int[l * 2];
        System.arraycopy(cost, 0, costp, 0, l);
        System.arraycopy(cost, 0, costp, l, l);

        int start = l, end = l;
        int sum = gasp[start];
        while (end - start < l) {
            if (sum >= costp[end]) {
                sum -= costp[end];
                end ++;
                if (end == 2 * l) {
                    sum += gasp[0];
                } else {
                    sum += gasp[end];
                }
            } else {
                start --;
                sum -= costp[start];
                sum += gasp[start];
            }
        }
        if (sum - costp[start]>= 0) {
            return start >= l ? start - l : start;
        } else {
            return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}