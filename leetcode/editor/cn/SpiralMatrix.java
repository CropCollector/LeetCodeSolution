package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Java：螺旋矩阵
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // TO TEST
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] mode = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curMode = 0;
        List<Integer> list = new ArrayList<>();
        HashSet<String> flag = new HashSet<>();
        int i = 0, j = 0;
        while (true) {
            flag.add(i + "" + j);
            list.add(matrix[i][j]);
            if (checkBorder(matrix, flag, i + mode[curMode][0], j + mode[curMode][1])) {
                curMode = (curMode + 1) % 4;
                if (checkBorder(matrix, flag, i + mode[curMode][0], j + mode[curMode][1])) {
                    break;
                }
            }
            i += mode[curMode][0];
            j += mode[curMode][1];
        }
        return list;
    }

    private boolean checkBorder(int[][] matrix, HashSet<String> flag, int i, int j) {
        return i == -1 || i == matrix.length
                || j == -1 || j == matrix[i].length || flag.contains(i + "" + j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}