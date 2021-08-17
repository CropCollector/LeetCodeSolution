package leetcode.editor.cn;

//Java：判断一个数字是否可以表示成三的幂的和
public class CheckIfNumberIsASumOfPowersOfThree {
    public static void main(String[] args) {
        Solution solution = new CheckIfNumberIsASumOfPowersOfThree().new Solution();
        // TO TEST
        System.out.println(solution.checkPowersOfThree(91));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPowersOfThree(int n) {
        if (n % 3 != 0) n --;
        while (n != 0 && n % 3 == 0) {
            while (n % 3 == 0) n /= 3;
            n --;
        }
        return n == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}