package BJ_Sol;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BJ_sol_17281_야구 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, game[][], max;
	static Queue<Integer> queue;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		game = new int[N][9];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;
		perm(0, new boolean[9], new int[9]);

		System.out.println(max);
	}

	static void perm(int cnt, boolean[] visited, int[] group) {
		if(cnt == 3) {
			group[cnt] = 0;
			perm(cnt+1, visited, group);
		}
		if(cnt == 9) {
			int ans = play(group);
			max = Math.max(max, ans);
			return;
		}
		for(int i=1; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				group[cnt] = i;
				perm(cnt+1, visited, group);
				visited[i] = false;
			}
		}
	}
	
	static int play(int[] group) {
		int nowCurrent = 0;
		int scoreNow = 0;
		for(int i=0; i<N; i++) {
			int out = 0;
			queue = new ArrayDeque<>();
			while (out < 3) {
				switch (game[i][group[nowCurrent % 9]]) {
					case 0:
						out++;
						break;
					case 1:
						queue.offer(group[nowCurrent % 9] + 1);
						while (queue.size() > 3) {
							int a = queue.poll();
							if (a != 0) scoreNow++;
						}
						break;
					case 2:
						queue.offer(group[nowCurrent % 9] + 1);
						queue.offer(0);
						while (queue.size() > 3) {
							int a = queue.poll();
							if (a != 0) scoreNow++;
						}
						break;
					case 3:
						queue.offer(group[nowCurrent % 9] + 1);
						queue.offer(0);
						queue.offer(0);
						while (queue.size() > 3) {
							int a = queue.poll();
							if (a != 0) scoreNow++;
						}
						break;
					case 4:
						while (queue.size() > 0) {
							int a = queue.poll();
							if (a != 0) scoreNow++;
						}
						scoreNow++;
						break;
				}
				nowCurrent++;
			}
		}
		return scoreNow;
	}
	
}
