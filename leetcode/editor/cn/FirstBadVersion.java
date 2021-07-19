package leetcode.editor.cn;

//Java：第一个错误的版本
public class FirstBadVersion {
    public static void main(String[] args) {
//        Solution solution = new FirstBadVersion().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while(i < j) {
            int mid = i + (j - i) / 2;
            // mid = (i + j) / 2 可能会导致 i + j 突破int上限，然后裂开
            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)

}