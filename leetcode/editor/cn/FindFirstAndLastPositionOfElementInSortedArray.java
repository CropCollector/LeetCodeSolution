package leetcode.editor.cn;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            return new int[]{bs1(nums, target), bs2(nums, target)};
        }

        private int bs1(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return nums[l] < target ? -1 : nums[l] == target ? l : - 1;
        }

        private int bs2(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return nums[l] > target ? -1 : nums[l] == target ? l : - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}