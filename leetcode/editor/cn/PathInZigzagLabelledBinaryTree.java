package leetcode.editor.cn;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Java：二叉树寻路
public class PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();
        // TO TEST
        System.out.println(solution.pathInZigZagTree(14));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int i;
        for (i = 1; Math.pow(2, i - 1) < Math.pow(10, 6); i++) {
            if (label < Math.pow(2, i)) break;
        }
        List<Integer> list = new ArrayList<>();
        list.add(label);

        int cur = getOther(i, label);
        while (i > 1) {
            i --;
            cur = cur / 2;
            list.add(getOther(i , cur));
        }
        Collections.reverse(list);
        return list;
    }

    private int getOther(int i, int label) {
        if (i % 2 == 0) {
            return (int) (Math.pow(2, i - 1) + Math.pow(2, i) - 1 - label);
        } else {
            return label;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}