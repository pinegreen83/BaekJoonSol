package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_1233_주사위 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int S1, S2, S3;
    static int[] sums;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        S1 = Integer.parseInt(st.nextToken());
        S2 = Integer.parseInt(st.nextToken());
        S3 = Integer.parseInt(st.nextToken());

        sums = new int[S1+S2+S3+3];

        for(int s1 = 1; s1<=S1; s1++) {
            for(int s2 = 1; s2<=S2; s2++) {
                for(int s3 = 1; s3<=S3; s3++) {
                    sums[s1+s2+s3]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int maxnum = 0;

        for(int s=0; s<sums.length; s++) {
            if(max < sums[s]) {
                max = sums[s];
                maxnum = s;
            }
        }

        System.out.println(maxnum);

    }
}
