package leetcode.editor.cn;

import java.util.HashMap;

//Java：猜数字游戏
public class BullsAndCows {
    public static void main(String[] args) {
        Solution solution = new BullsAndCows().new Solution();
        // TO TEST
        System.out.println(solution.getHint("1122", "2211"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> secretMap = new HashMap<>();
        HashMap<Character, Integer> guessMap = new HashMap<>();
        int countA = 0, countB = 0;
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            char c1 = secret.charAt(i), c2 = guess.charAt(i);
            if (c1 == c2) {
                countA ++;
            } else {
                Integer c1Count = guessMap.getOrDefault(c1, 0);
                if (c1Count > 0) {
                    guessMap.put(c1, c1Count - 1);
                    countB ++;
                } else {
                    secretMap.put(c1, secretMap.getOrDefault(c1, 0) + 1);
                }

                Integer c2Count = secretMap.getOrDefault(c2, 0);
                if (c2Count > 0) {
                    secretMap.put(c2, c2Count - 1);
                    countB ++;
                } else {
                    guessMap.put(c2, guessMap.getOrDefault(c2, 0) + 1);
                }
            }
        }
        return countA + "A" + countB + "B";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}