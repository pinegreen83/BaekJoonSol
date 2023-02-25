package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_2343_기타레슨 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, left, right, max, lec[];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lec = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            lec[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lec[i]);
            right += lec[i];
        }
        max = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left+right) / 2;

            if(findSmall(mid) < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    static int findSmall(int mid) {
        int cnt = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
            if(sum+lec[i] > mid) {
                sum = 0;
                cnt++;
            }
            sum+=lec[i];
        }
        if(sum!=0) cnt++;
        return cnt;
    }

}
