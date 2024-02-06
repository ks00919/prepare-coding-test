import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S1] 백준 16926 배열 돌리기 1
 * 메모리 : 33196KB
 * 시간 : 564ms
 * 코드 길이 : 1991B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/16926">
 */
public class Main {

	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());
		int r = parseInt(st.nextToken());

		array = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				array[i][j] = parseInt(st.nextToken());
			}
		}
		// 박스의 개수
		int box = Math.min(n, m) / 2 + Math.min(n, m) % 2;

		int startX = 0;
		int startY = m - 1;

		// 배열의 테두리를 순회
		for (int i = 0; i < box; i++) {
			// 회전 횟수만큼 돌리기
			for (int j = 0; j < r; j++) {
				// 가로 세로 돌려야하는 크기 저장
				int column = n - 1;
				int row = m;

				// 순회 인덱스 저장
				int x = startX + i;
				int y = startY - i;
				// 초기값 저장
				int last = array[x][y];
				int tmp = 0;

				for (int k = 1; k < row; k++) { // 오른쪽 -> 왼쪽
					// 현재값을 다음 값으로 옮기고 다음 값은 last 변수에 저장
					tmp = array[x][--y];
					array[x][y] = last;
					last = tmp;

				}

				// 방향이 바뀔때 처음 값 초기화
				tmp = array[++x][y];
				array[x][y] = last;
				last = tmp;
				for (int k = 1; k < column; k++) { // 위 -> 아래
					tmp = array[++x][y];
					array[x][y] = last;
					last = tmp;
				}

				tmp = array[x][++y];
				array[x][y] = last;
				last = tmp;
				for (int k = 1; k < row - 1; k++) { // 왼쪽 -> 오른쪽
					tmp = array[x][++y];
					array[x][y] = last;
					last = tmp;
				}

				tmp = array[--x][y];
				array[x][y] = last;
				last = tmp;
				for (int k = 1; k < column; k++) { // 아래 -> 위
					tmp = array[--x][y];
					array[x][y] = last;
					last = tmp;
				}
			}

			n -= 2;
			m -= 2;
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int[] numbers : array) {
			for (int number : numbers) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
