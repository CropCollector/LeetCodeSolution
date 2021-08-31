package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Java：下一个更大元素 I
public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        // TO TEST
        solution.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 1) {
            return new int[]{-1};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            int cur = nums2[i];
            while (!stack.isEmpty() && stack.peek() < cur) {
                map.put(stack.pop(), cur);
            }
            stack.add(cur);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        return Arrays.stream(nums1).map(n1 -> map.get(n1)).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}