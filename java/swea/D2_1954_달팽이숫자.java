import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [D2] SWEA 1954 달팽이 숫자
 * 메모리 : 17428KB
 * 실행시간 : 115ms
 * 코드길이 : 1090
 * 
 * @author 김민주
 * @see <a href=
 *      "https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq">
 */
class Solution {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = parseInt(br.readLine());
		// test case 수 만큼 메서드 호출
		for (int testCase = 1; testCase <= t; testCase++) {
			sb.append(String.format("#%d%n", testCase));
			int n = parseInt(br.readLine());
			solution(n);
		}
		System.out.println(sb);
	}

	public static void solution(int n) {
		// 초기 인덱스 : 처음에 y에 1을 더하기 때문에 -1
		int x = 0;
		int y = -1;

		// 회전 방향
		int direction = 1;
		// 숫자를 넣어야하는 크기
		int size = n;
		// 배열에 저장할 숫자변수
		int number = 0;

		int[][] snail = new int[n][n];

		// 회전 횟수만큼 반복문
		for (int i = 0; i < n; i++) {
			// 가로 초기화 : direction(1증가, 1감소)만큼 y 이동
			for (int j = 0; j < size; j++) {
				snail[x][y += direction] = ++number;
			}

			// 가로에서 세로로 갈때 size 감소
			size--;

			// 세로 초기화 : direction(1증가, 1감소)만큼 y 이동
			for (int j = 0; j < size; j++) {
				snail[x += direction][y] = ++number;
			}

			// 회전 방향 변경
			direction *= -1;
		}

		for (int[] numbers : snail) {
			for (int num : numbers) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
	}
}
