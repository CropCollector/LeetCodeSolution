package leetcode.editor.cn;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Java：基于时间的键值存储
public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap map = new TimeBasedKeyValueStore().new TimeMap();
        map.set("a", "bar", 1);
        map.set("x", "b", 3);
        map.get("b", 3);
        map.set("foo", "bar2", 4);
        map.get("foo", 4);
        map.get("foo", 5);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class TimeMap {

    Map<String, ArrayList<Integer>> map;
    Map<String, HashMap<Integer, String>> valueMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
        valueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Integer> a = map.getOrDefault(key, new ArrayList<>());
        a.add(timestamp);
        map.put(key, a);

        HashMap<Integer, String> m = valueMap.getOrDefault(key, new HashMap<>());
        m.put(timestamp, value);
        valueMap.put(key, m);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Integer> a = map.get(key);
        if (a == null || a.isEmpty() || a.get(0) > timestamp) {
            return "";
        }
        Integer i = binarySearch(a, timestamp);
        return valueMap.get(key).get(i);
    }

    private Integer binarySearch(ArrayList<Integer> arr, int target) {
        // 二分查找
        int i = 0, j = arr.size();
        while (i < j) {
            int mid = (i + j) / 2;
            int value = arr.get(mid);
            if (value > target) {
                j = mid;
            } else if (value < target) {
                i = mid + 1;
            } else {
                return arr.get(mid);
            }
        }
        return arr.get(i - 1);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

}