package java.baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [B3] 백준 2525 오븐 시계
 * 메모리 : 11628KB
 * 시간 : 76ms
 * 코드 길이 : 775B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2525">
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 현재 시간, 요리 시간 입력 받기
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());

		// 분에 요리 시간 합산
		b += c;

		// 24시 60분 == 0시 00분
		// 분이 만약 60분이 넘는다면 60의 나머지 = 요리 완료 분
		// if문 생략보다 if문이 더 빠르다!!
		if (b > 59) {
			a += b / 60;
			b %= 60;
		}

		// 시가 만약 23시가 넘는다면 24의 나머지 = 요리 완료 시
		if (a > 23) {
			a %= 24;
		}

		bw.write(a + " " + b);
		bw.flush();
	}
}
