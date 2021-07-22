package leetcode.editor.cn;

//Java：图像渲染
public class FloodFill {
    public static void main(String[] args) {
        Solution solution = new FloodFill().new Solution();
        // TO TEST
        solution.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        fill(image, sr, sc, newColor, initColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int newColor, int initColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length) {
            return;
        }
        if (image[sr][sc] == newColor) {
            return;
        }
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == initColor) {
            fill(image, sr - 1, sc, newColor, initColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == initColor) {
            fill(image, sr + 1, sc, newColor, initColor);
        }
        if (sc > 0 && image[sr][sc - 1] == initColor) {
            fill(image, sr, sc - 1, newColor, initColor);
        }
        if (sc < image[sr].length - 1 && image[sr][sc + 1] == initColor) {
            fill(image, sr, sc + 1, newColor, initColor);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}