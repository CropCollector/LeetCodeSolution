package leetcode.editor.cn;

//Java：一年中的第几天
public class DayOfTheYear {
    public static void main(String[] args) {
        Solution solution = new DayOfTheYear().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dayOfYear(String date) {
            int[] monthEnum = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String[] arr = date.split("-");
            int year = Integer.parseInt(arr[0]), month = Integer.parseInt(arr[1]), day = Integer.parseInt(arr[2]);
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                monthEnum[1] ++;
            }
            int ans = 0;
            for (int i = 0; i < month - 1; i++) {
                ans += monthEnum[i];
            }
            return ans + day;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}