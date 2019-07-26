package DFS;

import java.util.List;
import java.util.ArrayList;

public class CombinationsOfCoins {
    // time: O(target^n), space:O(n)
    public List<List<Integer>> combinations(int target, int[] coins) {
        // corner case
        if (target == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curRes = new ArrayList<Integer>();
        DFSHelper(target, coins, res, curRes, 0);
        return res;
    }

    private void DFSHelper(int target, int[] coins, List<List<Integer>> res, List<Integer> curRes, int index) {
        // base case
        if (index == coins.length - 1) {
            if (target % coins[index] == 0) {
                curRes.add(target / coins[index]);
                res.add(new ArrayList<Integer>(curRes));
                curRes.remove(curRes.size() - 1);
            }
            return;
        }

        // loop through all possible allocate numbers
        int curDenom = coins[index];
        int maxAlloc = (int)(target / curDenom);
        for (int i = 0; i <= maxAlloc; i++) {
            curRes.add(i);
            DFSHelper(target - curDenom * i, coins, res, curRes, index + 1);
            curRes.remove(curRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationsOfCoins sol = new CombinationsOfCoins();
        List<List<Integer>> res = sol.combinations(100, new int[]{50,20,10,5,2,1});
        System.out.println(res.toString());
    }
}
