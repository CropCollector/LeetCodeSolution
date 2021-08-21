package leetcode.editor.cn;

import sun.font.TrueTypeFont;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//Java：反转字符串中的元音字母
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        // TO TEST
        System.out.println(solution.reverseVowels("hello"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        Character[] arr = new Character[]{'a', 'e', 'i', 'u', 'o', 'A', 'E', 'I', 'U', 'O'};
        HashSet<Character> set = new HashSet<>();
        set.addAll(Arrays.asList(arr));

        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < s.length() && !set.contains(chars[l])) l ++;
            while (r > 0 && !set.contains(chars[r])) r --;
            if (l >= r) {
                break;
            } else {
                // swap
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l ++;
                r --;
            }
        }
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}