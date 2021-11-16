package leetcode.editor.cn.demos;

import leetcode.editor.cn.utils.ArraysUtils;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 7, 2, 3, 4, 6, 10, 1, 34};
        quickSort(arr, 0, arr.length - 1);
        ArraysUtils.print(arr);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int l1 = l, r1= r;
        while (l1 < r1) {
            while (arr[r1] >= arr[l] && l1 < r1) {
                r1 --;
            }
            while (arr[l1] <= arr[l] && l1 < r1) {
                l1 ++;
            }
            if (l1 != r1) {
                ArraysUtils.swap(arr, l1, r1);
            }
        }
        ArraysUtils.swap(arr, l, l1);
        quickSort(arr, l, l1 - 1);
        quickSort(arr, l1 + 1, r);
    }

}
