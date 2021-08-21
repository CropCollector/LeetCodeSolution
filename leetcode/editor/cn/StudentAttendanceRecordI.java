package leetcode.editor.cn;

//Java：学生出勤记录 I
public class StudentAttendanceRecordI {
    public static void main(String[] args) {
        Solution solution = new StudentAttendanceRecordI().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkRecord(String s) {
        int aCount = 0;
        int lCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                lCount ++;
                if (lCount == 3) {
                    return false;
                }
            } else {
                lCount = 0;
                if (c == 'A') {
                    aCount ++;
                    if (aCount == 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}