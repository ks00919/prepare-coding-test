import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [D3] 1289 원재의 메모리 복구하기
 * 메모리 : 16076KB
 * 실행 시간 : 112ms
 * 코드 길이 : 1153
 * 
 * @author 김민주
 */
class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int t = Integer.parseInt(br.readLine());
		// T만큼 반복
		for (int i = 0; i < t; i++) {
			// 원래 메모리 bit
			char[] origin = br.readLine().toCharArray();
			// 초기화된 메모리 bit
			int[] bits = new int[origin.length];

			// 메모리 bit 결정횟수저장
			int result = 0;
			// 원래 메모리 bit와 초기화된 메모리 bit 비교
			for (int j = 0; j < origin.length; j++) {
				// 동일하지 않다면 해당 비트부터 끝까지 원래 메모리 bit로 변경
				if (origin[j] - '0' != bits[j]) {
					result++;
					for (int k = j; k < bits.length; k++) {
						// 변경된 bit 저장
						bits[k] = origin[j] - '0';
					}
				}
			}
			// 결과 문자열로 변경
			sb.append('#').append(i + 1).append(' ').append(result).append('\n');
		}
		// 결과 출력
		System.out.println(sb);
	}
}
