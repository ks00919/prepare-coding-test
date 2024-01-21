package java.baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * [B3] 백준 별 찍기 - 9
 * 메모리 : 11804KB
 * 시간 : 96ms
 * 코드 길이 : 927B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2446">
 */
class Main {
	public static void main(String[] args) throws IOException {
		// 입출력 BufferedReader, BufferedWriter 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N 입력받기
		int n = Integer.parseInt(br.readLine());

		// N번째 줄까지 별 찍기
		for (int i = 0; i < n; i++) {
			// i만큼 공백 찍기
			for (int j = 0; j < i; j++) {
				bw.write(" ");
			}
			// 2(N - i) - 1만큼 별 찍기
			int number = 2 * (n - i) - 1;
			for (int j = 0; j < number; j++) {
				bw.write("*");
			}

			bw.newLine();
		}

		// 2N - 1번째 줄까지 별 찍기
		for (int i = n - 2; i >= 0; i--) {
			// i만큼 공백 찍기
			for (int j = 0; j < i; j++) {
				bw.write(" ");
			}
			// 2(N - i) - 1만큼 별 찍기
			int number = 2 * (n - i) - 1;
			for (int j = 0; j < number; j++) {
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
