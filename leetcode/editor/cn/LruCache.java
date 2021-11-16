//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 1655 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class LruCache {
    public static void main(String[] args) {
        LRUCache solution = new LruCache().new LRUCache(2);
        solution.put(1, 1);
        solution.put(2, 2);
        solution.get(1);
        solution.put(3, 3);
        solution.get(2);
        solution.put(4, 4);
        solution.get(1);
        solution.get(3);
        solution.get(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private HashMap<Integer, Integer> cacheMap;
        private HashMap<Integer, Integer> countMap;
        private Queue<Integer> q;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cacheMap = new HashMap<>();
            countMap = new HashMap<>();
            q = new ArrayDeque<>();
        }

        public int get(int key) {
            if (!cacheMap.containsKey(key)) {
                return -1;
            }
            // count + 1
            countMap.put(key, countMap.get(key) + 1);
            q.add(key);
            return cacheMap.get(key);
        }

        public void put(int key, int value) {
            if (!cacheMap.containsKey(key) && cacheMap.size() == capacity) {
                del();
            }
            cacheMap.put(key, value);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            q.add(key);

        }

        private void del() {
            while (true) {
                int i = q.poll();
                if (countMap.get(i) != 1) {
                    countMap.put(i, countMap.get(i) - 1);
                } else {
                    cacheMap.remove(i);
                    countMap.remove(i);
                    break;
                }
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
