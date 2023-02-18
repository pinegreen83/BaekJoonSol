package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_sol_23739_벼락치기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int time = 30;
        int cnt = 0;
        int T;
        for(int n = 0; n < N; n++) {
            T = Integer.parseInt(br.readLine());
            if(T > time) {
                if(time*2 >= T) cnt++;
                time = 30;
            }
            else {
                time -= T;
                cnt++;
                if(time <= 0) time = 30;
            }
        }
        System.out.println(cnt);
    }
}
