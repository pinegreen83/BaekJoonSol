package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_25166_배고픈아리의샌드위치구매하기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int S, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] friCoins = new int[10];
        for(int i=0; i<10; i++) {
            if((M & 1<<i) > 0) {
                friCoins[i]++;
            }
        }

        int ans = 0;
        if(S < 1024) {
            for(int i=0; i<10; i++) {
                if((S & 1<<i) > 0) {
                    S -= 1<<i;
                    if(S == 0) {
                        ans = 1;
                        break;
                    }
                    else if (S < 0) {
                        S += 1<<i;
                        break;
                    }
                }
            }
        }
        else {
            for(int i=0; i<10; i++) {
                S -= 1<<i;
                if(S == 0) {
                    ans = 1;
                    break;
                }
                else if (S < 0) {
                    S += 1<<i;
                    break;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (S < 0) break;
            if (friCoins[i] == 1) {
                S -= 1 << i;
                if (S == 0) {
                    ans = 2;
                    break;
                }
            }
        }

        switch (ans) {
            case 0:
                System.out.println("Impossible");
                break;
            case 1:
                System.out.println("No thanks");
                break;
            case 2:
                System.out.println("Thanks");
                break;
        }
    }

}
