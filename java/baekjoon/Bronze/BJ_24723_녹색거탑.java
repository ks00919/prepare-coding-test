import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [B4] 백준 24723 녹색거탑
 * 메모리 : 11452KB
 * 시간 : 80ms
 * 코드 길이 : 315B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/24723">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		System.out.println((int) Math.pow(2, N));
	}
}
