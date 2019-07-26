package String;

import java.util.ArrayList;

public class StringReplace {
    /*  assumptions:
            1. input, source, target is not null
            2. source is not empty
            3. sources are not overlap in input
     */
    public String replace(String input, String source, String target) {
        // corner case
        if (input.length() < source.length()) {
            return input;
        }

        char[] array = input.toCharArray();
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        if (source.length() >= target.length()) {
            return replaceShorter(array, s, t);
        } else {
            return replaceLonger(array, s, t);
        }
    }

    // time: O(n*m), space: O(1)
    private String replaceShorter(char[] array, char[] s, char[] t) {
        int slow = 0; // processed interval: [0, slow - 1]
        int fast = 0; // processing char: [fast]
        while (fast < array.length) {
            if (equalsSource(array, s, fast)) {
                copyTarget(array, t, slow);
                fast += s.length;
                slow += t.length;
            } else {
                array[slow++] = array[fast++];
            }
        }
        return new String(array, 0, slow);
    }

    // time: O(n*m), space: O((t.length - s.length) * #matches)
    private String replaceLonger(char[] array, char[] s, char[] t) {
        // get all matches position
        ArrayList<Integer> matches = getMatchingPositions(array, s);
        // allocate larger char[]
        char[] res = new char[ array.length + (t.length - s.length) * matches.size() ];
        // do replacement using matching position similar as "replaceShorter"
        int slow = res.length - 1; // processed interval: [slow + 1, res.length - 1]
        int fast = array.length - 1; // processing position: [fast]
        int index = matches.size() - 1;
        while (fast >= 0) {
            if (index >= 0 && fast == matches.get(index)) {
                index--;
                copyTarget(res, t, slow - (t.length - s.length));
                slow -= t.length - s.length + 1;
                fast --;
            } else {
                res[slow--] = array[fast--];
            }
        }
        return new String(res);
    }

    private ArrayList<Integer> getMatchingPositions(char[] array, char[] source) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0;
        while (i <= array.length - source.length) {
            if (equalsSource(array, source, i)) {
                res.add(i);
                i += source.length;
            } else {
                i++;
            }
        }
        return res;
    }

    private boolean equalsSource(char[] array, char[] source, int index) {
        for (int i = 0; i < source.length; i++) {
            if (index + i >= array.length || array[index + i] != source[i]) {
                return false;
            }
        }
        return true;
    }

    private void copyTarget(char[] array, char[] target, int index) {
        for (int i = 0; i < target.length; i++) {
            array[index + i] = target[i];
        }
    }

    public static void main(String[] args) {
        StringReplace sol = new StringReplace();
        String res = sol.replace("applecatapp", "app", "pear");
        System.out.println(res);
    }
}
