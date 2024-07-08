import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [S4] 백준 1764 듣보잡
 * 
 * 메모리 : 25780KB
 * 시간 : 252ms
 * 코드 길이 : 1223B
 * 
 * @see <a href="https://www.acmicpc.net/problem/1764"/>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String input = br.readLine().trim();
            if (set.contains(input))
                answer.add(input);
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (String name : answer) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}