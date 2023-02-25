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
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            long[] cStu = new long[N];
            long[] eStu = new long[M];

            long csum = 0;
            long esum = 0;

            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                cStu[c] = Integer.parseInt(st.nextToken());
                csum += cStu[c];
            }

            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                eStu[m] = Integer.parseInt(st.nextToken());
                esum += eStu[m];
            }

            int ans = 0;
            for(int i=0; i<N; i++) {
                if(csum > cStu[i]*N  && esum < cStu[i]*M) {
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}
