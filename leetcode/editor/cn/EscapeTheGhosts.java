package leetcode.editor.cn;

//Java：逃脱阻碍者
public class EscapeTheGhosts {
    public static void main(String[] args) {
        Solution solution = new EscapeTheGhosts().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        for (int i = 0; i < ghosts.length; i++) {
            if (Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1])
                    <= (Math.abs(target[0] - 0) + (Math.abs(target[1] - 0)))) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}