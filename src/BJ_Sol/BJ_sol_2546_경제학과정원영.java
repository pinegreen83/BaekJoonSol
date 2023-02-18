package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_sol_2546_경제학과정원영 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] cStu = new int[N];
            int[] eStu = new int[M];

            st = new StringTokenizer(br.readLine());
            int csum = 0;
            for(int c=0; c<N; c++) {
                cStu[c] = Integer.parseInt(st.nextToken());
                csum += cStu[c];
            }
            float cavg = (float) csum / N;

            st = new StringTokenizer(br.readLine());
            int esum = 0;
            for(int m=0; m<M; m++) {
                eStu[m] = Integer.parseInt(st.nextToken());
                esum += eStu[m];
            }
            float eavg = (float) esum / M;

            Arrays.sort(cStu);
            Arrays.sort(eStu);

            int ans = 0;
            for(int i=0; i<N; i++) {
                if(cStu[i] > eavg && cStu[i] < cavg) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }

}
