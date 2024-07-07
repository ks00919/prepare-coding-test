import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G5] 백준 19951 태상이의 훈련소 생활
 * 
 * 메모리 : 62324KB
 * 시간 : 556B
 * 코드 길이 : 1318B
 * 
 * 누적합 IMOS
 * 
 * @see <a href="https://www.acmicpc.net/problem/19951"/>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[n + 1];
        int[] orders = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // start
            int b = Integer.parseInt(st.nextToken()) + 1; // end
            int k = Integer.parseInt(st.nextToken()); // order

            orders[a] += k;
            orders[b] += k * -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            orders[i] += orders[i - 1];
            heights[i] += orders[i];
            sb.append(heights[i]).append(" ");
        }

        System.out.println(sb);
    }

}
