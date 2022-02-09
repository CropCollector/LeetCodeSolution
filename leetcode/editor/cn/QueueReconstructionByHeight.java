package leetcode.editor.cn;

import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Java：根据身高重建队列
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
        System.out.println(solution.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            int len = people.length;
            List<int[]> list = new ArrayList<>();
            for (int[] person : people) {
                list.add(person[1], person);
            }

            int[][] ans = new int[len][2];
            for (int i = 0; i < len; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}