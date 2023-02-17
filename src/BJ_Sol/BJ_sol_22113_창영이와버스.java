package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_22113_창영이와버스 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] Ms;
    static int[][] Ns;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Ns = new int[N][N];
        Ms = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int m = 0; m<M; m++) {
            Ms[m] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<Ns.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<Ns[i].length; j++) {
                Ns[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        for(int a=0; a<M-1; a++) {
            sum+= Ns[Ms[a]-1][Ms[a+1]-1];
        }

        System.out.println(sum);
    }

}
