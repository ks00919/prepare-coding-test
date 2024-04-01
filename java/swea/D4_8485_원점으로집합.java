import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [D4] SWEA 8485 원점으로 집합
 * 메모리 : 40032KB
 * 실행시간 : 195ms
 * 코드길이 : 1291
 * 
 * @author 김민주
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			// 맨 처음 값 미리 받아두고, 홀수 짝수 여부와 거리 초기값 저장
			long x = parseInt(st.nextToken());
			long y = parseInt(st.nextToken());
			long odd = (Math.abs(x) + Math.abs(y)) % 2;
			long gap = Math.max(0, Math.abs(x) + Math.abs(y));

			boolean isWrong = false;

			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = parseInt(st.nextToken());
				y = parseInt(st.nextToken());
				
				// 좌표의 원점까지의 거리가 전부 짝수이거나 전부 홀수여야 답이 나올 수 있음
				if ((Math.abs(x) + Math.abs(y)) % 2 != odd) {
					isWrong = true;
				}
				// 가장 원점까지 가장 먼 거리  구하기
				// 가장 원점까지와 거리가 먼 점이 원점으로 오는 동안 먼저 도착한 점은 원점을 기준으로 왕복하면서 대기
				gap = Math.max(gap, Math.abs(x) + Math.abs(y));
			}
			 
			int answer = 0;
			// 전부 짝수이거나 전부 홀수가 아닐때
			if (isWrong) {
				sb.append("#").append(tc).append(" -1\n");
			} else {
				while (gap > 0) {
					answer++;
					gap -= answer;
				}
				
				// 가장 먼 점이 원점에 도착했을때 남은 횟수가 짝수면 종료, 홀수이면 짝수, 홀수번 2번의 움직임을 더하여 종료
				answer = gap % 2 == 0 ? answer : (answer % 2 == 0 ? answer + 1 : answer + 2);
				sb.append("#").append(tc).append(" ").append(answer).append("\n");
			}
		}

		System.out.println(sb);
	}
}
