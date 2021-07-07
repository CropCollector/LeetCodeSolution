package leetcode.editor.cn;

import java.util.*;

//Java：原子的数量
public class NumberOfAtoms {
    public static void main(String[] args) {
        Solution solution = new NumberOfAtoms().new Solution();
        // TO TEST
        System.out.println(solution.countOfAtoms("((Md16Cm19HfNe47K29(NeW42ZrPd9)17Ag7Ar6P9HsFr18Ar18O31Tc5Md42(W6Sn5Er29SB40Ho42Co31Si42)44)7(La24Au2Bh12MoFr11LaHf24Re13Bh20Sc2)41(Tb33BLi14Al35Cu14)9Rh5Tl(Cr3SNd20Fe)14B27Cf48H11Sb8Sb25HsRhCm40(Fe4Cs13At49)26((Co6RnMg15Be30Hs9)40(Rg43SNoCn29F)2(Md25DbMn27Ni41)22(Ac28Pu50PdHoNa50)40(Fm28B15In)16(Pb41PmHf24Zn4Ts39Np25Tl47Lu47)6(Ru3Ni20Sm35)16(Ru23RaAt5Cs15Ga)8(Ra26Sb16Cr44Ds25Ar23Pm34C49)6)41(ThBSc15W(Nh12Li42Ts5Sr11Mn2Ga22W3)40(Bh50No12Zr43Mo18As18Sc17Ti17Ca28Tc50)11)6(Pr(Sb46Dy14Fe11)42)"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Atom {
        Map<String, Integer> map;
        boolean isLeft;

        public Atom(Map<String, Integer> map) {
            this.map = map;
        }

        public Atom(boolean isLeft) {
            this.isLeft = isLeft;
        }

    }

    public String countOfAtoms(String formula) {
        Stack<Atom> stack = new Stack<>();
        stack.add(new Atom(new TreeMap<>()));

        StringBuffer curAtom = new StringBuffer();
        StringBuffer curNum = new StringBuffer();
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.add(new Atom(true));
            } else if (Character.isUpperCase(c)) {
                curAtom.append(c);
                while (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
                    curAtom.append(formula.charAt(++ i));
                }
                if (i + 1 ==  formula.length() || formula.charAt(i + 1) == '(') {
                    Atom atom = stack.peek();
                    if (atom.isLeft) {
                        Map<String, Integer> map = new TreeMap<>();
                        map.put(curAtom.toString(), 1);
                        stack.add(new Atom(map));
                    } else {
                        atom = stack.pop();
                        Map<String, Integer> map = atom.map;
                        map.put(curAtom.toString(), map.getOrDefault(curAtom.toString(), 0) + 1);
                        stack.add(new Atom(map));
                    }
                } else if (Character.isUpperCase(formula.charAt(i + 1)) || formula.charAt(i + 1) == ')') {
                    Atom atom = stack.peek();
                    if (atom.isLeft) {
                        Map<String, Integer> map = new TreeMap<>();
                        map.put(curAtom.toString(), 1);
                        stack.add(new Atom(map));
                    } else {
                        atom = stack.pop();
                        Map<String, Integer> map = atom.map;
                        map.put(curAtom.toString(), map.getOrDefault(curAtom.toString(), 0) + 1);
                        stack.add(new Atom(map));
                    }
                } else {
                    while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                        curNum.append(formula.charAt(++ i));
                    }
                    Atom atom = stack.peek();
                    if (atom.isLeft) {
                        Map<String, Integer> map = new TreeMap<>();
                        map.put(curAtom.toString(), Integer.valueOf(curNum.toString()));
                        stack.add(new Atom(map));
                    } else {
                        atom = stack.pop();
                        Map<String, Integer> map = atom.map;
                        map.put(curAtom.toString(), map.getOrDefault(curAtom.toString(), 0) + Integer.valueOf(curNum.toString()));
                        stack.add(new Atom(map));
                    }
                }
                curAtom = new StringBuffer();
                curNum = new StringBuffer();
            } else {
                // 右括号
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    curNum.append(formula.charAt(++ i));
                }
                if (curNum.length() == 0) curNum.append(1);
                Integer n = Integer.valueOf(curNum.toString());
                Atom atom = stack.pop();
                Map<String, Integer> map = atom.map;
                map.forEach((k, v) -> map.put(k, v * n));
                // 弹出左括号
                stack.pop();
                Atom result = stack.peek();
                if (!result.isLeft) {
                    result = stack.pop();
                    Map<String, Integer> resultMap = result.map;
                    map.forEach((k, v) -> resultMap.put(k, resultMap.getOrDefault(k, 0) + v));
                    stack.add(new Atom(resultMap));
                } else {
                    Map<String, Integer> resultMap = new TreeMap<>();
                    map.forEach((k, v) -> resultMap.put(k, resultMap.getOrDefault(k, 0) + v));
                    stack.add(new Atom(resultMap));
                }
                curNum = new StringBuffer();
            }
        }
        StringBuffer result = new StringBuffer();
        stack.pop().map.forEach((k, v) -> {
            result.append(k);
            if (v != 1) {
                result.append(v);
            }
        });
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}