package leetcode.editor.cn;

import java.util.*;

//Java：打开转盘锁
public class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();
        // TO TEST
        System.out.println(solution.openLock(new String[]{"0002"}, "0003"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Bean {
        String value;
        Integer step;

        Bean(String value, Integer step) {
            this.value = value;
            this.step = step;
        }
    }


    public int openLock(String[] deadends, String target) {
        Boolean[] flag = new Boolean[10000];
        for (int i = 0; i < 10000; i++) {
            flag[i] = false;
        }

        String start = "0000";
        Integer step = -1;
        List<String> dList = Arrays.asList(deadends);
        TreeSet<String> dSet = new TreeSet<>();
        dSet.addAll(dList);

        Queue<Bean> q = new LinkedList<>();
        q.add(new Bean(start, 0));
        while (!q.isEmpty()) {
            Bean bean = q.poll();
            String value = bean.value;
            Integer curStep  = bean.step;
            //System.out.println(String.format("cur %s, step %s", value, curStep));
            flag[Integer.valueOf(value)] = true;
            if (dSet.contains(value)) {
                continue;
            }
            if (target.equals(value)) {
                step = bean.step;
                break;
            }
            for (int i = 0; i < 4; i ++) {
                Integer num = Integer.valueOf(String.valueOf(value.charAt(i)));
                if (num != 9) {
                    String next = value.substring(0, i) + (num + 1) + value.substring(i + 1, 4);
                    if (!flag[Integer.valueOf(next)]) {
                        flag[Integer.valueOf(next)] = true;
                        q.add(new Bean(next, curStep + 1));
                        //System.out.println(String.format("cur %s, next %s, step %s", value, next, curStep));
                    }
                }
                if (num != 0) {
                    String next = value.substring(0, i) + (num - 1) + value.substring(i + 1, 4);
                    if (!flag[Integer.valueOf(next)]) {
                        flag[Integer.valueOf(next)] = true;
                        q.add(new Bean(next, curStep + 1));
                        //System.out.println(String.format("cur %s, next %s, step %s", value, next, curStep));
                    }
                } else {
                    String next = value.substring(0, i) + "9" + value.substring(i + 1, 4);
                    if (!flag[Integer.valueOf(next)]) {
                        flag[Integer.valueOf(next)] = true;
                        q.add(new Bean(next, curStep + 1));
                        //System.out.println(String.format("cur %s, next %s, step %s", value, next, curStep));
                    }
                }
            }
        }
        return step;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}