package leetcode.editor.cn;

import java.util.*;

//Java：点菜展示表
public class DisplayTableOfFoodOrdersInARestaurant {
    public static void main(String[] args) {
        Solution solution = new DisplayTableOfFoodOrdersInARestaurant().new Solution();
        // TO TEST
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("David","3","Ceviche"));
        list.add(Arrays.asList("Corina","10","Beef Burrito"));
        list.add(Arrays.asList("David","3","Fried Chicken"));
        list.add(Arrays.asList("Carla","5","Water"));
        list.add(Arrays.asList("Carla","5","Ceviche"));
        list.add(Arrays.asList("Rous","3","Ceviche"));
        solution.displayTable(list);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, HashMap<String, Integer>> map = new TreeMap<>();
        TreeSet<String> menus = new TreeSet<>();
        for (List<String> order : orders) {
            Integer table = Integer.parseInt(order.get(1));
            String menu = order.get(2);
            menus.add(menu);
            HashMap<String, Integer> tableOrderMap = map.getOrDefault(table, new HashMap<>());
            tableOrderMap.put(menu, tableOrderMap.getOrDefault(menu, 0) + 1);
            map.put(table, tableOrderMap);
        }

        List<List<String>> out = new ArrayList<>();

        List<String> title = new ArrayList<>();
        title.add("Table");
        for (String menu : menus) {
            title.add(menu);
        }
        out.add(title);

        for (Map.Entry<Integer, HashMap<String, Integer>> entry : map.entrySet()) {
            List<String> table = new ArrayList<>();
            table.add(entry.getKey().toString());
            HashMap<String, Integer> tableOrderMap = entry.getValue();
            for (String menu : menus) {
                table.add(tableOrderMap.getOrDefault(menu, 0).toString());
            }
            out.add(table);
        }
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}