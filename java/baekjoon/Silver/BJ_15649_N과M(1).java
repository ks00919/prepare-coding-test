import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S3] 백준 15649 N과 M (1)
 * 메모리 : 19880KB
 * 시간 : 152ms
 * 코드 길이 : 1215B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15649">
 */
class Main {

    public static int[] arr;
    public static boolean[] check;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        check = new boolean[n];
        solution(n, m, 0);
        System.out.println(sb);
    }

    public static void solution(int n, int m, int depth) {
        // 만약 조건에 맞는 숫자를 다 찾았다면 문자열에 추가
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // n까지의 자연수 중 탐색하지 않은 자연수일때 재귀 호출
        // 재귀 실행 후 다시 false 저장
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i + 1;
                solution(n, m, depth + 1);
                check[i] = false;
            }
        }
    }
}
