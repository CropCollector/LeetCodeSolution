package leetcode.editor.cn;

//Java：赎金信
public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countArr = new int[26];
        int noteLen = ransomNote.length(), magazineLen = magazine.length();
        for (int i = 0; i < magazineLen; i++) {
            countArr[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < noteLen; i++) {
            char c = ransomNote.charAt(i);
            countArr[c - 'a'] --;
            if (countArr[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}