package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

//Java：最长快乐字符串
public class LongestHappyString {
    public static void main(String[] args) {
        Solution solution = new LongestHappyString().new Solution();
        // TO TEST
        System.out.println(solution.longestDiverseString(1,1,7));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class CharCount implements Comparable{
        char c;
        int count;

        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {
            CharCount cc = (CharCount) o;
            return this.count - cc.count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        CharCount[] arr = new CharCount[]{
                new CharCount('a', a),
                new CharCount('b', b),
                new CharCount('c', c)
        };
        StringBuffer sb = new StringBuffer();
        while (true) {
            Arrays.sort(arr);
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == arr[2].c && sb.charAt(sb.length() - 2) == arr[2].c) {
                if (arr[1].count > 0) {
                    sb.append(arr[1].c);
                    arr[1].count--;
                } else {
                    break;
                }
            } else {
                if (arr[2].count > 0) {
                    sb.append(arr[2].c);
                    arr[2].count --;
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