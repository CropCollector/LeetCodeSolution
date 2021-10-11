package leetcode.editor.cn.contest;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class ContestSolution {
    public static void main(String[] args) {
        Solution solution = new ContestSolution().new Solution();
        // TO TEST
        System.out.println(solution.superEggDrop(4, 5000));
    }

    class Solution {

        Map<String, Integer> map = new HashMap<>();

        public int superEggDrop(int k, int n) {
            return dp(k, n);
        }

        private int dp(int k, int n) {
            if (map.containsKey(k + "" + n)) {
                return map.get(k + "" + n);
            }

            int ans = Integer.MAX_VALUE;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int l = 1, r = n;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    int a1 = dp(k - 1, mid - 1);
                    int a2 = dp(k, n - mid);
                    if (a1 > a2) {
                        r = mid - 1;
                        ans = Math.min(ans, a1 + 1);
                    } else {
                        l = mid + 1;
                        ans = Math.min(ans, a2 + 1);
                    }
                }
            }
            map.put(k + "" + n, ans);
            return ans;
        }
    }



}