package leetcode.editor.cn;

import java.util.Arrays;

//Java：适龄的朋友
public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        Solution solution = new FriendsOfAppropriateAges().new Solution();
        // TO TEST
        System.out.println(solution.numFriendRequests(new int[]{16, 16}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFriendRequests(int[] ages) {
            Arrays.sort(ages);
            int len = ages.length, ans = 0;
            for (int i = 0; i < len; i++) {
                double left = 0.5 * ages[i] + 7, right = ages[i];
                // 找到比left大的第一个数
                int index1 = bs(ages, left);
                if (index1 == -1 || index1 == len - 1) {
                    continue;
                }
                index1 ++;
                // 找到小于等于right的最后一个数
                int index2 = bs(ages, right);
                if (index2 == -1 || index2 < index1) {
                    continue;
                }
                ans += index2 - index1 + 1;
            }
            return ans;
        }

        private int bs(int[] ages, double target) {
            int l = 0, r = ages.length - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (ages[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return ages[l] > target ? -1 : l;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}