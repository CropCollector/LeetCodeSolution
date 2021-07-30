package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

//Java：下一个排列
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        solution.nextPermutation(new int[]{1, 2, 3});
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i;
        for (i = nums.length - 2; i >= 0; i --) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            for (int j = nums.length - 1; j >= 1; j --) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    reverse(nums, i + 1, nums.length - 1);
                    break;
                }
            }
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start ++, end --);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}