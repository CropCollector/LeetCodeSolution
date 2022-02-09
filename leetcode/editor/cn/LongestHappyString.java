package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Java：最长快乐字符串
public class LongestHappyString {
    public static void main(String[] args) {
        Solution solution = new LongestHappyString().new Solution();
        // TO TEST
        System.out.println(solution.longestDiverseString(1, 1, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 每次插入时判断目前已有字符串的后两个字符是否与当前剩余的字符一致，若一致插入第二多的字符，否则插入第一多的字符
        // 若已有字符串不足2，无脑插入第一多的（必定满足条件）
        public String longestDiverseString(int a, int b, int c) {
            int[][] arr = {{'a', a}, {'b', b}, {'c', c}};
            StringBuffer sb = new StringBuffer();
            while (true) {
                Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == arr[0][0]
                && sb.charAt(sb.length() - 2) == arr[0][0]) {
                    if (arr[1][1] > 0) {
                        sb.append((char) arr[1][0]);
                        arr[1][1] --;
                    } else {
                        break;
                    }
                } else {
                    if (arr[0][1] > 0) {
                        sb.append((char) arr[0][0]);
                        arr[0][1] --;
                    } else {
                        break;
                    }
                }
            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}