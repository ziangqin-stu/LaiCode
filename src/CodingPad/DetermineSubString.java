package CodingPad;

public class DetermineSubString {
    public boolean isSubString(String s1, String s2) {
        // corner case
        if (s1 == null || s2 == null) {
            return false;
        }
        // assume: s2.length() <= s1.length()
        for (int i = 0; i <= s1.length() - s2.length(); i++) { // i: string offset
            // check each interval start position
            for (int j = 0; j < s2.length(); j++) { // j: pattern offset
                // scan each interval
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
                if (j == s2.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static  void main(String[] args) {
        DetermineSubString sol = new DetermineSubString();
        boolean res = sol.isSubString("I am a student.", "student");
        System.out.println(res);
    }
}
