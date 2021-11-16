package leetcode.editor.cn;

import java.util.HashMap;

//Java：外观数列
public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        // TO TEST
        System.out.println(solution.countAndSay(4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            int count = 1;
            char cur = ans.charAt(0);
            for (int j = 1; j < ans.length(); j++) {
                char c = ans.charAt(j);
                if (c == cur) {
                    count ++;
                } else {
                    sb.append(count).append(cur);
                    cur = c;
                    count = 1;
                }
            }
            sb.append(count).append(cur);
            ans = sb.toString();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}