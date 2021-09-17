package leetcode.editor.cn;

import java.util.HashMap;

//Java：有效的数独
public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        // TO TEST
        System.out.println(solution.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.') continue;
                if (map.get(board[i][j]) != null) {
                    return false;
                }
                map.put(board[i][j], 1);
            }
        }

        for (int j = 0; j < len; j++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                if (board[i][j] == '.') continue;
                if (map.get(board[i][j]) != null) {
                    return false;
                }
                map.put(board[i][j], 1);
            }
        }

        for (int i = 0; i < len; i += 3) {
            for (int j = 0; j < len; j += 3) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (int k = 0; k < 3; k ++) {
                    for (int l = 0; l < 3; l ++) {
                        if (board[i + k][j + l] == '.') continue;
                        if (map.get(board[i + k][j + l]) != null) {
                            return false;
                        }
                        map.put(board[i + k][j + l], 1);
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}