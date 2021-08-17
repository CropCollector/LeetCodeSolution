package leetcode.editor.cn;

//Java：优美的排列
public class BeautifulArrangement {
    public static void main(String[] args) {
        Solution solution = new BeautifulArrangement().new Solution();
        // TO TEST
        System.out.println(solution.countArrangement(2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int n;

    public int countArrangement(int n) {
        this.n = n;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dfs(2, 0x00 | (1 << i));
        }
        return ans;
    }

    private int dfs(int i, int flag) {
        if (i > n) return 1;
        int sum = 0;
        for (int j = 1; j < i; j++) {
            int curFlag = 1 << j;
            if (i % j == 0 && ((flag & curFlag) != curFlag)) {
                sum += dfs(i + 1, flag | (1 << j));
            }
        }
        for (int j = i; j <= n; j++) {
            int curFlag = 1 << j;
            if (j % i == 0 && ((flag & curFlag) != curFlag)) {
                sum += dfs(i + 1, flag | (1 << j));
            }
        }
        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}