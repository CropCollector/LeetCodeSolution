package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//Java：整数替换
public class IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new IntegerReplacement().new Solution();
        // TO TEST
        System.out.println(solution.integerReplacement(8));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int ans;

    private HashMap<Long, Integer> cache = new HashMap<>();

    public int integerReplacement(int n) {
        dfs(n, 0);
        return ans;
    }

    private void dfs(long i, int count) {
        if (1 == i) {
            ans = count;
            return;
        }
        if (cache.get(i) != null && count >= cache.get(i)) {
            return;
        } else {
            cache.put(i, count);
        }
        if ((i & 1) == 0) {
            dfs(i >> 1, count + 1);
        } else {
            dfs(i + 1, count + 1);
            dfs(i - 1, count + 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}