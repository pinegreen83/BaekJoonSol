package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_sol_10026_적록색약 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] visited;
    static int N, deltas[][] = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        char[][] map1 = new char[N][N];
        char[][] map2 = new char[N][N];
        for(int x=0; x<N; x++) {
            map1[x] = br.readLine().toCharArray();
            for(int y=0; y<N; y++) {
                if(map1[x][y] == 'R' | map1[x][y] == 'G') {
                    map2[x][y] = 'R';
                }
                else {
                    map2[x][y] = map1[x][y];
                }
            }
        }

        visited = new boolean[N][N];
        int yesRGB = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, map1[i][j], map1);
                    yesRGB++;
                }
            }
        }

        visited = new boolean[N][N];
        int noRGB = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, map2[i][j], map2);
                    noRGB++;
                }
            }
        }
        System.out.println(yesRGB+" "+noRGB);
    }

    static void dfs(int x, int y, char color, char[][] map) {
        visited[x][y] = true;

        for(int d=0; d<deltas.length; d++) {
            int dx = x+deltas[d][0];
            int dy = y+deltas[d][1];
            if(isValid(dx, dy) && !visited[dx][dy] && color == map[dx][dy]) {
                dfs(dx, dy, map[dx][dy], map);
            }
        }
    }

    static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

}
