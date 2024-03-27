import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [D3] SWEA 3307 최장 증가 부분 수열
 * 메모리 : 37456KB
 * 실행시간 : 172ms
 * 코드 길이 : 994
 * 
 * @author 김민주
 */
public class Solution {
	// LIS - dp로 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nums = new int[N + 1];
			int[] lis = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				nums[i] = parseInt(st.nextToken());
			}
			
			// 최대 길이 초기값을 1로 설정(자기 자신이 최대 길이일 때)
			Arrays.fill(lis, 1);

			// i = 현재 숫자, j = 현재 숫자 바로 앞에 올 숫자
			for (int i = 1; i <= N; i++) {
				// 만약 i가 j의 뒤에 올 수 있을 때, 현재 i에 저장된 최대 길이보다 j 뒤에 오는 수열이 더 길다면 갱신
				for (int j = 1; j <= i - 1; j++) {
					if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
					}
				}
			}
			
			// 저장된 수열 길이 중에 가장 긴 길이 결과값으로 출력
			int max = -1;
			for (int i = 1; i <= N; i++) {
				if (lis[i] > max) {
					max = lis[i];
				}
			}

			sb.append(String.format("#%d %d%n", tc, max));
		}

		System.out.println(sb);
	}
}
