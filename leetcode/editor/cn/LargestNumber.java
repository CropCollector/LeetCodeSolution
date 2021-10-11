package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：最大数
public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        // TO TEST
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (o1, o2) -> {
            String s1 = o1.toString(), s2 = o2.toString();
            return (s2 + s1).compareTo(s1 + s2);
        });

        StringBuffer sb = new StringBuffer();
        for (Integer i : arr) {
            sb.append(i);
        }
        int k = 0;
        while (k < nums.length - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}