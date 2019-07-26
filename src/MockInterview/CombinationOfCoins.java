package MockInterview;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfCoins {
    // time: O(target/d[i]), space: O(n)
    /* assume:
        1. coins is not null nor empty
        2. target >= 0
        3. infinite number of coins for each denomination
     */
    public List<List<Integer>> combinations(int target, int[] coins) {
        // corner case
        if (target == 0) {
            return new ArrayList<List<Integer>>();
        }

        // DFS
        List<Integer> curRes = new ArrayList<Integer>();
        for(int i = 0; i < coins.length; i++) {
            curRes.add(0);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        DFSHelper(target, coins, res, curRes,0);
        return res;
    }

    private void DFSHelper(int target, int[] coins, List<List<Integer>> res, List<Integer> curRes, int index) {
        // base case
        if (target == 0) {
            res.add(new ArrayList<Integer>(curRes));
            return;
        } else if (target < 0) {
            return;
        }else if (index == coins.length - 1) {
            if ((target % coins[index]) == 0) {
                curRes.set(index, (target / coins[index]));
                res.add(new ArrayList<Integer>(curRes));
                curRes.set(index, 0);
            }
            return;
        }

        // loop through each branches
        int curDenom = coins[index];
        int maxAllocation = (int) (target / curDenom);
        for (int i = 0; i <= maxAllocation; i++) {
            curRes.set(index, i);
            DFSHelper(target - i * curDenom, coins, res, curRes, index + 1);
            curRes.set(index, 0);
        }
    }

    public static void main(String[] args) {
        CombinationOfCoins sol = new CombinationOfCoins();
        List<List<Integer>> res = sol.combinations(356, new int[]{453,402,237,233,119,76,12});
        System.out.println(res);
    }
}
