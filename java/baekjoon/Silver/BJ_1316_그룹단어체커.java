import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [S5] 백준 1316 그룹 단어 체커 
 * 메모리 : 11572KB 
 * 시간 : 80ms 
 * 코드 길이 : 723B
 * 
 * @author 김민주
 * <a href="https://www.acmicpc.net/problem/1316">
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 단어의 개수
		int n = Integer.parseInt(br.readLine());

		// 단어 수 세기
		int count = 0;
		// 입력 단어의 개수만큼 반복
		for (int i = 0; i < n; i++) {
			char[] chars = br.readLine().toCharArray();
			int[] alphabet = new int[26];
			char prev = chars[0];

			for (int j = 0; j < chars.length; j++) {
				// 연속되지 않은 알파벳이 이미 카운팅이 되었을때 break
				if (prev != chars[j] && alphabet[chars[j] - 'a'] != 0) {
					break;
				}
				
				// 이전 문자 저장
				prev = chars[j];
				// 문자 카운팅
				alphabet[chars[j] - 'a']++;
				
				if (j == chars.length - 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
