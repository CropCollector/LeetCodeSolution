package leetcode.editor.cn.demos;

public class RabinKarp {

    private final static int PRIME = 31;
    private final static int MOD = (int) (1e8 - 7);

    public static void main(String[] args) {
        String str = "asdjksajdkl";
        System.out.println(hash(str));
    }

    private static int hash(String str) {
        int len = str.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = (PRIME * res + (str.charAt(i) - 'a')) % MOD;
        }
        return res;
    }

}
