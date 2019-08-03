package NewCoder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuickIO {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = bf.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int k = Integer.parseInt(str1[1]);

        String[] str2 = bf.readLine().split(" ");
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(str2[i]);
        }
        List<Integer> res = new ArrayList<Integer>();
    }
}
