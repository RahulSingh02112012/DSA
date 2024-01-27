package Tree.PrefixSum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass {
    public static void main(String[] args) {
        String[] splittedExpression = "${a} + 10".split(" ");
        if(splittedExpression[0].startsWith("$")) {
            String dependVariable = extractVariableName(splittedExpression[0]);
            System.out.println(dependVariable);
        }
    }

    private static String extractVariableName(String input) {
        // Define a regular expression pattern to match "${...}" and capture the variable name
        Pattern pattern = Pattern.compile("\\$\\{([^}]*)\\}");
        Matcher matcher = pattern.matcher(input);

        // Check if the pattern is found
        if (matcher.find()) {
            // Extract the variable name from the captured group
            return matcher.group(1);
        } else {
            // Return an empty string or handle the case where the pattern is not found
            return "";
        }
    }
}
