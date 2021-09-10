package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：文本左右对齐
public class TextJustification {
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
        // TO TEST
        System.out.println(solution.fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int cur = 0;
        while (cur < words.length) {
            int curLine = 0, start = cur;
            while (curLine < maxWidth && cur < words.length) {
                if (cur != start) {
                    if (curLine + words[cur].length() + 1 > maxWidth) {
                        break;
                    }
                    //加个空格
                    curLine ++;
                }
                curLine += words[cur].length();
                cur ++;
            }
            int end = cur - 1, wordCount = end - start;

            StringBuffer sb = new StringBuffer();
            if (wordCount == 0) {
                sb.append(words[start]);
                while (sb.length() != maxWidth) {
                    sb.append(" ");
                }
            } else {
                // 算空格
                if (end != words.length - 1) {
                    int wordLenCount = 0;
                    for (int i = start; i <= end; i++) {
                        wordLenCount += words[i].length();
                    }
                    int space = (maxWidth - wordLenCount) / wordCount;
                    int extraSpace = (maxWidth - wordLenCount) % wordCount;

                    for (int i = start; i <= end; i++) {
                        if (i != start) {
                            for (int j = 1; j <= space; j++) {
                                sb.append(" ");
                            }
                            if (extraSpace > 0) {
                                sb.append(" ");
                                extraSpace --;
                            }
                        }
                        sb.append(words[i]);
                    }
                } else {
                    for (int i = start; i <= end; i++) {
                        if (i != start) {
                            sb.append(" ");
                        }
                        sb.append(words[i]);
                    }
                    while (sb.length() != maxWidth) {
                        sb.append(" ");
                    }
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}