package leetcode.editor.cn;

//Java：斐波那契数列
public class FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int MOD = (int) 1e9 + 7;
        int f0 = 0, f1 = 1;
        int a = f0, b = f1, fi = a + b;
        for (int i = 2; i <= n; i++) {
            fi = (a + b) % MOD;
            a = b;
            b = fi;
        }
        return fi;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}