package leetcode.editor.cn;

//Java：回文子字符串的个数
public class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            char[] arr = s.toCharArray();
            int len = s.length(), ans = 0;
            for (int i = 0; i < len; i++) {
                for (int count = 0; count <= 1; count++) {
                    int l = i, r = i + count;
                    while (l >= 0 && r < len) {
                        if (arr[l] == arr[r]) {
                            ans ++;
                            l --;
                            r ++;
                        } else {
                            break;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}