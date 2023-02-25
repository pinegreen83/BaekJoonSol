package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_sol_6987_월드컵 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean ans;
    static int matches[][] = {
            {0, 1},
            {0, 2},
            {0, 3},
            {0, 4},
            {0, 5},
            {1, 2},
            {1, 3},
            {1, 4},
            {1, 5},
            {2, 3},
            {2, 4},
            {2, 5},
            {3, 4},
            {3, 5},
            {4, 5}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        for(int i=0; i<4; i++) {
            int[][] results = new int[6][3];
            ans = true;
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++) {
                int sum = 0;
                for(int k=0; k<3; k++) {
                    results[j][k] = Integer.parseInt(st.nextToken());
                    sum += results[j][k];
                }
                if(sum != 5) {
                    ans = false;
                    break;
                }
            }
            if(ans) {
                ans = false;
                result(0, results);
                if(ans) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void result(int cnt, int[][] results) {
        if(cnt == matches.length) {
            ans = true;
            return;
        }
        // team 1 win
        if(results[matches[cnt][0]][0] > 0 && results[matches[cnt][1]][2] > 0) {
            results[matches[cnt][0]][0]--;
            results[matches[cnt][1]][2]--;
            result(cnt+1, results);
            results[matches[cnt][0]][0]++;
            results[matches[cnt][1]][2]++;
        }
        // team 1 draw
        if(results[matches[cnt][0]][1] > 0 && results[matches[cnt][1]][1] > 0) {
            results[matches[cnt][0]][1]--;
            results[matches[cnt][1]][1]--;
            result(cnt+1, results);
            results[matches[cnt][0]][1]++;
            results[matches[cnt][1]][1]++;
        }
        // team 1 lose
        if(results[matches[cnt][0]][2] > 0 && results[matches[cnt][1]][0] > 0) {
            results[matches[cnt][0]][2]--;
            results[matches[cnt][1]][0]--;
            result(cnt+1, results);
            results[matches[cnt][0]][2]++;
            results[matches[cnt][1]][0]++;
        }
    }

}
