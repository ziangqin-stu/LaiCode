package DFS;

import java.util.List;
import java.util.ArrayList;

public class AllValidPermutationsOfParenthesesII {
    // time: O(2^(2n)), space: O(n)
    // assume: n > 0
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<String>();
        DFSHelper(n, n, 0, res, new StringBuilder());
        return res;
    }

    private void DFSHelper(int n, int leftRemain, int rightRemain, List<String> res, StringBuilder sb) {
        // base case
        if (leftRemain == 0 && rightRemain == 0) {
            res.add(sb.toString());
            return;
        }

        // loop over every valid allocation
        if (leftRemain > 0) { // add left parenthes
            sb.append('(');
            DFSHelper(n, leftRemain - 1, rightRemain + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightRemain > 0) { // add right parenthes
            sb.append(')');
            DFSHelper(n, leftRemain, rightRemain - 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        AllValidPermutationsOfParenthesesII sol = new AllValidPermutationsOfParenthesesII();
        List<String> res = sol.validParentheses(3);
        System.out.println(res.toString());
    }
}
