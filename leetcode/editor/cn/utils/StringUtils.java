package leetcode.editor.cn.utils;

public class StringUtils {

    public static void main(String[] args) {
        String r = replace2("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        System.out.println(r);
    }

    public static String replace(String str) {
        return str.replace("[", "{").replace("]", "}");
    }

    public static String replace2(String str) {
        return str.replace("[", "{").replace("]", "}").replace("\"", "'");
    }


}
