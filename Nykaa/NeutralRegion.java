package Tree.Nykaa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NeutralRegion {
    public static void main(String[] args) {
       /* System.out.println(isValid("PVPPPVV"));
        System.out.println(isValid("PPPP"));
        System.out.println(isValid("VVPPV"));
*/
        System.out.println(stringLen("PVPPPVV"));
        System.out.println(stringLen("PPPP"));
        System.out.println(stringLen("VVPPV"));
    }

    private static int getNeutralRegion(String s) {
        return 1;
    }

    public static int stringLen(String str) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);

        int countP = 0;
        int countV = 0;
        int res = 0;

        for (int ele = 0; ele < str.length(); ele++) {
            if (str.charAt(ele) == 'P') {
                countP += 1;
            } else {
                countV += 1;
            }

            if (m.containsKey(countV - countP)) {
                res = Math.max(res, ele - m.get(countV - countP));
            } else {
                m.put(countV - countP, ele);
            }
        }

        return res;
    }


    public static int isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (!st.isEmpty() && (arr[i] == 'P' && st.peek() == 'V') || (arr[i] == 'V' && st.peek() == 'P')) {
                st.pop();
            }
            st.push(arr[i]);
        }

        return s.length() - st.size();
    }
}