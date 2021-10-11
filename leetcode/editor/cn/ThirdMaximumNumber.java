package leetcode.editor.cn;

import java.util.*;

//Java：第三大的数
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        // TO TEST
        solution.thirdMax(new int[]{1,2});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(set);
        Collections.sort(arr, Comparator.reverseOrder());
        return arr.size() < 3 ? arr.get(0) : arr.get(2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}