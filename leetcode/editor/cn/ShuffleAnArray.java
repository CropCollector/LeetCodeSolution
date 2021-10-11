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
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(list.size());
            int num = list.get(index);
            list.remove(index);
            arr[i] = num;
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