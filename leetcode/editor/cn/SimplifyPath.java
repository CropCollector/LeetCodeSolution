package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//Java：简化路径
public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        // TO TEST
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            String[] arr = path.split("/");
            Deque<String> q = new ArrayDeque<>();
            for (String s : arr) {
                if (s.equals("") || s.equals(".")) {
                    continue;
                }
                if (q.isEmpty()) {
                    if (!s.equals("..")) {
                        q.add(s);
                    }
                } else {
                    if (s.equals("..")) {
                        q.pollLast();
                    } else {
                        q.add(s);
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            while (!q.isEmpty()) {
                sb.append("/").append(q.pop());
            }
            return sb.length() == 0 ? "/" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}