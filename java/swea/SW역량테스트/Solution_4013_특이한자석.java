import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * SWEA 4013 [모의 SW 역량테스트] 특이한 자석
 * 메모리 : 21928KB
 * 실행시간 : 121ms
 * 코드길이 : 2497
 * 
 * @author 김민주
 */
public class Solution {

	// 화살표가 가리키는 인덱스 저장 배열
	static int[] focus;
	// 자석의 극 저장 배열
	static int[][] magnets;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int k = parseInt(br.readLine());
			focus = new int[4];
			magnets = new int[4][8];

			StringTokenizer st = null;
			// 입력 받기
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = parseInt(st.nextToken());
				}
			}

			// 회전하는 배열
			// index는 0부터 시작하므로 1 빼주고, 자석이 돌아가는 방향과 극이 순환하는 방향은 반대이므로 -1 곱해주기
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				rotate(parseInt(st.nextToken()) - 1, parseInt(st.nextToken()) * -1);
			}

			sb.append("#").append(tc).append(" ").append(score()).append("\n");
		}
		System.out.println(sb);
	}

	public static void rotate(int index, int direction) {
		int magnetCount = 4;
		int bumpCount = 8;

		// 회전 이전 극을 가지고 비교하기 때문에 이전 결과를 복사한 배열에 결과 저장
		int[] result = Arrays.copyOf(focus, magnetCount);
		result[index] = getMagnetIndex(bumpCount, focus[index], direction);

		// 현재 자석 왼쪽 방향 자석들 회전
		int d = direction;
		for (int i = index; i > 0; i--) {
			int leftIndex = getMagnetIndex(bumpCount, focus[i - 1], 2);
			int rightIndex = getMagnetIndex(bumpCount, focus[i], -2);

			// 만약 극이 같다면 회전 중지
			if (magnets[i - 1][leftIndex] == magnets[i][rightIndex])
				break;
			// 극이 다르다면 현재 자석의 진행방향과 반대로 회전
			result[i - 1] = getMagnetIndex(bumpCount, focus[i - 1], d *= -1);
		}

		// 오른쪽 방향 자석들 회전
		d = direction;
		for (int i = index; i < magnetCount - 1; i++) {
			int leftIndex = getMagnetIndex(bumpCount, focus[i], 2);
			int rightIndex = getMagnetIndex(bumpCount, focus[i + 1], -2);

			if (magnets[i][leftIndex] == magnets[i + 1][rightIndex])
				break;
			result[i + 1] = getMagnetIndex(bumpCount, focus[i + 1], d *= -1);
		}
		
		// 결과 갱신
		focus = result;
	}

	// 점수 규칙대로 점수 계산
	public static int score() {
		int score = 0;
		for (int i = 0; i < 4; i++) {
			if (magnets[i][focus[i]] == 0)
				continue;
			score += Math.pow(2, i);
		}
		return score;
	}

	// 최대 길이, 현재 인덱스, 진행방향을 파라미터로 받아서 범위 내의 인덱스 반환
	public static int getMagnetIndex(int length, int index, int direction) {
		index += direction;
		if (index < 0)
			return index + length;
		if (index >= length)
			return index - length;
		return index;
	}
}
