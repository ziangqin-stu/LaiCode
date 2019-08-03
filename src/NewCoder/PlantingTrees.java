package NewCoder;

import java.io.*;
import java.util.*;

public class PlantingTrees {
    public static void main(String[] args) throws Exception {
        // I/O
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        String[] str2 = bf.readLine().split(" ");
        int[] numbers = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(str2[i]);
        }

        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Integer> remainder = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            remainder.put(i, numbers[i]);
        }
        Set<Integer> keys = remainder.keySet();
        int prevKey = -1;
        boolean findNext = false;
        while (findNext) {
            findNext = false;
            for (int i = 0; i < keys.size(); i++) {
                if (i != prevKey && remainder.get(i) > 0) {
                    findNext = true;
                    prevKey = i;
                    remainder.put(i, remainder.get(i) - 1);
                    res.add(i);
                }
            }
        }
        for (int i = 0; i < keys.size(); i++) {
            if (remainder.get(i) > 0) {
                System.out.println("-");
                return;
            }
        }
        System.out.println(res.toString());
    }
}
