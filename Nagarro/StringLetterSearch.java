package Tree.Nagarro;

import java.util.HashSet;
import java.util.Set;

public class StringLetterSearch {
    public static void main(String[] args) {
        String inp1 = "my name is granar";
        String inpt2 = "a";
        System.out.println(getMaxLength(inp1, inpt2));
    }

    private static int getMaxLength(String inp1, String inpt2) {
        String original = inp1.replaceAll(" ","");
        char ch = inpt2.charAt(0);

        Set<Character> set = new HashSet<>();

        int start = original.indexOf(inpt2);
        int end = original.lastIndexOf(inpt2);

        if(start == -1 || start == end) {
            return -1;
        } else {
            for(int i = start; i<end; i++) {
                if(original.charAt(i) != ch) {
                    set.add(original.charAt(i));
                }
            }
        }

        return set.size();
    }
}
