package leetcode.editor.cn;

//Java：累加数
public class AdditiveNumber {
    public static void main(String[] args) {
        Solution solution = new AdditiveNumber().new Solution();
        // TO TEST
        System.out.println("aa".startsWith("aaaaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private String num;

        private int len;

        public boolean isAdditiveNumber(String num) {
            this.num = num;
            this.len = num.length();
            for (int i = 1; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (check(0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean check(int start1, int end1, int end2) {
            if (end2 == len) {
                return true;
            }
            String s1 = num.substring(start1, end1), s2 = num.substring(end1, end2);
            if ((s1.length() > 1 && s1.startsWith("0")) || (s2.length() > 1 && s2.startsWith("0"))) {
                return false;
            }
            Long l1 = Long.parseLong(s1), l2 = Long.parseLong(s2), l3 = l1 + l2;
            String s3 = l3.toString();
            if (end2 + s3.length() > len) {
                return false;
            }
            if (!num.startsWith(s3, end2)) {
                return false;
            }
            return check(end1, end2, end2 + s3.length());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}