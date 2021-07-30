package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

//Java：得到子序列的最少操作次数
public class MinimumOperationsToMakeASubsequence {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToMakeASubsequence().new Solution();
        // TO TEST
        solution.minOperations(new int[]{1,3,8}, new int[]{2,6});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            Integer index = map.get(i);
            if (index != null) {
                list.add(index);
            }
        }
        if (list.isEmpty()) {
            return target.length;
        }
        int[] d = new int[list.size() + 1];
        int len = 1;
        d[1] = list.get(0);
        for (Integer i : list) {
            if (i > d[len]) {
                d[++ len] = i;
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (r + l) >> 1;
                    if (d[mid] < i) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = i;
            }
        }
        return target.length - len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}