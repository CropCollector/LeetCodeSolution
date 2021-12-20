package leetcode.editor.cn;

import java.util.*;

//Java：前K个高频单词
public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
        // TO TEST
        System.out.println(solution.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> map.get(s1) == map.get(s2) ? s2.compareTo(s1) : map.get(s1) - map.get(s2));
            for (String s : map.keySet()) {
                pq.add(s);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            List<String> ans = new ArrayList<>();
            while (!pq.isEmpty()) {
                ans.add(0, pq.poll());
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}