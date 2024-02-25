import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

/**
 * [S3] 백준 15654 N과 M(5)
 * 메모리 : 30220KB
 * 시간 : 252ms
 * 코드 길이 : 1350B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15654">
 */
class Main {

    static int N, M;
    static int[] numbers;
    static int[] selected;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        numbers = new int[N];
        selected = new int[M];
        isUsed = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0);

        System.out.println(sb);
    }

    // dfs 사용해서 사전 순 수열 만들기
    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                selected[depth] = numbers[i];
                dfs(depth + 1);
                isUsed[i] = false;
            }
        }
    }

}