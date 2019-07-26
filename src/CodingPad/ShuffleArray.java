package CodingPad;

import java.util.Arrays;

public class ShuffleArray {
    public int[] reorder(int[] array) {
        // method: shuffle rcecursively
        // corner case
        if (array.length <= 1) {
            return array;
        }

        if (array.length % 2 == 0) {
            reorderHelper(array, 0, array.length - 1);
        } else {
            reorderHelper(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorderHelper(int[] array, int l, int r) {
        int size = r - l + 1;
        // base case:
        if (size <= 2) {
            return;
        }
        int m = l + size / 2;
        int lm = l + size / 4;
        int rm  = l + size * 3 / 4;

        reverse(array, lm, m - 1);
        reverse(array, m, rm - 1);
        reverse(array, lm, rm - 1);

        reorderHelper(array, l, l + 2 * (lm-l) - 1);
        reorderHelper(array, l+ 2 * (lm - l), r);
    }

    private void reverse(int[] array, int l, int r) {
        while (l < r) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }
     public static void main(String[] args) {
        ShuffleArray sol = new ShuffleArray();
        int[] res = sol.reorder(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14});
        System.out.println(Arrays.toString(res));
     }
}
