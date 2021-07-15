package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

//Java：绝对差值和
public class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteSumDifference().new Solution();
        // TO TEST
        System.out.println(solution.minAbsoluteSumDiff(
                new int[]{38,48,73,55,25,47,45,62,15,34,51,20,76,78,38,91,69,69,73,38,74,75,86,63,73,12,100,59,29,28,94,43,100,2,53,31,73,82,70,94,2,38,50,67,8,40,88,87,62,90,86,33,86,26,84,52,63,80,56,56,56,47,12,50,12,59,52,7,40,16,53,61,76,22,87,75,14,63,96,56,65,16,70,83,51,44,13,14,80,28,82,2,5,57,77,64,58,85,33,24},
                new int[]{90,62,8,56,33,22,9,58,29,88,10,66,48,79,44,50,71,2,3,100,88,16,24,28,50,41,65,59,83,79,80,91,1,62,13,37,86,53,43,49,17,82,27,17,10,89,40,82,41,2,48,98,16,43,62,33,72,35,10,24,80,29,49,5,14,38,30,48,93,86,62,23,17,39,40,96,10,75,6,38,1,5,54,91,29,36,62,73,51,92,89,88,74,91,87,34,49,56,33,67}
        ));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) (1e9 + 7);
        int sum = 0, better = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            int curAbs = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + curAbs) % mod;
            Integer floor = set.floor(nums2[i]);
            Integer celling = set.ceiling(nums2[i]);
            int betterAbs;
            if (floor == null) {
                betterAbs = Math.abs(celling - nums2[i]);
            } else if (celling == null){
                betterAbs = Math.abs(floor - nums2[i]);
            } else {
                betterAbs = Math.min(Math.abs(floor - nums2[i]), Math.abs(celling - nums2[i]));
            }
            int change = curAbs - betterAbs;
            better = Math.max(change, better);
        }
        return (sum - better + mod) % mod;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}