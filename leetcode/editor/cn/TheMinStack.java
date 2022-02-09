package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Java：最小栈
public class TheMinStack {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        private int min = Integer.MAX_VALUE;

        private Stack<Integer> stack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            min = Math.min(min, val);
        }

        public void pop() {
            int i = stack.pop();
            if (i == min) {
                min = stack.isEmpty() ? Integer.MAX_VALUE : stack.stream().min(Integer::compareTo).get();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}