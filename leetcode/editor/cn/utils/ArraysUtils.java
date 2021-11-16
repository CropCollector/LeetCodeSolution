package leetcode.editor.cn.utils;

public class ArraysUtils {

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
