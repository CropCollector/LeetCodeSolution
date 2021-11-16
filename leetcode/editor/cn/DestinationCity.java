package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：旅行终点站
public class DestinationCity {
    public static void main(String[] args) {
        Solution solution = new DestinationCity().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            String start = path.get(0);
            String end = path.get(1);
            set.add(start);
            set.add(end);
        }

        for (List<String> path : paths) {
            String start = path.get(0);
            set.remove(start);
        }

        return set.iterator().next();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}