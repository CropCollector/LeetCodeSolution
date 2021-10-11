package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

//Java：两个数组的交集 II
public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        // TO TEST
        System.out.println(solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : nums2) {
            Integer count = map.get(i);
            if (count != null && count != 0) {
                map.put(i, count - 1);
                ans.add(i);
            }
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}