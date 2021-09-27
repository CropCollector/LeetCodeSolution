package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;

//Java：游戏中弱角色的数量
public class TheNumberOfWeakCharactersInTheGame {
    public static void main(String[] args) {
        Solution solution = new TheNumberOfWeakCharactersInTheGame().new Solution();
        // TO TEST
        System.out.println(solution.numberOfWeakCharacters(new int[][]{{1,7},{1,7},{7,5},{9,6},{10,10},{10,6},{4,5},{9,5}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Player implements Comparable {
        int atk;
        int def;

        public Player(int atk, int def) {
            this.atk = atk;
            this.def = def;
        }

        @Override
        public int compareTo(Object o) {
            Player p2 = (Player) o;
            if (this.atk > p2.atk) {
                return -1;
            } else if (this.atk < p2.atk) {
                return 1;
            } else {
                return this.def - p2.def;
            }
        }
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0;
        ArrayList<Player> arr = new ArrayList<>();
        for (int i = 0; i < properties.length; i++) {
            arr.add(new Player(properties[i][0], properties[i][1]));
        }
        //按攻击力倒序排序，若相同，按防御力正序排序
        Collections.sort(arr);

        //记录当前防御力的最大值，若遍历过程中遇到防御力低于最大值的角色，则为弱角色
        //因为若当角色的防御力小于最大值，因为是攻击力倒序排序，其攻击力一定是小于等于前面角色的攻击力的
        //又因为他的防御力小于最大值，说明这个最大值一定是一个大于他攻击力的角色提供的（因为攻击力相同时，防御力大的在后面）
        int max = -1;
        for (int i = 0; i < arr.size(); i++) {
            int def = arr.get(i).def;
            if (max > def) {
                ans ++;
            } else {
                max = Math.max(max, def);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}