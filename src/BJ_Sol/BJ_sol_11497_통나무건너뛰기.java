package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_sol_11497_통나무건너뛰기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static int[] Ns;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            Ns = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++) {
                Ns[n] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(Ns);

            int[] Ns2= new int[N];
            int cnt = 0;
            int start = 0;
            int end = N-1;
            for(int i=0; i<N; i++) {
                if(cnt%2==0) {
                    Ns2[start++] = Ns[i];
                }
                else {
                    Ns2[end--] = Ns[i];
                }
                cnt++;
            }

            int summax = 0;
            for(int i=0; i<N; i++) {
                summax = Math.max(Math.abs(Ns2[i]-Ns2[(i+1)%N]), summax);
            }

            System.out.println(summax);
        }

    }

}
