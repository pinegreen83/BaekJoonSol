package src.BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_20113_긴급회의 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] Ns;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Ns = new int[N];

        int max = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num!=0) {
                Ns[num-1]++;
                max = Math.max(max, Ns[num-1]);
            }
        }

        int cnt = 0;
        int maxnum = 0;
        for(int i=0; i<Ns.length; i++) {
            if(cnt==2) break;
            if(Ns[i]==max) {
                maxnum = i + 1;
                cnt++;
            }
        }

        if(cnt!=1) System.out.println("skipped");
        else System.out.println(maxnum);
    }

}
