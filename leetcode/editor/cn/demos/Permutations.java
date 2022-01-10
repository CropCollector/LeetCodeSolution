package leetcode.editor.cn.demos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Spica
 * @description 全排列 - 回溯
 * @date 2021/12/30 下午3:57
 */
public class Permutations {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        find(list, 0);
    }

    private static void find(List<Integer> list, int start) {
        if (start == list.size() - 1) {
            System.out.println(list);
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, i, start);
            find(list, start + 1);
            Collections.swap(list, i, start);
        }
    }

}
