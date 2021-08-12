package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Java：丑数 II
public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        // TO TEST
        System.out.println(solution.nthUglyNumber(10));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;

        int[] primes = new int[]{2, 3, 5};
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