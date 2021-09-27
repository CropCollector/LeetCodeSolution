package leetcode.editor.cn;

import java.util.*;

//Java：IPO
public class Ipo {
    public static void main(String[] args) {
        Solution solution = new Ipo().new Solution();
        // TO TEST
        System.out.println(solution.findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Project implements Comparable {
        int profit;
        int capital;
        //boolean isDone;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
            //this.isDone = false;
        }

        @Override
        public int compareTo(Object o) {
            Project p2 = (Project) o;
            // 收益低的排前面，收益相同时成本高的排前面
            if (this.profit == p2.profit) {
                return p2.capital - this.capital;
            } else {
                return this.profit - p2.profit;
            }
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<Project> arr = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            arr.add(new Project(profits[i], capital[i]));
        }
        Collections.sort(arr, (p1, p2) -> p1.capital - p2.capital);

        int cur = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= k; i++) {
            while (cur < arr.size() && arr.get(cur).capital <= w) {
                pq.add(arr.get(cur ++).profit);
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
               break;
            }
        }
        return w;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}