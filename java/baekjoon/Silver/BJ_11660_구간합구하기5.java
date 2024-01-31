import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S1] 백준 11660 구간 합 구하기 5
 * 메모리 : 128268KB
 * 시간 : 1276ms
 * 코드 길이 : 1224B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11660">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		// n * n 배열 생성
		int[][] array = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 행 별 누적합 저장
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += parseInt(st.nextToken());
				array[i][j] = sum;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 인덱스 입력
			int startX = parseInt(st.nextToken()) - 1;
			int startY = parseInt(st.nextToken()) - 1;
			int endX = parseInt(st.nextToken()) - 1;
			int endY = parseInt(st.nextToken()) - 1;

			int result = 0;
			// 행별 구간 합 합산
			for (int j = startX; j <= endX; j++) {
				result += startY == 0 ? array[j][endY] : array[j][endY] - array[j][startY - 1];
			}
			// 전체 결과값 저장
			sb.append(result).append('\n');
		}
		// 결과 출력
		System.out.println(sb);
	}
}
