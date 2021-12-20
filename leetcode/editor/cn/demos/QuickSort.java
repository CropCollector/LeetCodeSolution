package leetcode.editor.cn.demos;

import leetcode.editor.cn.utils.ArraysUtils;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 7, 2, 3, 4, 6, 10, 1, 34};
        quickSort(arr, 0, arr.length - 1);
        ArraysUtils.print(arr);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int l = start, r = end;
        while (l < r) {
            // 此处需添加等号，这两部旨在找到比基准arr[start]大/小的数，对于等于基准的数无需交换
            // 且若不添加等号，l和r指向的数同时等于基准时会出现死循环
            while (l < r && arr[r] >= arr[start]) {
                r --;
            }
            while (l < r && arr[l] <= arr[start]) {
                l ++;
            }
            ArraysUtils.swap(arr, r, l);
        }
        ArraysUtils.swap(arr, start, l);
        quickSort(arr, start, l - 1);
        quickSort(arr, l + 1, end);
    }

}
