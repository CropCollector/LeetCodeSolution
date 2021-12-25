//给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是
// (xi, yi) ，右上顶点是 (ai, bi) 。 
//
// 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。 
// 
//
// 示例 1： 
//
// 
//输入：rectangles = [[1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4]]
//输出：true
//解释：5 个矩形一起可以精确地覆盖一个矩形区域。 
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4]]
//输出：false
//解释：两个矩形之间有间隔，无法覆盖成一个矩形。 
//
// 示例 3： 
//
// 
//输入：rectangles = [[1,1,3,3},{3,1,4,2},{1,3,2,4},{3,2,4,4]]
//输出：false
//解释：图形顶端留有空缺，无法覆盖成一个矩形。 
//
// 示例 4： 
//
// 
//输入：rectangles = [[1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4]]
//输出：false
//解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 2 * 10⁴ 
// rectangles[i].length == 4 
// -10⁵ <= xi, yi, ai, bi <= 10⁵ 
// 
// Related Topics 数组 扫描线 👍 193 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfectRectangle{
  public static void main(String[] args) {
       Solution solution = new PerfectRectangle().new Solution();
       System.out.println(solution.isRectangleCover(new int[][]{{0,0,1,1},{0,2,1,3},{1,1,2,2},{2,0,3,1},{2,2,3,3},{1,0,2,3},{0,1,3,2}}));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

      class Line implements Comparable{
          int start, end;

          public Line(int start, int end) {
              this.start = start;
              this.end = end;
          }

          @Override
          public int compareTo(Object o) {
              return this.start - ((Line) o).start;
          }
      }

      public boolean isRectangleCover(int[][] rectangles) {
          int len = rectangles.length;
          List<Line>[] arr = new ArrayList[4];
          for (int i = 0; i < arr.length; i++) {
              arr[i] = new ArrayList<>();
          }
          int minX = Integer.MAX_VALUE, maxA = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxB = Integer.MIN_VALUE;
          for (int i = 0; i < len; i++) {
              int x = rectangles[i][0], y = rectangles[i][1], a = rectangles[i][2], b = rectangles[i][3];
              for (int j = 0; j < i; j++) {
                  int x1 = rectangles[j][0], y1 = rectangles[j][1], a1 = rectangles[j][2], b1 = rectangles[j][3];
                  if ((x >= x1 && x < a1 && y >= y1 && y < b1) || (a > x1 && a <= a1 && b > y1 && b <= b1)
                  || (x <= x1 && a >= a1 && y <= y1 && b >= b1)) {
                      return false;
                  }
              }
              if (x <= minX) {
                  if (x < minX) {
                      minX = x;
                      arr[0].clear();
                  }
                  arr[0].add(new Line(y, b));
              }
              if (y <= minY) {
                  if (y < minY) {
                      minY = y;
                      arr[1].clear();
                  }
                  arr[1].add(new Line(x, a));
              }
              if (a >= maxA) {
                  if (a > maxA) {
                      maxA = a;
                      arr[2].clear();
                  }
                  arr[2].add(new Line(y, b));
              }
              if (b >= maxB) {
                  if (b > maxB) {
                      maxB = b;
                      arr[3].clear();
                  }
                  arr[3].add(new Line(x, a));
              }
          }
          for (List<Line> lines : arr) {
              Collections.sort(lines);
              int size = lines.size();
              for (int i = 1; i < size; i++) {
                  if (lines.get(i).start != lines.get(i - 1).end) {
                      return false;
                  }
              }
          }
/*        System.out.println(arr[0].get(0).start == minY);
        System.out.println(arr[0].get(arr[0].size() - 1).end == maxB);
        System.out.println(arr[2].get(0).start == minY);
        System.out.println(arr[2].get(arr[2].size() - 1).end == maxB);
        System.out.println(arr[3].get(0).start == minX);
        System.out.println(arr[3].get(arr[3].size() - 1).end == maxA);
        System.out.println(arr[1].get(0).start == minX);
        System.out.println(arr[1].get(arr[1].size() - 1).end == maxA);*/
          return arr[0].get(0).start == minY
                  && arr[0].get(arr[0].size() - 1).end == maxB
                  && arr[2].get(0).start == minY
                  && arr[2].get(arr[2].size() - 1).end == maxB
                  && arr[3].get(0).start == minX
                  && arr[3].get(arr[3].size() - 1).end == maxA
                  && arr[1].get(0).start == minX
                  && arr[1].get(arr[1].size() - 1).end == maxA;
      }
  }

//leetcode submit region end(Prohibit modification and deletion)

}
