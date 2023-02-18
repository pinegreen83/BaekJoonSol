package BJ_Sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_sol_2930_가위바위보 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int R = Integer.parseInt(br.readLine());
        String sang = br.readLine();
        int N = Integer.parseInt(br.readLine());

        char[][] friends = new char[N][R];

        int sScore = 0;
        for(int n=0; n<N; n++) {
            String firRSP = br.readLine();
            for(int r = 0; r<R; r++) {
                if(firRSP.charAt(r) == 'R') {
                    friends[n][r] = firRSP.charAt(r);
                    sScore += sScoreCnt(sang.charAt(r), firRSP.charAt(r));
                } else if(firRSP.charAt(r) == 'S') {
                    friends[n][r] = firRSP.charAt(r);
                    sScore += sScoreCnt(sang.charAt(r), firRSP.charAt(r));
                } else if(firRSP.charAt(r) == 'P') {
                    friends[n][r] = firRSP.charAt(r);
                    sScore += sScoreCnt(sang.charAt(r), firRSP.charAt(r));
                }
            }
        }

        int bestScore = 0;
        for(int r=0; r<R; r++) {
            int [] score = new int[3];
            for(int n=0; n<N; n++) {
                switch (friends[n][r]) {
                    case 'R':
                        score[2] += 2;
                        score[0] += 1;
                        break;
                    case 'S':
                        score[0] += 2;
                        score[1] += 1;
                        break;
                    case 'P':
                        score[1] += 2;
                        score[2] += 1;
                        break;
                }
            }
            int maxScore = Math.max(score[0], score[1]);
            bestScore += Math.max(maxScore, score[2]);
        }

        System.out.println(sScore);
        System.out.println(bestScore);
    }

    static int sScoreCnt(char sang, char friend) {
        switch (sang) {
            case 'R':
                if(friend == 'R') return 1;
                else if(friend == 'S') return 2;
                break;
            case 'S':
                if(friend == 'S') return 1;
                else if(friend == 'P') return 2;
                break;
            case 'P':
                if(friend == 'P') return 1;
                else if(friend == 'R') return 2;
                break;
        }
        return 0;
    }

}
