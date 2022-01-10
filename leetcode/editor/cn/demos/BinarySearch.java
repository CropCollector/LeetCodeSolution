package leetcode.editor.cn.demos;

/**
 * @author Spica
 * @date 2021/12/20 上午11:28
 */
public class BinarySearch {
    
    private static int[] arr = new int[]{1, 3, 5, 6, 8, 9, 12, 15};

    public static void main(String[] args) {
        int index = binarySearch(4);
        System.out.println(index);
        
        int floor = binarySearchFloor(111);
        System.out.println(floor);
        
        int ceiling = binarySearchCeiling(0);
        System.out.println(ceiling);
    }

    // 二分查找 找不到值就返回-1
    private static int binarySearch(int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 找到小于等于目标值的最大index
    private static int binarySearchFloor(int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // 取中值高位
            int mid = (left + right + 1) >> 1;
            // 小于等于目标值都要往右找 写成arr[mid] >= target的话 大于的时候往左找 等于的时候往右找 就8行
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return arr[left] > target ? -1 : left;
    }

    // 找到大于等于目标值的最小index
    private static int binarySearchCeiling(int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // 取中值低位
            int mid = (left + right) >> 1;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[right] < target ? -1 : right;
    }
}
