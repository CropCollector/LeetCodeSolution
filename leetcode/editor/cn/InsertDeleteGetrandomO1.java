package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

//Java：O(1) 时间插入、删除和获取随机元素
public class InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {

    private HashMap<Integer, Integer> map;

    private ArrayList<Integer> arr;

    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int last = arr.get(arr.size() - 1);
            arr.set(index, last);
            map.put(last, index);

            map.remove(val);
            arr.remove(arr.size() - 1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random r = new Random();
        int rand = r.nextInt(arr.size());
        return arr.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}