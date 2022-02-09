package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：检测正方形
public class DetectSquares {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class DetectSquares1 {

        private Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        public DetectSquares1() {

        }

        public void add(int[] point) {
            int row = point[0], col = point[1];
            Map<Integer, Integer> colMap = map.getOrDefault(row, new HashMap<>());
            colMap.put(col, colMap.getOrDefault(col, 0) + 1);
            map.put(row, colMap);
        }

        public int count(int[] point) {
            int searchRow = point[0], searchCol = point[1], ans = 0;
            Map<Integer, Integer> colMap = map.getOrDefault(searchRow, new HashMap<>());
            for (Integer col : colMap.keySet()) {
                if (col != searchCol) {
                    int line = col < searchCol ? searchCol - col : col - searchCol;
                    if (map.containsKey(searchRow + line) && map.get(searchRow + line).containsKey(col) && map.get(searchRow + line).containsKey(searchCol)) {
                        ans += colMap.get(col) * map.get(searchRow + line).get(col) * map.get(searchRow + line).get(searchCol);
                    }
                    if (map.containsKey(searchRow - line) && map.get(searchRow - line).containsKey(col) && map.get(searchRow - line).containsKey(searchCol)) {
                        ans += colMap.get(col) * map.get(searchRow - line).get(col) * map.get(searchRow - line).get(searchCol);
                    }
                }
            }
            return ans;
        }
    }

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
//leetcode submit region end(Prohibit modification and deletion)

}