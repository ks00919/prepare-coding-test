package swea5215;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [D3] SWEA 5215 햄버거 다이어트
 * 메모리 : 20368KB
 * 실행시간 : 191ms
 * 코드 길이 : 1199
 * 
 * @author 김민주
 */
public class Solution {

	// 햄버거 재료 개수 저장
	static int[][] h;
	// 재료 개수, 제한 칼로리, 최대 점수
	static int n, l, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = parseInt(br.readLine());
		for (int test = 1; test <= tc; test++) {
			st = new StringTokenizer(br.readLine());
			// 테스트 케이스 마다 초기화하는 것을 잊지말 것!!!!!!!!!!!
			max = 0;

			n = parseInt(st.nextToken());
			l = parseInt(st.nextToken());

			h = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				h[i][0] = parseInt(st.nextToken());
				h[i][1] = parseInt(st.nextToken());
			}

			solution(0, 0, 0);
			sb.append(String.format("#%d %d%n", test, max));
		}

		System.out.println(sb);
	}

	// dfs로 부분집합 찾기
	// 현재 재료의 인덱스, 선택한 재료 점수 합, 선택한 재료 칼로리 합
	static void solution(int index, int score, int k) {
		if (k > l) { // 제한 칼로리를 넘겼다면 return
			return;
		}

		if (score > max) { // 최대 점수를 넘겼다면 갱신
			max = score;
		}
		// 재료를 끝까지 탐색했을때 리턴
		if (index == n) {
			return;
		}
		// 현재 재료 선택
		solution(index + 1, score + h[index][0], k + h[index][1]);
		// 현재 재료 선택X
		solution(index + 1, score, k);
	}
}