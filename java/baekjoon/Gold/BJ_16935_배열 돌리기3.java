import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G5] 백준 16935 배열 돌리기 3
 * 메모리 : 44436KB
 * 시간 : 308ms
 * 코드 길이 : 3060B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/16935">
 */
public class Main {

	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());
		int r = parseInt(st.nextToken());
		// 입력 배열 초기화
		array = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				array[i][j] = parseInt(st.nextToken());
			}
		}
		
		// 명령어 입력 및 연산 메서드 실행
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			int order = parseInt(st.nextToken());

			switch (order) {
			case 1:
				solution1(n, m);
				break;
			case 2:
				solution2(n, m);
				break;
			case 3:
				solution3(n, m);
				n = array.length;
				m = array[0].length;
				break;
			case 4:
				solution4(n, m);
				n = array.length;
				m = array[0].length;
				break;
			case 5:
				solution5(n, m);
				break;
			case 6:
				solution6(n, m);
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(array[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	// 1번 연산 : 배열 상하 반전
	public static void solution1(int n, int m) {
		int index = n;
		for (int i = 0; i < n / 2; i++) {
			// 1차원 배열에 저장된 1차원 배열 레퍼런스끼리 위 아래 변경
			int[] tmp = array[i];
			array[i] = array[--index];
			array[index] = tmp;
		}
	}

	// 2번 연산 : 배열 좌우 반전
	public static void solution2(int n, int m) {
		// 1열씩 반복
		for (int i = 0; i < n; i++) {
			int index = m;
			// 좌우 값 교환
			for (int j = 0; j < m / 2; j++) {
				int tmp = array[i][j];
				array[i][j] = array[i][--index];
				array[i][index] = tmp;
			}
		}
	}

	// 3번 연산 : 오른쪽으로 90도 회전
	public static void solution3(int n, int m) {
		// 배열의 크기 변환
		int[][] result = new int[m][n];
		// 오른쪽 끝 인덱스부터 값 복사
		int index = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 가로 한줄을 result 배열의 오른쪽 위부터 저장
				result[j][index] = array[i][j];
			}
			// 왼쪽으로 한 칸 이동
			index--;
		}
		// result 배열을 array 배열로 변경
		array = result;
	}

	// 4번 연산 : 왼쪽으로 90도 회전
	public static void solution4(int n, int m) {
		// 배열의 크기 변환
		int[][] result = new int[m][n];
		
		for (int i = 0; i < n; i++) {
			// 아래열부터 윗열 순으로 채우기
			int index = m - 1;
			for (int j = 0; j < m; j++) {
				// 가로 한줄을 result 배열의 왼쪽 아래부터 저장
				result[index--][i] = array[i][j];
			}
		}
		// result 배열을 array 배열로 변경
		array = result;
	}

	// 5번 연산 : 그룹 부분 배열 오른쪽 이동
	public static void solution5(int n, int m) {
		int[][] result = new int[n][m];

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				// 2차원 배열을 4등분
				int x = i + n / 2;
				int y = j + m / 2;
				// 1번 그룹의 부분 배열을 2번 그룹 위치로
				result[i][y] = array[i][j];
				// 2번을 3번으로
				result[x][y] = array[i][y];
				// 3번을 4번으로
				result[x][j] = array[x][y];
				// 4번을 1번으로
				result[i][j] = array[x][j];
			}
		}
		// result 배열을 array 배열로 변경
		array = result;
	}

	// 6번 연산 : 그룹 부분 배열 왼쪽 이동
	public static void solution6(int n, int m) {
		int[][] result = new int[n][m];

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				// 2차원 배열을 4등분
				int x = i + n / 2;
				int y = j + m / 2;
				// 1번 그룹의 부분 배열을 4번 그룹 위치로
				result[x][j] = array[i][j];
				// 4번을 3번으로
				result[i][j] = array[i][y];
				// 3번을 2번으로
				result[i][y] = array[x][y];
				// 2번을 1번으로
				result[x][y] = array[x][j];
			}
		}
		// result 배열을 array 배열로 변경
		array = result;
	}

}
