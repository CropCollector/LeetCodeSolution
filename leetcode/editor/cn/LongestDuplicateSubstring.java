//给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。 
//
// 返回 任意一个 具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "banana"
//输出："ana"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 二分查找 后缀数组 滑动窗口 哈希函数 滚动哈希 👍 277 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

public class LongestDuplicateSubstring{
  public static void main(String[] args) {
       Solution solution = new LongestDuplicateSubstring().new Solution();
       System.out.println(solution.longestDupSubstring("okmzpmxzwjbfssktjtebhhxfphcxefhonkncnrumgduoaeltjvwqwydpdsrbxsgmcdxrthilniqxkqzuuqzqhlccmqcmccfqddncchadnthtxjruvwsmazlzhijygmtabbzelslebyrfpyyvcwnaiqkkzlyillxmkfggyfwgzhhvyzfvnltjfxskdarvugagmnrzomkhldgqtqnghsddgrjmuhpgkfcjkkkaywkzsikptkrvbnvuyamegwempuwfpaypmuhhpuqrufsgpiojhblbihbrpwxdxzolgqmzoyeblpvvrnbnsdnonhpmbrqissifpdavvscezqzclvukfgmrmbmmwvzfpxcgecyxneipexrzqgfwzdqeeqrugeiupukpveufmnceetilfsqjprcygitjefwgcvqlsxrasvxkifeasofcdvhvrpmxvjevupqtgqfgkqjmhtkyfsjkrdczmnettzdxcqexenpxbsharuapjmdvmfygeytyqfcqigrovhzbxqxidjzxfbrlpjxibtbndgubwgihdzwoywqxegvxvdgaoarlauurxpwmxqjkidwmfuuhcqtljsvruinflvkyiiuwiiveplnxlviszwkjrvyxijqrulchzkerbdyrdhecyhscuojbecgokythwwdulgnfwvdptzdvgamoublzxdxsogqpunbtoixfnkgbdrgknvcydmphuaxqpsofmylyijpzhbqsxryqusjnqfikvoikwthrmdwrwqzrdmlugfglmlngjhpspvnfddqsvrajvielokmzpmxzwjbfssktjtebhhxfphcxefhonkncnrumgduoaeltjvwqwydpdsrbxsgmcdxrthilniqxkqzuuqzqhlccmqcmccfqddncchadnthtxjruvwsmazlzhijygmtabbzelslebyrfpyyvcwnaiqkkzlyillxmkfggyfwgzhhvyzfvnltjfxskdarvugagmnrzomkhldgqtqnghsddgrjmuhpgkfcjkkkaywkzsikptkrvbnvuyamegwempuwfpaypmuhhpuqrufsgpiojhblbihbrpwxdxzolgqmzoyeblpvvrnbnsdnonhpmbrqissifpdavvscezqzclvukfgmrmbmmwvzfpxcgecyxneipexrzqgfwzdqeeqrugeiupukpveufmnceetilfsqjprcygitjefwgcvqlsxrasvxkifeasofcdvhvrpmxvjevupqtgqfgkqjmhtkyfsjkrdczmnettzdxcqexenpxbsharuapjmdvmfygeytyqfcqigrovhzbxqxidjzxfbrlpjxibtbndgubwgihdzwoywqxegvxvdgaoarlauurxpwmxqjkidwmfuuhcqtljsvruinflvkyiiuwiiveplnxlviszwkjrvyxijqrulchzkerbdyrdhecyhscuojbecgokythwwdulgnfwvdptzdvgamoublzxdxsogqpunbtoixfnkgbdrgknvcydmphuaxqpsofmylyijpzhbqsxryqusjnqfikvoikwthrmdwrwqzrdmlugfglmlngjhpspvnfddqsvrajviel"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

      private final int PRIME = 31;
      private final long MOD = (long) (1e9 - 7);

      public String longestDupSubstring(String s) {
          int l = 1, r = s.length() - 1;
          while (l < r) {
              int mid = (r + l + 1) >> 1;
              if (getDupSubString(s, mid).equals("")) {
                  r = mid - 1;
              } else {
                  l = mid;
              }
          }
          return getDupSubString(s, l);
      }

      private String getDupSubString(String s, int size) {
          HashSet<Long> set = new HashSet<>();
          long h = hash(s.substring(0, size));
          set.add(h);

          for (int i = 1; i + size - 1 < s.length(); i++) {
              h = ((h * PRIME) % MOD + s.charAt(i + size - 1) - (pow(PRIME, size, MOD) * (long) s.charAt(i - 1)) % MOD) % MOD;
              if (h < 0) h += MOD;
              // 避免哈希冲突导致的误判
              String subStr = s.substring(i, i + size);
              if (set.contains(h) && s.indexOf(subStr) != i) {
                  return subStr;
              } else {
                  set.add(h);
              }
          }
          return "";
      }

      private long hash(String str) {
          int len = str.length();
          long res = 0;
          for (int i = 0; i < len; i++) {
              res = (PRIME * res + str.charAt(i)) % MOD;
              if (res < 0) res += MOD;
          }
          return res;
      }

      public long pow(int a, int m, long mod) {
          long ans = 1;
          long contribute = a;
          while (m > 0) {
              if (m % 2 == 1) {
                  ans = ans * contribute % mod;
                  if (ans < 0) {
                      ans += mod;
                  }
              }
              contribute = contribute * contribute % mod;
              if (contribute < 0) {
                  contribute += mod;
              }
              m /= 2;
          }
          return ans;
      }

  }
//leetcode submit region end(Prohibit modification and deletion)

}
