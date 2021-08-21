package leetcode.editor.cn;

//Java：学生出勤记录 II
public class StudentAttendanceRecordIi {
    public static void main(String[] args) {
        Solution solution = new StudentAttendanceRecordIi().new Solution();
        // TO TEST
        System.out.println(solution.checkRecord(4));//41 43
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int checkRecord(int n) {
        int MOD = (int) (1e9 + 7);
        // dp[i][j][k] 表示 在长度为i时可以获得奖励的记录数量
        // i为长度，j为A【缺勤】的数量（0 ~ 1），k为L【迟到】的数量（0 ~ 2）
        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            //对于每种状态(0A0L, 0A1L, 0A2L, 1A0L, 1A1L, 1A2L)添加下一次的状态
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD; // 0A0L + P， 0A1L + P, 0A2L + P
            dp[i][0][1] = (dp[i - 1][0][0]) % MOD; // 0A0L + L
            dp[i][0][2] = (dp[i - 1][0][1]) % MOD; // 0A1L + L
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]
                    + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD; // 0A0L + A, 0A1L + A, 0A2L + A, 1A0L + P, 1A1L + P, 1A2L + P
            dp[i][1][1] = (dp[i - 1][1][0]) % MOD; // 1A0L + L
            dp[i][1][2] = (dp[i - 1][1][1]) % MOD; // 1A1L + L
        }
        long ans = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                ans = (ans % MOD + dp[n][j][k] % MOD) % MOD;
            }
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}