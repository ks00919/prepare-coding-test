import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S3] 백준 15650 메모리 : 11496KB 시간 : 88ms 코드 길이 : 1029B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15650">
 */
class Main {
	/** 결과값 저장 */
	private static int[] numbers;
	/** 사용했는지 체크 */
	private static boolean[] isUsed;
	/** 출력 문자열 저장 */
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		isUsed = new boolean[n];
		numbers = new int[m];
		// 메서드 실행
		solution(n, m, 0, 0);
		// 출력
		System.out.println(sb);
	}

	// n개의 수 중 m개 선택, start는 이전 숫자로 돌아가지 않기 위한 매개변수
	public static void solution(int n, int m, int depth, int start) {
		// 결과값이 다 저장되었다면 출력 문자열에 저장
		if (depth == m) {
			for (int number : numbers) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
			return;
		}

		// 사용한 적 없다면 저장 후 재귀 호출
		for (int i = start; i < n; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				numbers[depth] = i + 1;
				solution(n, m, depth + 1, i);
				isUsed[i] = false;
			}
		}
	}
}
