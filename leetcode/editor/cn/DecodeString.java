package leetcode.editor.cn;

import java.util.Stack;

//Java：字符串解码
public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        // TO TEST
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == ']') {
                    StringBuffer encodedString = new StringBuffer();
                    while (stack.peek() != '[') {
                        encodedString.append(stack.pop());
                    }
                    stack.pop();

                    StringBuffer repeatTime = new StringBuffer();
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                        repeatTime.append(stack.pop());
                    }
                    int repeat = Integer.parseInt(repeatTime.reverse().toString());
                    for (int j = 1; j <= repeat; j++) {
                        for (int k = encodedString.length() - 1; k >= 0; k--) {
                            stack.add(encodedString.charAt(k));
                        }
                    }
                } else {
                    stack.add(c);
                }
            }

            StringBuffer sb = new StringBuffer();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}