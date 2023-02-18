package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_sol_15920_선로에마네킹이야 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String S = br.readLine();

        boolean lever = true;
        int time = 0;
        int ans = 0;
        int leveron = 0;

        for(int n=0; n<N; n++) {
            if(time == 1) {
                if(S.charAt(n) == 'P') {
                    if(lever) lever = false;
                    else lever = true;
                    leveron += 1;
                }
                else {
                    if(leveron > 0) {
                        ans += 6;
                    }
                    else {
                        if(lever) ans += 5;
                        else ans += 1;
                    }
                    break;
                }
            }
            else {
                if(S.charAt(n) == 'P') {
                    if(lever) lever = false;
                    else lever = true;
                }
                else {
                    time++;
                }
            }
        }

        System.out.println(ans);
    }

}
