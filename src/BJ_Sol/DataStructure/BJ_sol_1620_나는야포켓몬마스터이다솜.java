package BJ_Sol.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_sol_1620_나는야포켓몬마스터이다솜 {

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int pocket_mon = Integer.parseInt(st.nextToken());
        int questions = Integer.parseInt(st.nextToken());

        Map<String, String> PocketMons = new HashMap<>();
        Map<String, String> PocketmonDict = new HashMap<>();

        for (int i=0; i<pocket_mon; i++) {
            String now = br.readLine();

            PocketMons.put(Integer.toString(i+1), now);
            PocketmonDict.put(now, Integer.toString(i+1));
        }

        for (int i=0; i<questions; i++) {
            String question = br.readLine();
            if(PocketMons.get(question) != null) {
                sb.append(PocketMons.get(question)).append("\n");
            }
            else {
                sb.append(PocketmonDict.get(question)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}
