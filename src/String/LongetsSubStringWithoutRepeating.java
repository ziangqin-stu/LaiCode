package String;

import java.util.HashSet;
import java.util.Set;

public class LongetsSubStringWithoutRepeating {
    // assumption: input is not null
    // time: O(n), space: O(1)
    public int longest(String input) {
        // method: windowing
        // corner case
        if (input.length() <= 1) {
            return input.length();
        }

        int maxLength = 0;
        int begin = 0; // window interval [begin, end]: current unique sub-string that ends at [end]
        int end = 0;
        Set<Character> set = new HashSet<Character>(); // characters in sliding window
        while (end < input.length()) {
            if(!set.contains(input.charAt(end))) {
                set.add(input.charAt(end++));
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(input.charAt(begin++));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongetsSubStringWithoutRepeating sol = new LongetsSubStringWithoutRepeating();
        int res = sol.longest("efhrgsayekasdanfev");
        System.out.println(res);
    }
}
