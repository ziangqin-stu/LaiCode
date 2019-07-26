package String;

public class RightShift {
    // assume: n >= 0
    // time: O(n), space: O(1)
    public String rightShift(String input, int n) {
        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        int newStart = n % array.length;
        reverse(array, 0, newStart - 1);
        reverse(array, newStart, array.length - 1);

        return new String(array);
    }

    private void reverse(char[] array, int l, int r) {
        while (l < r) {
            swap(array, l++, r--);
        }
    }

    private void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        RightShift sol = new RightShift();
        String res1 = sol.rightShift("abcdef", 2);
        System.out.println(res1);
    }
}
