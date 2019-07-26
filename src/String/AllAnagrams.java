package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ssu
public class AllAnagrams {
    // assume: 1. both sh and lo is not noll; 2. sh is not empty
    // time: O(n) space: 0(lo.length())
    public List<Integer> allAnagrams(String sh, String lo) {
        // corner case
        if (sh.length() > lo.length()) {
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<Integer>();
        int begin = 0;
        int end  = sh.length() - 1;
        Map<Character, Integer> counter = buildCounter(lo, sh.length()); // stores character info of current window
        Map<Character, Integer> target = buildCounter(sh, sh.length());
        int[] matches = new int[1];
        matches[0] = matchNumber(counter, target);
        while (end < lo.length()) {
            // check anagrams
            if (matches[0] == target.size()) {
                res.add(begin);
            }
            // update window info & move window forward
            if (end + 1 < lo.length()) {
                update(counter, target, matches, lo.charAt(begin), lo.charAt(end + 1));
            }
            begin++;
            end++;
        }

        return res;
    }

    private Map<Character, Integer> buildCounter(String lo, int size) {
        // TODO: build initial window info of interval [0, size - 1]
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < size; i++) {
            char curChar = lo.charAt(i);
            Integer charNum = map.get(curChar);
            if (charNum != null) {
                map.put(curChar, charNum + 1);
            } else {
                map.put(curChar, 1);
            }
        }
        return map;
    }

    private int matchNumber(Map<Character, Integer> counter, Map<Character, Integer> target) {
        // TODO: calculate initial mach number
        int matches = 0;
        for (char c : target.keySet()) {
            if (counter.get(c) == target.get(c)) {
                matches++;
            }
        }
        return matches;
    }

    private void update(Map<Character, Integer> counter, Map<Character, Integer> target, int[] matches, char head, char tail){
        // TODO: update window info and match number
        if (counter.containsKey(head)) {
            if (counter.get(head) == target.get(head)) {
                matches[0]--;
            }
            counter.put(head,counter.get(head) - 1);
            if (counter.get(head) == target.get(head)) {
                matches[0]++;
            }
        }
        if (counter.containsKey(tail)) {
            if (counter.get(tail) == target.get(tail)) {
                matches[0]--;
            }
            counter.put(tail,counter.get(tail) + 1);
            if (counter.get(tail) == target.get(tail)) {
                matches[0]++;
            }
        }
    }

    public static void main(String[] args) {
        AllAnagrams sol = new AllAnagrams();
        List<Integer> res = sol.allAnagrams("ab", "abvbav");
        System.out.println(res.toString());
    }
}
