package leetcode.editor.cn;

//Java：整数反转
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        // TO TEST
        System.out.println(Integer.MAX_VALUE);//2147483647
//        System.out.println(solution.reverse(9646324351));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        boolean gt0 = true;
        if (x < 0) {
            gt0 = false;
            x = Math.abs(x);
        }
        char[] arr = String.valueOf(x).toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start ++;
            end --;
        }
        try {
            return Integer.valueOf(gt0 ? String.valueOf(arr) : "-" + String.valueOf(arr));
        } catch (Exception e) {
            return 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}