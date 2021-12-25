package leetcode.editor.cn;

import java.util.HashMap;

//Java：从英文中重建数字
public class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
        // TO TEST
        System.out.println(solution.originalDigits("zerozero"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String originalDigits(String s) {
            // z - 0, w - 2, u - 4, x - 6, g - 8, h - 3, o - 1, f - 5, s - 7, i - 9
            String[] enums = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};
            HashMap<Character, Integer> map = new HashMap<>();
            int[] res = new int[10];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            deal(res, 0, map, 'z', "zero");
            deal(res, 2, map, 'w', "two");
            deal(res, 4, map, 'u', "four");
            deal(res, 6, map, 'x', "six");
            deal(res, 8, map, 'g', "eight");
            deal(res, 3, map, 'h', "three");
            deal(res, 1, map, 'o', "one");
            deal(res, 5, map, 'f', "five");
            deal(res, 7, map, 's', "seven");
            deal(res, 9, map, 'i', "nine");

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < res.length; i++) {
                if (res[i] != 0) {
                    for (int j = 0; j < res[i]; j++) {
                        sb.append(i);
                    }
                }
            }
            return sb.toString();
        }

        private void deal(int[] res, int index, HashMap<Character, Integer> map, char dealChar, String word) {
            int count = map.getOrDefault(dealChar, 0);
            if (count != 0) {
                res[index] = count;
                int len = word.length();
                for (int i = 0; i < len; i++) {
                    char c = word.charAt(i);
                    map.put(c, map.get(c) - count);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}