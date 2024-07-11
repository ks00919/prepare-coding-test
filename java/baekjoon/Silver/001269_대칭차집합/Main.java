import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [S4] 백준 1269 대칭 차집합
 * 메모리 : 100324kb
 * 시간 : 556ms
 * 코드 길이 : 1087B
 *
 * @see <a href="https://www.acmicpc.net/problem/1269">문제</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            set.add(Integer.parseInt(tokens.nextToken()));
        }

        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int number = Integer.parseInt(tokens.nextToken());

            if (set.contains(number)) {
                set.remove(number);
            } else {
                set.add(number);
            }
        }

        System.out.println(set.size());
    }
}
