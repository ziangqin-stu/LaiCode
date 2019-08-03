package NewCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int k = Integer.parseInt(str1[1]);
        String[] str2 = bf.readLine().split(" ");
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(str2[i]);
        }

        class Move {
            int from;
            int to;
            public Move(int from, int to) {
                this.from = from;
                this.to = to;
            }
        }
        List<Move> moves = new ArrayList<Move>();

        int[] curMove = Tower.maxMin(array);
        int maxInd = curMove[0];
        int minInd = curMove[1];
        int maxDiff = curMove[2];
        int opNumber = 0;
        while (maxDiff > 1 && opNumber < k) {
            curMove = maxMin(array);
            maxInd = curMove[0];
            minInd = curMove[1];
            maxDiff = curMove[2];
            moves.add(new Move(maxInd + 1, minInd + 1));

            array[maxInd]--;
            array[minInd]++;
            opNumber++;
        }

        curMove = maxMin(array);
        maxDiff = curMove[2];
        System.out.println((maxDiff + "") + " " + (opNumber + ""));
        for (Move move : moves) {
            System.out.println((move.from + "") + " " + (move.to + ""));
        }
    }

    private static int[] maxMin(int[] array) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int maxInd = 0;
        int minInd = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxVal < array[i]) {
                maxVal = array[i];
                maxInd = i;
            }
            if(minVal > array[i]) {
                minVal = array[i];
                minInd = i;
            }
        }
        return new int[]{maxInd, minInd, maxVal - minVal};
    }
}
