package String;

public class StringReverse {
    // time: O(n), space: O(1)
    public String reverseIteratively(String input) {
        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray(); // array.length >= 2
        int h = 0;
        int t = array.length - 1;
        while (h < t) {
            swap(array, h++, t--);
        }
        return new String(array);
    }

    // time: O(n), space:O(n)
    public String reverseRecursively(String input) {
        // method: 虚线框在中间, 然后首尾交换
        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();
        recursionHelper(array, 0, array.length - 1);
        return new String(array);
    }

    private void recursionHelper(char[] array, int h, int t) {
        if (h >= t) {
            return;
        }
        recursionHelper(array, h + 1, t - 1);
        swap(array, h, t);
    }

    private void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        StringReverse sol = new StringReverse();
        String res1 = sol.reverseIteratively("apple");
        System.out.println(res1);

        String res2 = sol.reverseRecursively("apple");
        System.out.println(res2);
    }
}
