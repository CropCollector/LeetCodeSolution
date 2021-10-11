package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：分数到小数
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = (long) numerator, d = (long) denominator;
        if (n % d == 0) {
            return "" + (n / d);
        }
        StringBuffer sb = new StringBuffer();
        if (n * d < 0) {
            sb.append("-");
        }
        n = Math.abs(n);
        d = Math.abs(d);
        sb.append(n / d + ".");
        n = n % d;
        Map<Long, Integer> map = new HashMap<>();
        while (n != 0) {
            map.put(n, sb.length());
            n *= 10;
            sb.append(n / d);
            n = n % d;
            if (map.containsKey(n)) {
                int u = map.get(n);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}