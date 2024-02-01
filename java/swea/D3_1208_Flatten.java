import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [D3] SWEA 1208 [S/W 문제해결 기본] 1일차 - Flatten
 * 메모리 : 21712KB
 * 시간 : 127ms
 * 코드 길이 : 907
 * 
 * @author 김민주
 * @see <a href=
 *      "https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh">
 */
class Solution {

	// 결과값 저장 Builder
	static StringBuilder sb = new StringBuilder();
	// box의 높이를 저장하는 배열
	static int[] box = new int[100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 10개
		for (int i = 0; i < 10; i++) {
			int count = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// box 높이 입력 초기화
			for (int j = 0; j < box.length; j++) {
				box[j] = Integer.parseInt(st.nextToken());
			}
			// 로직 실행
			solution(count);
			// 가장 높은 박스의 높이 - 가장 낮은 박스의 높이
			sb.append(String.format("#%d %d%n", i + 1, box[99] - box[0]));
		}
		// 결과 출력
		System.out.println(sb);
	}

	public static void solution(int count) {
		for (int i = 0; i < count; i++) {
			// 오름차순 정렬 후 가장 높은 박스 높이 1 감소, 가장 낮은 박스 높이 1 증가
			Arrays.sort(box);
			box[99]--;
			box[0]++;
		}
		// 마지막으로 한번 더 정렬
		Arrays.sort(box);
	}
}
