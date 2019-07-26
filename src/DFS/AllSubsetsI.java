package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
    // time: O(2^n), space: O(n)
    public List<String> subSets(String set) {
        // corner case
        List<String> res = new ArrayList<String>();
        if (set == null) {
            return res;
        } else if (set.length() == 0) {
            res.add(set);
            return res;
        }

        DFSHelper(set, new StringBuilder(), res, 0);
        return res;
    }

    private void DFSHelper(String set, StringBuilder sb, List<String> res, int index) {
        // base case
        if (index == set.length()) {
            res.add(sb.toString());
            return;
        }

        // loop through two braches
        sb.append(set.charAt(index));
        DFSHelper(set, sb, res, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        DFSHelper(set, sb, res, index + 1);
    }

    public static void main(String[] args) {
        AllSubsetsI sol = new AllSubsetsI();
        List<String> res = sol.subSets("abc");
        System.out.println(res.toString());
    }
}
