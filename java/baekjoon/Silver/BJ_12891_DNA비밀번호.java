import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S2] 백준 12891 DNA 비밀번호
 * 메모리 : 19752KB
 * 시간 : 184ms
 * 코드 길이 : 1292B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/12891">
 */
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// DNA 문자열 구성 요소
		char[] chars = { 'A', 'C', 'G', 'T' };

		// DNA 문자열 길이
		int s = parseInt(st.nextToken());
		
		// 부분 문자열 길이
		int p = parseInt(st.nextToken());
		// 만들 수 있는 비밀번호 종류의 수
		int count = 0;

		// 임의로 만든 DNA 문자열
		String input = br.readLine();

		// 부분 문자열 최소 개수 저장
		int[] min = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			min[i] = parseInt(st.nextToken());
		}

		// 아스키코드로 배열 생성, 아스키 코드가 가장 큰 T 크기로 생성
		int[] counts = new int['T' + 1];
		for (int i = 0; i < p; i++) {
			// 첫 부분 문자열 세기
			counts[input.charAt(i)]++;
		}

		// 부분문자열 기준 체크
		boolean check = true;
		for (int i = 0; i < 4; i++) {
			if (counts[chars[i]] < min[i]) {
				check = false;
				break;
			}
		}
		if (check) {
			count++;
		}

		// 가장 끝 부분의 인덱스가 배열의 범위를 넘지 않도록 반복
		int end;
		for (int i = 1; (end = i + p - 1) < s; i++) {
			// 인덱스 1씩 뒤로 이동, 범위에서 빠진 문자 count 1  감소, 새로 들어온 문자 count 1 증가
			// 아스키 코드를 index로 사용
			counts[input.charAt(i - 1)]--;
			counts[input.charAt(end)]++;
			
			// 기준 체크하기
			check = true;
			for (int j = 0; j < 4; j++) {
				if (counts[chars[j]] < min[j]) {
					check = false;
					break;
				}
			}
			if (check) {
				count++;
			}
		}

		// 결과 출력
		System.out.println(count);
	}

}
