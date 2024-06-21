import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [B1] 백준 1259 팰린드롬수
 * 메모리 : 11420KB
 * 시간 : 72ms
 * 코드길이 : 620B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1259">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			// 숫자 입력 받기
			String number = br.readLine();
			// 입력 숫자 0일때, 입력 종료
			if (number.equals("0")) {
				break;
			}

			// StringBuilder 초기화
			sb.setLength(0);
			// 입력받은 숫자 문자열 거꾸로 뒤집기
			for (int i = number.length() - 1; i >= 0; i--) {
				sb.append(number.charAt(i));
			}

			// 뒤집은 문자열이 입력 문자열과 같으면 yes 출력, 다르면 no 출력
			if (number.equals(sb.toString())) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
