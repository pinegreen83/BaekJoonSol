package BJ_Sol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_sol_12891_DNA비밀번호 {
	
	static int S, P, sum;
	static int[] minLen, type;
	static char[] dnaString;
	static Queue<Character> pass = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		dnaString = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		minLen = new int[26]; // 'A', 'C', 'G', T'
		minLen[0] = Integer.parseInt(st.nextToken());
		minLen[2] = Integer.parseInt(st.nextToken());
		minLen[6] = Integer.parseInt(st.nextToken());
		minLen[19] = Integer.parseInt(st.nextToken());

		sum = 0;
		type = new int[26];
		passWord();
		System.out.println(sum);
		
	}
	
	static void passWord() {
		for(int i=0; i<P; i++) {
			pass.offer(dnaString[i]);
			type[dnaString[i]-'A']++;
		}
		compare();
		for(int s=P; s<S; s++) {
			type[pass.poll()-'A']--;
			pass.offer(dnaString[s]);
			type[dnaString[s]-'A']++;
			compare();
		}
	}

	static void compare() {
		int cnt = 0;
		if(type[0] >= minLen[0]) cnt++;
		if(type[2] >= minLen[2]) cnt++;
		if(type[6] >= minLen[6]) cnt++;
		if(type[19] >= minLen[19]) cnt++;
		if(cnt == 4) sum++;
	}

}
