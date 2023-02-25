package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_2072_오목 {
    static final int WHITE = 20;
    static final int BLACK = 21;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, lines[], map[][], deltas[][][] = {{{-1, 0}, {1, 0}}, {{0, -1}, {0, 1}}, {{-1, 1}, {1, -1}}, {{-1, -1}, {1, 1}}};
    static boolean win;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[20][20];
        win = false;
        for(int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (n % 2 == 0) {
                map[x][y] = WHITE;
            } else {
                map[x][y] = BLACK;
            }
            lines = new int[4];
            findLine(map[x][y], x, y);
            for(int i=0; i<lines.length; i++) {
                if(lines[i] == 4) win = true;
            }
            if(win) {
                System.out.println(n);
                break;
            }
        }
        if(!win) System.out.println(-1);
    }

    static void findLine(int turn, int x, int y) {
        for(int i=0; i<4; i++) {
            for(int j=0; j<2; j++) {
                if(isValid(x+deltas[i][j][0], y+deltas[i][j][1])){
                    lengthLine(turn, x+deltas[i][j][0], y+deltas[i][j][1], i, j);
                }
            }
        }
    }

    static void lengthLine(int turn, int x, int y, int dirx, int diry) {
        if(map[x][y] == turn) {
            lines[dirx]++;
            if(isValid(x+deltas[dirx][diry][0], y+deltas[dirx][diry][1])) {
                lengthLine(turn, x+deltas[dirx][diry][0], y+deltas[dirx][diry][1], dirx, diry);
            }
        }
    }

    static boolean isValid(int x, int y) {
        if(0 < x && x < 20 && 0 < y && y < 20) return true;
        return false;
    }

}
