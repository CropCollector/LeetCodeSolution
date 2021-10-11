package leetcode.editor.cn;

//Java：矩形面积
public class RectangleArea {
    public static void main(String[] args) {
        Solution solution = new RectangleArea().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int s1 = Math.abs(ax2 -ax1) * Math.abs(ay2 - ay1);
        int s2 = Math.abs(bx2 -bx1) * Math.abs(by2 - by1);

        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return s1 + s2 - x * y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}