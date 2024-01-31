import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S3] 백준 15652 N과 M (4)
 * 메모리 : 14180KB
 * 시간 : 100ms
 * 코드 길이 : 892B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15652">
 */
public class Main {

	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		numbers = new int[m];

		solution(n, m, 0, 0);

		System.out.println(sb);
	}

	// 1부터 N까지 자연수 중에서 M개를 고른 수열, 같은 수 여러 번 가능, 비내림차순
	// 수열을 저장하는 배열의 index - depth, 최소 숫자 - start
	public static void solution(int n, int m, int depth, int start) {
		if (depth == m) {
			for (int number : numbers) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
			return;
		}

		// 최소 숫자 ~ 최대 숫자 하나 골라서 다음 수열 고르기
		for (int i = start; i < n; i++) {
			numbers[depth] = i + 1;
			solution(n, m, depth + 1, i);
		}
	}
}
