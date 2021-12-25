package leetcode.editor.cn.contest;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class ContestSolution {
    public static void main(String[] args) {
     /*   Solution solution = new ContestSolution().new Solution();
        // TO TEST
        System.out.println(solution.wateringPlants(new int[]{3,2,4,2,1}, 6));*/
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        System.out.println(new RangeFreqQuery(new int[]{1}).bsFloor(list, 0));

    }

    static class RangeFreqQuery {

        private HashMap<Integer, List<Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            int len = arr.length;
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
                list.add(i);
                map.put(arr[i], list);
            }
            for (Integer key : map.keySet()) {
                Collections.sort(map.get(key));
            }
        }

        public int query(int left, int right, int value) {
            int ans = 0;
            if (map.containsKey(value)) {
                List<Integer> list = map.get(value);
                int l = bsCeiling(list, left);
                int r = bsFloor(list, right);
                ans = r - l + 1;
            }
            return ans;
        }

        private int bsFloor(List<Integer> list, int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int mid = (l + r) >> 1;
                if (list.get(mid) > target) {
                    r = mid;
                } else if (list.get(mid) < target) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }
            return l;
        }

        private int bsCeiling(List<Integer> list, int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int mid = (l + r) >> 1;
                if (list.get(mid) > target) {
                    r = mid;
                } else if (list.get(mid) < target) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }
            return l - 1;
        }
    }



}