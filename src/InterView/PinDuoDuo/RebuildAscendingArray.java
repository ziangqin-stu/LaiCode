package InterView.PinDuoDuo;
import java.util.Arrays;

public class RebuildAscendingArray {
    public int[] rebuild(int[] a, int [] b) {
        // locate the target number
        int tar;
        boolean find = false;
        for (tar = 0; tar < a.length - 1; tar++) {
            if (a[tar + 1] <= a[tar]) {
                find = true;
                if (tar != 0) {
                    tar++;
                }
                break;
            }
        }
        if (!find) {
            for (tar = 1; tar < a.length; tar++) {
                if (a[tar - 1] >= a[tar]) {
                    find = true;
                    break;
                }
            }
        }
        if (!find) {
            return null;
        }

        // define candidate range [left+1 , right-1]
        boolean hasLeft = false;
        boolean hasRight = false;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        if (tar > 0) {
            hasLeft = true;
            left = a[tar - 1];
        }
        if (tar < a.length - 1) {
            hasRight = true;
            right = a[tar + 1];
        }

        // find biggest valid candidate
        int exchange = Integer.MIN_VALUE;
        boolean hasRes = false;
        for (int i = 0; i < b.length; i++) {
            if (isCandidate(hasLeft, hasRight, left, right, b[i])) {
                hasRes = true;
                exchange = Math.max(exchange, b[i]);
            }
        }

        if (!hasRes) {
            return null;
        }
        a[tar] = exchange;
        return a;
    }

    private boolean isCandidate(boolean hasLeft, boolean hasRight, int left, int right, int candidate) {
        if (hasLeft) {
            if (candidate <= left) {
                return false;
            }
        }
        if (hasRight) {
            if (candidate >= right) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RebuildAscendingArray sol = new RebuildAscendingArray();
        int[] res = sol.rebuild(new int[]{1,3,7,4,10}, new int[]{2,1,5,8,9});
        System.out.println(Arrays.toString(res));

        res = sol.rebuild(new int[]{1,3,7,9,4}, new int[]{2,1,5,8,9});
        System.out.println(Arrays.toString(res));

        res = sol.rebuild(new int[]{6,6,7,9,10}, new int[]{2,1,5,8,9});
        System.out.println(Arrays.toString(res));

        res = sol.rebuild(new int[]{6,6,7,9,10}, new int[]{-1, -2});
        System.out.println(Arrays.toString(res));
    }
}


