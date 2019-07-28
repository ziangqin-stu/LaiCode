package InterView.PinDuoDuo;

public class shortestReapeatSubstring {
    public String shortestReapeatSubstring(String input) {
        // base case
        if (input == null || input.length() <= 1 || input.length() % 2 == 1) {
            return input;
        }

        char[] array = input.toCharArray();
        int fast = 0; // array[fast] is potentially the last word of shortest repeated substring
                    // or checking character in following shortest repeated substring
        int slow = 1; // array[slow] corresponding character of array[fast] in previous shortest repeated substring

        int maxLen = 0;
        while (fast < array.length / 2) {
            if (array[fast] == array[slow]) {

            } else {
                maxLen = fast + 1;
                fast++;
                slow = 0;
            }
        }
        return new String(array, 0, maxLen + 1);
     }
}
