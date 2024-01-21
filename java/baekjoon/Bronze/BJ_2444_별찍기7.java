import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * [B3] 백준 2444 별 찍기 - 7
 * 메모리 : 11784KB
 * 시간 : 92ms
 * 코드 길이 : 908B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2444">
 */
class Main {
	public static void main(String[] args) throws IOException {
		// 입출력 BufferedReader, BufferedWriter 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N 입력
		int n = Integer.parseInt(br.readLine());

		// N번째 줄까지 별 찍기 (1 ~ N까지 반복)
		for (int i = 1; i <= n; i++) {
			// N-i만큼 공백 찍기
			for (int j = 0; j < n - i; j++) {
				bw.write(" ");
			}

			// 2N-i만큼 별 찍기
			int count = 2 * i - 1;
			for (int j = 0; j < count; j++) {
				bw.write("*");
			}
			bw.newLine();
		}

		// 2N-1번째 줄까지 별 찍기 (N-1 ~ 1까지 반복)
		for (int i = n - 1; i > 0; i--) {
			// N-i만큼 공백 찍기
			for (int j = 0; j < n - i; j++) {
				bw.write(" ");
			}

			// 2N-i만큼 별 찍기
			int count = 2 * i - 1;
			for (int j = 0; j < count; j++) {
				bw.write("*");
			}
			bw.newLine();
		}
		// 출력
		bw.flush();

		br.close();
		bw.close();
	}
}
