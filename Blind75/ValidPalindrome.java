package Tree.Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        //System.out.println(Arrays.toString(s.chars().toArray()));

        s.chars().filter(c -> Character.isLetterOrDigit(c))
                .mapToObj(c -> Character.toLowerCase((char) c))
                .forEach(sb::append);
        List<Integer> list = new ArrayList<>();
        //list.equals();

        int start = 0;
        int end = sb.toString().length() - 1;

        while(start<=end) {
            if(sb.toString().charAt(start) != sb.toString().charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
