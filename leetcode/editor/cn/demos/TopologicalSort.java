package leetcode.editor.cn.demos;

import java.util.*;

/**
 * @author Spica
 * @date 2021/12/16 下午4:59
 */
public class TopologicalSort {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addLine(5, 0);
        graph.addLine(5, 2);
        graph.addLine(4, 0);
        graph.addLine(4, 1);
        graph.addLine(2, 3);
        graph.addLine(3, 1);

        List<Integer> result = topologicalSort(graph);
        System.out.println(result);
    }

    private static List<Integer> topologicalSort(Graph graph) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> inCount = new HashMap<>();
        for (Integer start : graph.table.keySet()) {
            inCount.put(start, 0);
        }
        for (List<Integer> list : graph.table.values()) {
            for (Integer end : list) {
                inCount.put(end, inCount.getOrDefault(end, 0) + 1);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (Integer start : inCount.keySet()) {
            if (inCount.get(start) == 0) {
                queue.add(start);
            }
        }
        while (!queue.isEmpty()) {
            int start = queue.poll();
            result.add(start);
            List<Integer> list = graph.table.get(start);
            if (list != null && !list.isEmpty()) {
                for (Integer end : list) {
                    inCount.put(end, inCount.get(end) - 1);
                    if (inCount.get(end) == 0) {
                        queue.add(end);
                    }
                }
            }
        }
        return result;
    }

}