package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_sol_1992_쿼드트리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cnt, NN[], Ns[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Ns = new int[N][N];
        NN = new int[N*N];
        for(int i = 0; i < N; i++) {
            String nLine = br.readLine();
            for(int j = 0; j < N; j++) {
                Ns[i][j] = nLine.charAt(j)-'0';
            }
        }

        cnt = 0;
            findTree(0, 0, N);
            System.out.println(sb);
    }

    static void findTree(int i, int j, int n) {
        int data = Ns[i][j];

        boolean canCompress = true;
        for(int x=i; x<i+n; x++) {
            if(canCompress) {
                for(int y=j; y<j+n; y++) {
                    if(data != Ns[x][y]) {
                        canCompress = false;
                        break;
                    }
                }
            }
            else break;
        }
        if(canCompress) sb.append(data);

        int size = n/2;

        if(!canCompress) {
            sb.append("(");
            if(size > 0) {
                findTree(i, j, size);
                findTree(i, j+size, size);
                findTree(i+size, j, size);
                findTree(i+size, j+size, size);
            }
            sb.append(")");
        }
    }

}

