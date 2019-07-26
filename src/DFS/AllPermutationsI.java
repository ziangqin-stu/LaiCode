package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI {
    // time: O(n!), sapce: O(n)
    // assume set is  not null
    public List<String> permutations(String set) {
        // base case:
        List<String> res = new ArrayList<String>();
        if (set.length() == 0) {
            res.add(set);
            return res;
        }

        char[] array = set.toCharArray();
        DFSHelper(array, 0, res);
        return res;
    }

    private void DFSHelper(char[] array, int index, List<String> res) {
        // base case
        if (index == array.length) {
            res.add(new String(array));
            return;
        }

        // try allocate each valid char
        for (int tar = index; tar < array.length; tar++) { // candidate set interval: [index, n-1];
            // index: the position to be determined
            // tar: the allocating char position
            swap(array, index, tar);
            DFSHelper(array, index + 1, res);
            swap(array, index, tar);
        }
    }

    private void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        AllPermutationsI sol = new AllPermutationsI();
        List<String> res = sol.permutations("abcde");
        System.out.println(res.toString());
    }
}
