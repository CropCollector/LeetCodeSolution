package leetcode.editor.cn;

//Java：灯泡开关
public class BulbSwitcher {
    public static void main(String[] args) {
        Solution solution = new BulbSwitcher().new Solution();
        // TO TEST
        System.out.println(solution.bulbSwitch(3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}