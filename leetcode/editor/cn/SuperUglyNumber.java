package leetcode.editor.cn;

import java.util.*;

//Java：超级丑数
public class SuperUglyNumber {
    public static void main(String[] args) {
        Solution solution = new SuperUglyNumber().new Solution();
        // TO TEST
        System.out.println(solution.nthSuperUglyNumber(20, new int[]{5,7,11,13,19,29,31,41,43,53}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] arr = new int[n + 1];
        arr[1] = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int prime : primes) {
            map.put(prime, 1);
        }
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            ArrayList<Integer> minKeyList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int prime = entry.getKey();
                int p = entry.getValue();
                if (prime * arr[p] < min) {
                    min = prime * arr[p];
                    minKeyList.clear();
                    minKeyList.add(prime);
                } else if (prime * arr[p] == min) {
                    minKeyList.add(prime);
                }
            }
            if (min != arr[i - 1]) {
                arr[i] = min;
            }
            minKeyList.forEach(minKey -> map.put(minKey, map.get(minKey) + 1));
        }
        return arr[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}