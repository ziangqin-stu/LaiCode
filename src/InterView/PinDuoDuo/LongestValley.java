package InterView.PinDuoDuo;

public class LongestValley {
    // assume: the input array is not null
    public int longestValley(int[] array) {
        // base case
        if (array.length < 3) {
            return 0;
        }

        boolean hasDown = false;
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                if (array[i - 1] < array[i] && hasDown) {
                    curLen++;
                    maxLen = Math.max(maxLen, curLen);
                }
                break;
            }
            if (array[i + 1] > array[i]) { // going up
                curLen++;
            } else { // going down
                curLen++;
                if (hasDown && array[i] > array[i - 1]) { // MaxPoints
                    if (hasDown) {
                        maxLen = Math.max(maxLen, curLen);
                    }
                    curLen = 0;
                }
                hasDown = true;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestValley sol = new LongestValley();

        int res = sol.longestValley(new int[]{1,2,3,3,1,5});
        System.out.println(res);

        res = sol.longestValley(new int[]{3,2,1,0,1,2,3,2,1,2,3,4,1,2});
        System.out.println(res);

        res = sol.longestValley(new int[]{1,2,3,2,1});
        System.out.println(res);

        res = sol.longestValley(new int[]{});
        System.out.println(res);

        res = sol.longestValley(new int[]{1,2});
        System.out.println(res);

        res = sol.longestValley(new int[]{1,2,1});
        System.out.println(res);

        res = sol.longestValley(new int[]{1,0,1});
        System.out.println(res);
    }
}
