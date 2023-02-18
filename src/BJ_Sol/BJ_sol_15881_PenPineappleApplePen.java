package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_sol_15881_PenPineappleApplePen {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String Ns = br.readLine();
        char[] list = {'p', 'P', 'A', 'p'};

        int cnt = 0, ans = 0;
        for(int n = 0; n < N; n++) {
            if(Ns.charAt(n) != list[cnt++]) {
                if(Ns.charAt(n) == 'p') {
                    cnt = 1;
                }
                else cnt = 0;
            }
            else {
                if(cnt == 4) {
                    ans++;
                    cnt = 0;
                }
            }
        }

        System.out.println(ans);
    }

}
