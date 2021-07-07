package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：根据字符出现频率排序
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Bean {
        String c;
        int count;

        public Bean(String c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        PriorityQueue<Bean> priorityQueue = new PriorityQueue<Bean>(s.length(), new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                if (o1.count == o2.count) {
                    return 0;
                } else {
                    return o1.count > o2.count ? -1 : 1;
                }
            }
        });
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.forEach((k, v) -> {
            priorityQueue.add(new Bean(k, v));
        });
        StringBuffer sb = new StringBuffer();
        while (!priorityQueue.isEmpty()) {
            Bean b = priorityQueue.poll();
            for (int i = 0; i < b.count; i++) {
                sb.append(b.c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}