package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_sol_1697_숨바꼭질 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans, N, K, loc[];
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        loc = new int[100001];
        ans = 0;
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        queue.offer(N);
        int current = 0;
        while(!queue.isEmpty()) {
            current = queue.poll();
            if(current == K) {
                ans = loc[current];
                break;
            }
            if(isValid(current-1) && loc[current-1] == 0) {
                queue.offer(current-1);
                loc[current-1] = loc[current]+1;
            }
            if(isValid(current+1) && loc[current+1]==0) {
                queue.offer(current+1);
                loc[current+1] = loc[current]+1;
            }
            if(isValid(current*2) && loc[current*2]==0) {
                queue.offer(current*2);
                loc[current*2] = loc[current]+1;
            }
        }
    }

    static boolean isValid(int current) {
        if(0 <= current && current <= 100000) return true;
        return false;
    }

}
