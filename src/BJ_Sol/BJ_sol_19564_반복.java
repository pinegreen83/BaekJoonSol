package src.BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_sol_19564_반복 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] s = br.readLine().toCharArray();

        int cnt = 1;
        char now = s[0];
        for(int i=1; i<s.length; i++) {
            if(now >= s[i]) cnt++;
            now = s[i];
        }

        System.out.println(cnt);
    }

}
