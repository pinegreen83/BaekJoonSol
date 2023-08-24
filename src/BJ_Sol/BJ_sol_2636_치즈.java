package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_sol_2636_치즈 {

    static int N, M, cheeses;
    static int[] deltaX = {-1, 1, 0, 0}, deltaY = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    cheeses++;
                }
            }
        }

        int beforeMelt = 0;
        int meltTime = 0;
        while(cheeses > 0) {
            beforeMelt = cheeses;
            meltTime++;
            bfs();
        }
        System.out.println(meltTime);
        System.out.println(beforeMelt);
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[N][M];
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        int[] now = null;
        while(!queue.isEmpty()) {
            now = queue.poll();
            int x = now[0];
            int y = now[1];
            for(int i=0; i<4; i++) {
                int dx = x+deltaX[i];
                int dy = y+deltaY[i];
                if(isValid(dx, dy) && !visited[dx][dy]) {
                    if(map[dx][dy] == 1) {
                        map[dx][dy] = 0;
                        visited[dx][dy] = true;
                        cheeses--;
                    }
                    else if(map[dx][dy] == 0) {
                        queue.offer(new int[] {dx, dy});
                        visited[dx][dy] = true;
                    }
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

}
