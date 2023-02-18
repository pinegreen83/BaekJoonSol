package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_sol_21965_드높은남산위에우뚝선 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        boolean ans = true;
        boolean rise = true;
        int max = Integer.MIN_VALUE;
        int now;
        for(int i=0; i<N; i++) {
            now = Integer.parseInt(st.nextToken());
            if(rise) {
                if(max < now) {
                    max = now;
                }
                else if(max == now) {
                    ans = false;
                    break;
                }
                else if(max > now) {
                    rise = false;
                    max = now;
                }
            }
            else {
                if(max < now) {
                    ans = false;
                    break;
                } else if (max > now) {
                    max = now;
                }
            }
        }

        if(ans) System.out.println("YES");
        else System.out.println("NO");
    }

}
