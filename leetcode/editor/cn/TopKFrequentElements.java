package leetcode.editor.cn;

import java.util.*;

//Java：前 K 个高频元素
public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        // TO TEST
        System.out.println(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[][] arr = new int[map.size()][2];
        int i = 0;
        for (Integer key : map.keySet()) {
            arr[i ++] = new int[]{key, map.get(key)};
        }
        Arrays.sort(arr, (o1, o2) -> (o2[1] - o1[1]));

        int[] ans = new int[k];
        for (int j = 0; j < k; j++) {
            ans[j] = arr[j][0];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}