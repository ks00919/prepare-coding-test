import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * [B4] 백준 10808 알파벳 개수
 * 메모리 : 11600KB
 * 시간 : 76ms
 * 코드 길이 : 664B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10808">
 */
class Main {
	public static void main(String[] args) throws IOException{
		// 입출력 BufferedReader, BufferedWriter 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 알파벳 개수만큼 정수형 배열 생성
		int[] count = new int[26];
		
		// 문자열 입력 받기
		String input = br.readLine();
		
		// 아스키 코드를 이용해서 배열에 알파벳 갯수 저장 
		int length = input.length();
		for (int i = 0; i < length; i++) {
			count[input.charAt(i) - 'a']++;
		}
		
		// 계산 결과 출력
		for(int i = 0; i < count.length; i++) {
			bw.write(count[i] + " ");
		}
		bw.flush();
	}
}
