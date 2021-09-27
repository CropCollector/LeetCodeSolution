package leetcode.editor.cn;

//Java：找到需要补充粉笔的学生编号
public class FindTheStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        Solution solution = new FindTheStudentThatWillReplaceTheChalk().new Solution();
        // TO TEST
        System.out.println(solution.chalkReplacer(new int[]{3,4,1,2}, 25));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] arr = new long[n];
        arr[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + chalk[i];
        }

        long total = arr[n - 1];
        k = (int) (k % total);
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}