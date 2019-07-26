package String;

import java.util.HashSet;
import java.util.Set;

public class PracticeMore {
    // assume: input is not null
    // time: O(n), space: O(n)
    public int longest(String input) {
        // base case
        if (input.length() <= 1) {
            return input.length();
        }

        int maxLength = 0;
        int begin = 0; // window interval = [begin, end]
        int end = 0;
        Set<Character> set = new HashSet<Character>(); // store distinguish characters in current window

        while (end < input.length()) {
            if (!set.contains(input.charAt(end))) {
                set.add(input.charAt(end++));
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(input.charAt(begin++));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        PracticeMore sol = new PracticeMore();
        int res = sol.longest("efhrgsayekasdanfev");
        System.out.println(res);
    }
}
