package Tree.Microsoft;

public class RemoveBanana {
    public int removeBanana(String s) {
        if (s.length() < 6) {
            return 0;
        }

        int b = 0;
        int a = 0;
        int n = 0;

        for (char c : s.toCharArray()) {
            if (c == 'B') {
                b++;
            } else if (c == 'A') {
                a++;
            } else if (c == 'N') {
                n++;
            }
        }

        return Math.min(
                b / 1, Math.min(a / 3, n / 2)
        );
    }

    public static void main(String[] args) {
        // Example usage:
        RemoveBanana solution = new RemoveBanana();
        String input = "BANANA";

        int result = solution.removeBanana(input);
        System.out.println("Minimum number of bananas to remove: " + result);
    }
}
