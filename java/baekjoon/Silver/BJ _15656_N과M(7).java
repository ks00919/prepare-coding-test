import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [S3] 백준 15656 N과 M (7)
 * 메모리 : 220008KB
 * 시간 : 576ms
 * 코드 길이 : 1102B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15656">
 */
class Main {

	static int[] value;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		value = new int[n];
		result = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			value[i] = parseInt(st.nextToken());
		}
		// 입력 배열 오름차순 정렬
		Arrays.sort(value);

		solution(n, m, 0);

		System.out.println(sb);
	}

	public static void solution(int n, int m, int depth) {
		if (depth == m) {
			for (int number : result) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
			return;
		}

		// 중복 포함
		for (int i = 0; i < n; i++) {
			result[depth] = value[i];
			solution(n, m, depth + 1);
		}
	}
}
