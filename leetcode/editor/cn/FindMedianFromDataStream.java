package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：数据流的中位数
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new FindMedianFromDataStream().new MedianFinder();
        // TO TEST
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(9);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    PriorityQueue<Integer> smaller;

    PriorityQueue<Integer> bigger;

    /** initialize your data structure here. */
    public MedianFinder() {
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
        bigger = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (smaller.isEmpty() && bigger.isEmpty()) {
            smaller.add(num);
            return;
        }
        Integer big = bigger.peek();
        if (big != null && big <= num) {
            bigger.add(num);
        } else {
            smaller.add(num);
        }
        if (smaller.size() - bigger.size() == 2) {
            bigger.add(smaller.poll());
        } else if (bigger.size() - smaller.size() == 2) {
            smaller.add(bigger.poll());
        }
    }
    
    public double findMedian() {
        if (smaller.size() == bigger.size()) {
            return (smaller.peek() + bigger.peek()) / 2.0;
        }
        if (smaller.size() > bigger.size()) {
            return smaller.peek();
        } else {
            return bigger.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}