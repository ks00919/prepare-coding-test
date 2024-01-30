import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [D4] SWEA 1210 [S/W 문제해결 기본] 2일차 - Ladder1 
 * 메모리 : 30164KB 
 * 실행시간 : 154ms 
 * 코드길이 : 1347
 * 
 * @author 김민주
 * @see <a href=
 *      "https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh">
 */
class Solution {

	static int[][] ladder = new int[100][100];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 10개
		for (int testCase = 1; testCase <= 10; testCase++) {
			br.readLine();
			// 도착점 X의 위치
			int location = 0;
			// 사다리 배열 초기화
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					// 만약 마지막 줄 숫자가 2라면 도착점 X 저장
					ladder[i][j] = parseInt(st.nextToken());
					if (i == 99 && ladder[i][j] == 2) {
						location = j;
					}
				}
			}
			// 100번째 줄부터 거꾸로 올라가기
			sb.append(String.format("#%d %d%n", testCase, solution(99, location)));
		}
		System.out.println(sb);
	}

	static int solution(int depth, int location) {
		// 첫번째 줄의 X 위치 반환
		if (depth == 0) {
			return location;
		}
		
		// 반복문을 써서 사다리 통로의 끝 체크
		if (location - 1 >= 0 && ladder[depth][location - 1] == 1) {
			for (int i = location; i >= 0 && ladder[depth][i] == 1; i--) {
				location = i;
			}
		} else if (location + 1 < 100 && ladder[depth][location + 1] == 1) {
			for (int i = location; i < 100 && ladder[depth][i] == 1; i++) {
				location = i;
			}
		}

		// 윗 줄로 한 줄 올라가기
		return solution(depth - 1, location);
	}
}
