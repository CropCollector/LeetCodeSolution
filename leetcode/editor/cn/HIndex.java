package leetcode.editor.cn;

import java.util.Arrays;

//Java：H 指数
public class HIndex {
    public static void main(String[] args) {
        Solution solution = new HIndex().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            h = Math.max(Math.min(citations[i], citations.length - i), h);
        }
        return h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}