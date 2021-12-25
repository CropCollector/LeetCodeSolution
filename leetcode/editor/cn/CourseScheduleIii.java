package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Java：课程表 III
public class CourseScheduleIii {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIii().new Solution();
        // TO TEST
        System.out.println(solution.scheduleCourse(new int[][]{{10,12},{6,15},{1,12},{3,20},{10,19}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scheduleCourse(int[][] courses) {
            int len = courses.length;
            // 按ddl从小到大排序
            // 假设course1 course2的用时分别为1，3，ddl分别为2，4；那么必然是先做ddl在前面的课程，因为如果先做ddl晚的课程如果可以完成，那么先做ddl早的课程必然可以完成
            Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
            int curDay = 0;
            PriorityQueue<int[]> pqAns = new PriorityQueue<>((c1, c2) -> (c2[0] - c1[0]));
            for (int i = 0; i < len; i++) {
                int[] course = courses[i];
                // 新课程在新ddl中可以完成 直接学
                if (curDay + course[0] <= course[1]) {
                    pqAns.add(course);
                    curDay += course[0];
                } else {
                    // 新ddl不足以学习新课程 找到现有课程中用时最长的课程 与当前课程比较 如当前课程用时更短 则替换
                    // 这个替换逻辑解释：当前课程的ddl只可能比前面pq中课程长（course已按ddl从小到大排序） 若用时再比前面课程小 则这个替换必定是更优的 ddl更久（或相同）学习用时更少
                    if (!pqAns.isEmpty() && pqAns.peek()[0] >= course[0]) {
                        curDay =  curDay - pqAns.poll()[0] + course[0];
                        pqAns.add(course);
                    }
                }
            }
            return pqAns.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}