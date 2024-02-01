import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [D3] SWEA 2805 농작물 수확하기
 * 메모리 : 20128KB
 * 실행 시간 : 120ms
 * 코드 길이 : 1150
 * 
 * @author 김민주
 * @see <a href=
 *      "https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB">
 */
class Solution {

	static StringBuilder sb = new StringBuilder();
	static int[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {

			int size = parseInt(br.readLine());
			field = new int[size][size];
			for (int i = 0; i < size; i++) {
				char[] values = br.readLine().toCharArray();
				for (int j = 0; j < size; j++) {
					field[i][j] = values[j] - '0';
				}
			}

			sb.append(String.format("#%d %d%n", testCase, solution(0, size / 2, size / 2)));
		}
		System.out.println(sb);
	}

	// 출발과 시작 매개변수로 받기
	static int solution(int x, int start, int end) {
		// 끝까지 검사했다면 return
		if (x == field.length) {
			return 0;
		}

		// x번째 줄 값 검사
		int value = 0;
		for (int i = start; i <= end; i++) {
			value += field[x][i];
		}

		// 마름모 위쪽이라면 검사 길이 늘리기
		if (x < field.length / 2) {
			return value + solution(x + 1, start - 1, end + 1);
		}
		// 마름모 아래쪽이라면 검사 길이 줄이기
		return value + solution(x + 1, start + 1, end - 1);
	}
}
