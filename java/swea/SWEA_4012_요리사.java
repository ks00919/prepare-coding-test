import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 4012 [모의 SW 역량테스트] 요리사 
 * 메모리 : 22544KB 
 * 실행시간 : 206ms 
 * 코드길이 : 1681
 * 
 * @author 김민주
 */
public class Solution {

	// 재료 저장 배열
	static int[][] s;
	// 고른 재료 인덱스 저장
	static int[] selected;
	// 방문 체크
	static boolean[] isUsed;
	// 재료 개수, 맛의 차이 최소값
	static int n, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 테스트 케이스 개수
		int tc = parseInt(br.readLine());

		for (int test = 1; test <= tc; test++) {
			// 테스트 케이스마다 변수 초기화
			n = parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			// 배열 생성 및 초기화
			s = new int[n][n];
			selected = new int[n / 2];
			isUsed = new boolean[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					s[i][j] = parseInt(st.nextToken());
				}
			}

			solution(n, 0, 0);
			sb.append(String.format("#%d %d%n", test, min));
		}
		// 결과 출력
		System.out.println(sb);
	}

	// dfs로 탐색
	public static void solution(int n, int depth, int index) {
		// 절반의 재료가 선택되었을때(기저조건)
		if (depth == n / 2) {
			// 선택된 재료들의 시너지 계산
			int flavor = 0;
			for (int i = 0; i < depth; i++) {
				for (int j = 0; j < depth; j++) {
					flavor += s[selected[i]][selected[j]];
				}
			}
			// 선택되지 않은 재료들의 시너지 계산
			int dflavor = 0;
			for (int i = 0; i < n; i++) {
				if (!isUsed[i]) {
					for (int j = 0; j < n; j++) {
						if (!isUsed[j]) {
							dflavor += s[i][j];
						}
					}
				}
			}
			// 두 맛의 차이의 절댓값이 최소보다 작다면 갱신
			int differ = Math.abs(flavor - dflavor);
			if (differ < min) {
				min = differ;
			}
			return;
		}

		// 앞 재료부터 선택
		for (int i = index; i < n; i++) {
			// 방문 체크 및 저장
			isUsed[i] = true;
			selected[depth] = i;
			// 선택 후 다음 재료 선택
			solution(n, depth + 1, i + 1);
			// 현재 재료 선택 해제
			isUsed[i] = false;
		}
	}
}
