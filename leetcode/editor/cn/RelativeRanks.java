package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Java：相对名次
public class RelativeRanks {
    public static void main(String[] args) {
        Solution solution = new RelativeRanks().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        Integer[] sortedScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedScore, Comparator.reverseOrder());

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String s = String.valueOf(i + 1);
            if (i <= 2) {
                if (i == 0) {
                    s = "Gold Medal";
                } else if (i == 1) {
                    s = "Silver Medal";
                } else if (i == 2) {
                    s = "Bronze Medal";
                }
            }
            map.put(sortedScore[i], s);
        }
        return Arrays.stream(score).boxed().map(num -> map.get(num)).toArray(String[]::new);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}