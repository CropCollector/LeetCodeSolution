package leetcode.editor.cn;

//Java：第 N 位数字
public class NthDigit {
    public static void main(String[] args) {
        Solution solution = new NthDigit().new Solution();
        // TO TEST
        System.out.println(solution.findNthDigit(100));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        int i;
        for (i = 0; i <= 15; i++) {
            int num = (int) (9 * Math.pow(10, i) * (i + 1));
            if (n > num) {
                n -= num;
            } else {
                break;
            }
        }
        // Math.pow(10 ,i) 从第几个数开始，即i = 0，从1开始；i = 1，从10开始；因为要去除其本身，所以要-1
        // i + 1表示当前范围的数有几位，即i = 0，则这个区间（1 - 9）有1位数；i = 1（10 - 99）有2位数
        // n / (i + 1) 表示剩余的n中可以满足几个 i + 1的位数，即从 Math.pow(10 ,i) 往后要数几个数
        int curNum = (int) Math.pow(10, i) - 1 + n / (i + 1);
        int curIndex = n % (i + 1) - 1;
        if (curIndex != -1) {
            curNum ++;
        } else {
            curIndex = i + 1 - 1;
        }
        return String.valueOf(curNum).charAt(curIndex) - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}