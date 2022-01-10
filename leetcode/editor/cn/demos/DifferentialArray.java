package leetcode.editor.cn.demos;

import leetcode.editor.cn.utils.ArraysUtils;

/**
 * @author Spica
 * @date 2022/1/10 下午5:16
 * @description 差分数组
 */
public class DifferentialArray {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 2, 1, 3, 4, 6, 7};

        int[] d = create(arr);
        ArraysUtils.print(getArr(d));
        System.out.println();
        addArr(d, 1, 8, 100);
        ArraysUtils.print(getArr(d));
    }


    private static void addArr(int[] d, int start, int end, int value) {
        // 通过对差分数组 实现O(1)对原数组的[start, end]区间内数据的值增加value
        d[start] += value;
        d[end + 1] -= value;
    }

    private static int[] getArr(int[] d) {
        // 根据差分数组还原原数组
        int len = d.length - 1;
        int[] arr = new int[len];
        arr[0] = d[0];
        for (int i = 1; i < len; i++) {
            arr[i] = arr[i - 1] + d[i];
        }
        return arr;
    }

    private static int[] create(int[] arr) {
        // 构建差分数组，d[0] = arr[0], d[i] = arr[i] - arr[i - 1], d[len] = 0
        // 差分数组最后多一位 防止增加数据的时候数组越界
        int len = arr.length;
        int[] d = new int[len + 1];
        d[0] = arr[0];
        for (int i = 1; i < len; i++) {
            d[i] = arr[i] - arr[i - 1];
        }
        return d;
    }

}
