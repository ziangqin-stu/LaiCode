package String;

public class ReverseWords {
    /* assumptions:
        1. words are separated by only one space
        2. no leading or tailing spaces;
    */
    // time: O(n), space: O(1)
    public String reverseWords(String input) {
        // method: iteratively reverse entire string and each word
        // base case
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);

        // 定位起止位置有更优雅的写法, 见JavaSolution
        int s = 0;  // word interval: [s, f];
        for (int f = 0; f < array.length; f++) { // array.length >= 2
            if (f == array.length - 1 || array[f + 1] == ' ') {
                reverse(array, s, f);
                s = f + 2;
            }
        }

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
        ReverseWords sol = new ReverseWords();
        String res = sol.reverseWords("a b c d");
        System.out.println(res);
    }
}
