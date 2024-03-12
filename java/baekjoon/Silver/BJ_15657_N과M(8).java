import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S3] 백준 15657 N과 M(8)
 * 메모리 : 15657KB
 * 시간 : 108ms
 * 코드길이 : 1196B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15657">
 */
public class Main {

    static int N, M;
    static int[] numbers;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        numbers = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = parseInt(st.nextToken());
        }

        // 오름차순으로 선택하기 위해서 미리 정렬
        Arrays.sort(numbers);
        dfs(0, 0);
        System.out.println(sb);
    }

    // 수열 선택
    public static void dfs(int depth, int lastIndex) {
        // 만약 M개 선택했다면 출력 수열에 포함
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 현재 수 포함 더 크거나 같은 수 중에서 다음 수 선택
        for (int i = lastIndex; i < N; i++) {
            selected[depth] = numbers[i];
            dfs(depth + 1, i);
        }
    }

}
