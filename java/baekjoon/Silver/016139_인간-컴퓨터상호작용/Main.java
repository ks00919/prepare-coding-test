import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S1] 백준 16139 인간-컴퓨터 상호작용
 * 메모리 : 102656KB
 * 시간 : 564ms
 * 코드 길이 : 1474B
 * <p>
 * 누적합
 * 최대 20_0000 길이의 문자열이기 때문에 누적합으로 풀이
 * 20_0000개의 문제가 나올 수 있기 때문에 배열에 저장하여 재사용
 *
 * @see <a href="https://www.acmicpc.net/problem/16139"></a>
 */
public class Main {

    private static String s;
    private static boolean[] isCounted = new boolean[26];
    private static int[][] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        counts = new int[26][s.length()];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int index = a - 'a';

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (!isCounted[index]) {
                isCounted[index] = true;
                init(a);
            }

            sb.append(counts[index][end] - (start == 0 ? 0 : counts[index][start - 1])).append("\n");
        }

        System.out.println(sb);
    }

    private static void init(char a) {
        int index = a - 'a';
        int length = s.length();

        counts[index][0] = s.charAt(0) == a ? 1 : 0;
        for (int i = 1; i < length; i++) {
            counts[index][i] = s.charAt(i) == a ? counts[index][i - 1] + 1 : counts[index][i - 1];
        }
    }
}
