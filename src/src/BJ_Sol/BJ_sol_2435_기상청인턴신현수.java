package src.BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_2435_기상청인턴신현수 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] Ns;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Ns = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            Ns[n] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N-K+1; i++) {
            int sum = 0;
            for(int j=i; j<i+K; j++) {
                sum += Ns[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}
