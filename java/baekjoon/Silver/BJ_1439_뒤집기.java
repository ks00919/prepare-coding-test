import static java.lang.Integer.*;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * [S5] 백준 1439 뒤집기
 * 메모리 : 11488KB
 * 시간 : 80ms
 * 코드 길이 : 474B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1439"/>
 */
public class Main {

	// 그리디
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count = 0;
		// 만약 현재 숫자와 뒤의 숫자가 다르다면 count 증가
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) != input.charAt(i + 1)) {
				count++;
			}
		}
		// 규칙상 count+1/2하면 정답 도출됨
		System.out.println((count + 1) / 2);
	}
}
