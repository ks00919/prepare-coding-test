import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S4] 백준 1244 스위치 켜고 끄기
 * 메모리 : 11612KB
 * 시간 : 76ms
 * 코드 길이 : 1599B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1244">
 */
class Main {

	// 스위치 저장
	static int[] switchs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = parseInt(br.readLine());
		switchs = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 스위치 값 초기화
		for (int i = 0; i < n; i++) {
			switchs[i] = parseInt(st.nextToken());
		}

		int studentNumber = parseInt(br.readLine());
		for (int i = 0; i < studentNumber; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 남학생이면 boy() 호출
			if (st.nextToken().equals("1")) {
				boy(parseInt(st.nextToken()));
			} else {
				// 여학생은 girl() 호출
				girl(parseInt(st.nextToken()));
			}
		}

		StringBuilder sb = new StringBuilder();
		// 한 줄에 20개의 스위치 출력
		for (int i = 0; i < n; i++) {
			sb.append(switchs[i]).append(' ');
			if ((i + 1) % 20 == 0) {
				sb.append('\n');
			}
		}
		// 결과 출력
		System.out.println(sb);
	}

	// 배정받은 숫자 입력
	public static void boy(int number) {
		// number의 배수마다 스위치 상태 변경
		for (int i = number; i <= switchs.length; i += number) {
			switchs[i - 1] = switchs[i - 1] == 0 ? 1 : 0;
		}
	}

	// 배정받은 숫자 입력
	public static void girl(int number) {
		// 인덱스에 맞게 1 감소
		number -= 1;
		// 배정받은 숫자 부분 스위치 상태 변경
		switchs[number] = switchs[number] == 0 ? 1 : 0;
		// 배정받은 숫자의 스위치를 기준으로 대칭이 같으면 상태 변경
		for (int i = 1; number - i >= 0 && number + i < switchs.length; i++) {
			int left = number - i;
			int right = number + i;
			if (switchs[left] != switchs[right]) {
				break;
			}
			switchs[left] = switchs[left] == 0 ? 1 : 0;
			switchs[right] = switchs[right] == 0 ? 1 : 0;
		}
	}
}
