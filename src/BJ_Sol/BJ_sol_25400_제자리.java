package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_25400_제자리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] Ns, Ns2;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int num;
        int start = 0;
        for(int n=0; n<N; n++) {
            num = Integer.parseInt(st.nextToken());
            if(num == start+1) start++;
        }
        System.out.println(N-start);
    }

}
