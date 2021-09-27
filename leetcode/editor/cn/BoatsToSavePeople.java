package leetcode.editor.cn;

import java.util.Arrays;

//Java：救生艇
public class BoatsToSavePeople {
    public static void main(String[] args) {
        Solution solution = new BoatsToSavePeople().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l < r) {
            int leftPeople = people[l], rightPeople = people[r];
            if (leftPeople + rightPeople <= limit) {
                l ++;
            }
            r --;
            ans ++;
        }
        if (l == r) {
            ans ++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}