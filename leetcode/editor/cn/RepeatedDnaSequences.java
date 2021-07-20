package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Java：重复的DNA序列
public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String subStr = s.substring(i, i + 10);
            if (set.contains(subStr)) {
                result.add(subStr);
            } else {
                set.add(subStr);
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(result);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}