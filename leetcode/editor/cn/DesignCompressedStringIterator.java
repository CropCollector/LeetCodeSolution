package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Java：迭代压缩字符串
public class DesignCompressedStringIterator {
    public static void main(String[] args) {
        // TO TEST
        StringIterator si = new DesignCompressedStringIterator().new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.hasNext());
        System.out.println(si.next());
        System.out.println(si.hasNext());
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class StringIterator {

    private ArrayList<HashMap<Character, Integer>> arr;

    private int index;

    public StringIterator(String compressedString) {
        arr = new ArrayList<>();
        index = 0;

        Character curChar = null;
        StringBuffer num = new StringBuffer();
        for (int i = 0; i < compressedString.length(); i++) {
            char c = compressedString.charAt(i);
            if (Character.isLetter(c)) {
                if (num.length() != 0) {
                    HashMap<Character, Integer> map = new HashMap<>();
                    map.put(curChar, Integer.valueOf(num.toString()));
                    arr.add(map);
                    num = new StringBuffer();
                }
                curChar = c;
            } else {
                num.append(c);
            }
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(curChar, Integer.valueOf(num.toString()));
        arr.add(map);
    }
    
    public char next() {
        if (index >= arr.size()) {
            return ' ';
        }
        HashMap<Character, Integer> map = arr.get(index);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int value = entry.getValue();
            if (value != 0) {
                map.put(c, value - 1);
                return c;
            }
        }
        index ++;
        return next();
    }
    
    public boolean hasNext() {
        if (index >= arr.size()) {
            return false;
        }
        HashMap<Character, Integer> map = arr.get(index);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value != 0) {
                return true;
            }
        }
        index ++;
        return hasNext();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}