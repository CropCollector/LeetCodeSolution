package leetcode.editor.cn;

//Java：反转字符串 II
public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        // TO TEST
        System.out.println(solution.reverseStr("abcdefg", 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i += 2 * k) {
            int start = i, end = Math.min(i + 2 * k, len);
            int delta = end - start;
            if (delta >= k) {
                // reverse k
                reverse(arr, start, start + k);
            } else {
                reverse(arr, start, end);
            }
        }
        return String.valueOf(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        end --;
        char tmp;
        while (start < end) {
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start ++;
            end --;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}