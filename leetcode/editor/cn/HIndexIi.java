package leetcode.editor.cn;

//Java：H 指数 II
public class HIndexIi {
    public static void main(String[] args) {
        Solution solution = new HIndexIi().new Solution();
        // TO TEST
        System.out.println(solution.hIndex(new int[]{11, 15}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        return binarySearch(citations);
    }

    private int binarySearch(int[] citations) {
        int h = 0;
        for (int i = 0, j = citations.length; i < citations.length && i < j;) {
            int mid = (i + j) / 2;
            int count = citations[mid];
            int num = citations.length - mid;
            int curH = Math.min(citations[mid], citations.length - mid);
            if (curH >= h) {
                h = curH;
            }
            if (count > num) {
                j = mid;
            } else if (count < num) {
                i = mid + 1;
            } else {
                break;
            }
        }
        return h;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}