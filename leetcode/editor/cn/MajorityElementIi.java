//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
// Related Topics 数组 哈希表 计数 排序 👍 503 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementIi{
  public static void main(String[] args) {
       Solution solution = new MajorityElementIi().new Solution();
       solution.majorityElement(new int[]{3,3,4});
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, countA = 0, countB = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == a) {
                countA ++;
            } else if (nums[i] == b) {
                countB ++;
            } else {
                if (a == Integer.MIN_VALUE) {
                    a = nums[i];
                    countA = 1;
                } else if (b == Integer.MIN_VALUE) {
                    b = nums[i];
                    countB = 1;
                } else {
                    countA --;
                    if (countA == 0) {
                        a = Integer.MIN_VALUE;
                    }
                    countB --;
                    if (countB == 0) {
                        b = Integer.MIN_VALUE;
                    }
                }
            }
        }

        countA = countB = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == a) {
                countA ++;
            } else if (nums[i] == b) {
                countB ++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (countA > n / 3) {
            ans.add(a);
        }
        if (countB > n / 3) {
            ans.add(b);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
