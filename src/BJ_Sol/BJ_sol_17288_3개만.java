package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_sol_17288_3개만 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();

        int cnt = 1;
        int ans = 0;
        char start = S.charAt(0);
        for(int i=1; i<S.length(); i++) {
            if(start+1 == S.charAt(i)) {
                cnt++;
            }
            else if(start+1 != S.charAt(i)) {
                if(cnt == 3) {
                    ans += 1;
                }
                cnt = 1;
            }
            start = S.charAt(i);
        }

        if(cnt==3) ans += 1;

        System.out.println(ans);
    }

}
