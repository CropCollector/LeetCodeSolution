package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Java：可见点的最大数目
public class MaximumNumberOfVisiblePoints {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfVisiblePoints().new Solution();
        // TO TEST
        System.out.println(solution.visiblePoints(Arrays.asList(Arrays.asList(2,1), Arrays.asList(2,2), Arrays.asList(3,3)), 90, Arrays.asList(1,1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            List<Double> angles = new ArrayList<>();
            int len = points.size(), locX = location.get(0), locY = location.get(1), ans = 0;
            for (int i = 0; i < len; i++) {
                int pointX = points.get(i).get(0), pointY = points.get(i).get(1);
                if (pointX == locX && pointY == locY) {
                    ans ++;
                } else {
                    // 相对location位于一象限
                    if (pointX > locX && pointY >= locY) {
                        angles.add(getAngle(pointX - locX, pointY - locY));
                    } else if (pointX <= locX && pointY > locY) {
                        angles.add(180 - getAngle(locX - pointX, pointY - locY));
                    } else if (pointX < locX && pointY <= locY) {
                        angles.add(180 + getAngle(locX - pointX, locY - pointY));
                    } else {
                        angles.add(360 - getAngle(pointX - locX, locY - pointY));
                    }
                }
            }

            Collections.sort(angles);
            List<Double> tmp = new ArrayList<>(angles);
            tmp = tmp.stream().map(d -> d + 360).collect(Collectors.toList());
            angles.addAll(tmp);
            int size = 0, anglesLen = angles.size() / 2;
            for (int i = 0; i < anglesLen && size < anglesLen; i++) {
                while (size < anglesLen && angles.get(i + size) - angles.get(i) <= angle) {
                    size ++;
                }
            }
            return ans + size;
        }

        private Double getAngle(int x, int y) {
            return x == 0 ? (y > 0 ? 90 : 270) : Math.atan(y * 1.0 / x) * 180 / Math.PI;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}