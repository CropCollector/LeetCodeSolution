package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Random;

//Java：打乱数组
public class ShuffleAnArray {
    public static void main(String[] args) {
        Solution solution = new ShuffleAnArray().new Solution(new int[]{1,2,3});
        // TO TEST
        solution.shuffle();
        solution.reset();
        solution.shuffle();

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] ori;

    private int[] arr;

    private Random r = new Random();

    public Solution(int[] nums) {
        arr = nums;
        ori = arr.clone();
    }
    
    public int[] reset() {
        arr = ori.clone();
        return arr;
    }
    
    public int[] shuffle() {
        /*
         * fisher-yates洗牌算法
         * 将数组划分为未打乱和已打乱的两部分，每次在未打乱的数组中随机取一个数放到已打乱的数组中
         * 具体实现为从数据末尾遍历，从数组开头到当前遍历位置之中random一个数，然后和当前位置交换，（即此次操作后当前位置已被打乱，遍历过的数组即为已打乱的数组）
         */
        for (int i = arr.length - 1; i > 0; i --) {
            int index = r.nextInt(i + 1);
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}