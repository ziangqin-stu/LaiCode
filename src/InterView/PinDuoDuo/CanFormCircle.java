package InterView.PinDuoDuo;

import java.util.Arrays;

public class CanFormCircle {
    public boolean canFormCircle(String[] strings) {
        // DFS
        boolean res = DFSHelper(strings, 0);
        return res;
    }

    private boolean DFSHelper(String[] strings, int index) {
        // base case
        if (index == strings.length - 1) {
            return strings[0].charAt(0) == strings[strings.length - 1].charAt(strings[strings.length - 1].length() - 1);
        }

        // loop through and check each branches
        boolean curRes = false;
        for (int i = index + 1;i < strings.length; i++) {
            if (canConenct(strings[index], strings[i])) {
                swap(strings, index + 1, i);
                curRes = DFSHelper(strings, index + 1);
                swap(strings, index + 1, i);
            }
        }
        return curRes;
    }

    private void swap(String[] strings, int x, int y) {
        String temp = strings[x];
        strings[x] = strings[y];
        strings[y] = temp;
    }

    private boolean canConenct(String first, String second) {
        return first.charAt(first.length() - 1) == second.charAt(0);
    }

    public static void main(String[] args) {
        CanFormCircle sol = new CanFormCircle();
        boolean res = sol.canFormCircle(new String[]{"CAT", "RPC", "TIGER"});
        System.out.println(res);

        res = sol.canFormCircle(new String[]{"CAT", "RPC"});
        System.out.println(res);

        res = sol.canFormCircle(new String[]{"bc", "ab", "cd", "da", "rr"});
        System.out.println(res);
    }
}
