//给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数 组成，且其中所有整数互不相同。 
//
// 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。 
//
// 那么第 k 个最小的分数是多少呢? 以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == 
//arr[j] 。 
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,5], k = 3
//输出：[2,5]
//解释：已构造好的分数,排序后如下所示: 
//1/5, 1/3, 2/5, 1/2, 3/5, 2/3
//很明显第三个最小的分数是 2/5
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,7], k = 1
//输出：[1,7]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// 1 <= arr[i] <= 3 * 10⁴ 
// arr[0] == 1 
// arr[i] 是一个 素数 ，i > 0 
// arr 中的所有数字 互不相同 ，且按 严格递增 排序 
// 1 <= k <= arr.length * (arr.length - 1) / 2 
// 
// Related Topics 数组 二分查找 堆（优先队列） 👍 182 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KThSmallestPrimeFraction {
    public static void main(String[] args) {
        Solution solution = new KThSmallestPrimeFraction().new Solution();
        int[] arr = solution.kthSmallestPrimeFraction(new int[]{1,13,17,59}, 6);
        System.out.println(arr[0] + " " + arr[1]);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Fraction implements Comparable {
            int x, y, i;

            public Fraction(int x, int y, int i) {
                this.x = x;
                this.y = y;
                this.i = i;
            }

            @Override
            public int compareTo(Object o) {
                Fraction f2 = (Fraction) o;
                return x * f2.y - f2.x * y;
            }
        }

        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int len = arr.length;
            // 标识每一位已经和arr的哪一位组成过分数，一开始都是len - 1
            int[] mark = new int[len];
            Arrays.fill(mark, len - 1);

            PriorityQueue<Fraction> pq = new PriorityQueue<>();
            for (int i = 0; i < len - 1; i++) {
                pq.add(new Fraction(arr[i], arr[mark[i]], i));
            }

            for (int i = 1; i <= k - 1; i++) {
                Fraction f = pq.poll();
                if (mark[f.i] - 1 > f.i) {
                    mark[f.i] --;
                    pq.add(new Fraction(arr[f.i], arr[mark[f.i]], f.i));
                }
            }
            Fraction ans = pq.poll();
            return new int[]{ans.x, ans.y};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
