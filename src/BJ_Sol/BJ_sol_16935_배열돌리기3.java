package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_sol_16935_배열돌리기3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, R, map[][], deltas[][];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        deltas = new int[][] {{N/2, 0}, {N/2, M/2}, {0, M/2}, {0, 0}};
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int r=0; r<R; r++) {
            int rot = Integer.parseInt(st.nextToken());
            switch (rot) {
                case 1:
                    change1();
                    break;
                case 2:
                    change2();
                    break;
                case 3:
                    change3();
                    break;
                case 4:
                    change4();
                    break;
                case 5:
                    change5();
                    break;
                case 6:
                    change6();
                    break;
            }
        }

        for(int[] m : map) {
            for(int i : m) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void change1() {
        int[][] map2 = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map2[N-i-1][j] = map[i][j];
            }
        }
        map = map2;
    }

    static void change2() {
        int[][] map2 = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map2[i][M-j-1] = map[i][j];
            }
        }
        map = map2;
    }

    static void change3() {
        int[][] map2 = new int[M][N];
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                map2[i][N-j-1] = map[j][i];
            }
        }
        changeRot();
        map = map2;
    }

    static void change4() {
        int[][] map2 = new int[M][N];
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                map2[M-i-1][j] = map[j][i];
            }
        }
        changeRot();
        map = map2;
    }

    static void change5() {
        int[][] map1 = makeMap();
        int[][] map2 = new int[N][M];
        for(int d=0; d<deltas.length; d++) {
            for(int x=0; x<N/2; x++) {
                for(int y=0; y<M/2; y++) {
                    map2[x+deltas[(d+3)%4][0]][y+deltas[(d+3)%4][1]] = map1[x+deltas[d][0]][y+deltas[d][1]];
                }
            }
        }
        map = map2;
    }

    static void change6() {
        int[][] map1 = makeMap();
        int[][] map2 = new int[N][M];
        for(int d=0; d<deltas.length; d++) {
            for(int x=0; x<N/2; x++) {
                for(int y=0; y<M/2; y++) {
                    map2[x+deltas[d][0]][y+deltas[d][1]] = map1[x+deltas[(d+3)%4][0]][y+deltas[(d+3)%4][1]];
                }
            }
        }
        map = map2;
    }

    static int[][] makeMap() {
        int[][] temp = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    static void changeRot() {
        int temp = N;
        N = M;
        M = temp;
        deltas = new int[][] {{N/2, 0}, {N/2, M/2}, {0, M/2}, {0, 0}};
    }
}
