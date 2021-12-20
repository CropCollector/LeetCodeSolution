package leetcode.editor.cn;

//Java：旋转图像
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        // TO TEST
        int[][] arr = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.rotate(arr);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0, size = len; size > 0; i ++, size -= 2) {
            for (int j = 0; j <= size - 2; j++) {
                int tmp = matrix[i][i + j];
                matrix[i][i + j] = matrix[i + size - 1 - j][i];
                matrix[i + size - 1 - j][i] = matrix[i + size - 1][i + size - 1 - j];
                matrix[i + size - 1][i + size - 1 - j] = matrix[i + j][i + size - 1];
                matrix[i + j][i + size - 1] = tmp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}