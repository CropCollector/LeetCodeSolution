package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Java：把数组排成最小的数
public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(list, (n1, n2) -> {
                String s1 = n1.toString();
                String s2 = n2.toString();
                return (s1 + s2).compareTo(s2 + s1);
            });
            StringBuffer sb = new StringBuffer();
            for (Integer i : list) {
                sb.append(i);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}