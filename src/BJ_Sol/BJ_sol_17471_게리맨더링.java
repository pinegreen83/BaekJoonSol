package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_sol_17471_게리맨더링 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, min, map[];
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        list.add(new ArrayList<>());
        for(int i=1; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int nums = Integer.parseInt(st.nextToken());
            for(int r=0; r<nums; r++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        min = Integer.MAX_VALUE;
        set(1, new boolean[N+1]);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }
    }

    static void set(int cnt, boolean[] visited) {
        if(cnt == N) {
            ArrayList<Integer> one = new ArrayList<>();
            ArrayList<Integer> two = new ArrayList<>();
            for(int i=1; i<=cnt; i++) {
                if(visited[i]) {
                    one.add(i);
                }
                else{
                    two.add(i);
                }
            }

            if(bfs(one, new boolean[N+1]) & bfs(two, new boolean[N+1])) {
                int ones = 0;
                int twos = 0;
                for(int i=0; i<one.size(); i++) {
                    ones += map[one.get(i)];
                }
                for(int i=0; i<two.size(); i++) {
                    twos += map[two.get(i)];
                }
                min = Math.min(Math.abs(ones-twos), min);
            }
            return;
        }

        visited[cnt] = true;
        set(cnt+1, visited);
        visited[cnt] = false;
        set(cnt+1, visited);
    }

    static boolean bfs(ArrayList<Integer> area, boolean[] visit) {
        int v = 1;
        if(area.size() == 0) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(area.get(0));
        visit[area.get(0)] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int a : list.get(current)) {
                if(area.contains(a) && !visit[a]) {
                    queue.offer(a);
                    v++;
                    visit[a] = true;
                }
            }
        }

        if(v == area.size()) {
            return true;
        }
        else {
            return false;
        }
    }
}
