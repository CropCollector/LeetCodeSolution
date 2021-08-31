package leetcode.editor.cn;

//Java：航班预订统计
public class CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();
        // TO TEST
        System.out.println(solution.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}}, 5));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int len = bookings.length;
        for (int i = 0; i < len; i++) {
            ans[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] < n) {
                ans[bookings[i][1]] -= bookings[i][2];
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}