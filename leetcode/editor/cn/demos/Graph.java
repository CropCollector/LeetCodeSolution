package leetcode.editor.cn.demos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Spica
 * @date 2021/12/16 下午5:05
 */
public class Graph {

    public Map<Integer, List<Integer>> table = new HashMap<>();

    public void addLine(Integer start, Integer end) {
        List<Integer> list = table.getOrDefault(start, new ArrayList<>());
        list.add(end);
        table.put(start, list);
    }

}
