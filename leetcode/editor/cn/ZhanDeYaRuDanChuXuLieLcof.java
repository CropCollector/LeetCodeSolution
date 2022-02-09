package leetcode.editor.cn;

import java.util.Stack;

//Java：栈的压入、弹出序列
public class ZhanDeYaRuDanChuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
        // TO TEST
        System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 这次的想法是从出栈入手，若栈顶元素和当前遍历到的出栈元素不同就入栈
        // 下次可以从入栈入手，入栈然后判断当前入栈元素要不要出栈，要出栈就出栈，不要就进行下一个元素的入栈
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int len = popped.length;
            Stack<Integer> stack = new Stack<>();
            int pushIndex = 0;
            for (int i = 0; i < len; i++) {
                if (stack.isEmpty() || stack.peek() != popped[i]) {
                    while (stack.isEmpty() || (stack.peek() != popped[i] && pushIndex < len)) {
                        stack.push(pushed[pushIndex ++]);
                    }
                    if (stack.peek() != popped[i]) {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.pop();
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}