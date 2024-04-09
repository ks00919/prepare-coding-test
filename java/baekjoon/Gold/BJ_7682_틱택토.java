import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G5] 백준 7682 틱택토
 * 메모리 : 11460KB
 * 시간 : 76ms
 * 코드 길이 : 2199B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/7682"/>
 */
public class Main {
	// 틱택토 저장 배열
	static char[][] board = new char[3][3];
	// 보드에 있는 X의 개수와 O의 개수 저장
	static int countX, countO;

	// 결과 출력 문자열
	static String invalid = "invalid";
	static String valid = "valid";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = null;

		while (!(input = br.readLine()).equals("end")) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = input.charAt(i * 3 + j);
				}
			}
			countX = 0;
			countO = 0;
			
			// X와 O의 개수 세기
			count();
			
			// X와 O의 개수 차이가 1개, 0개가 아니라면 불가능한 경우
			if (Math.abs(countX - countO) > 1) {
				sb.append(invalid).append("\n");
				continue;
			}
			
			// X와 O의 빙고 개수 보기
			int successX = checkRow('X');
			int successO = checkRow('O');
			
			// 승자가 없을 때와 승자가 있을 때 분기 처리
			// 승리한 사람이 없을 때
			if (successX == 0 && successO == 0) {
				// 두개의 말의 합이 9이고 X가 O보다 커야 승리한 사람없이 정상적으로 진행한 게임
				if (countX + countO == 9 && countX > countO)
					sb.append(valid).append("\n");
				else
					sb.append(invalid).append("\n");
			} else {
				//승리한 사람이 있을 때
				// X는 2줄으로도 승리할 수 있고, X가 이겼을 때 개수는 X가 더 커야함
				if (successX <= 2 && successO == 0 && countX > countO)
					sb.append(valid).append("\n");
				// O는 최대 4개이므로 2줄로 승리할 수 없음, O가 이겼을 때 개수는 X와 O가 같아야 가능
				else if (successO < 2 && successX == 0 && countX == countO)
					sb.append(valid).append("\n");
				else
					// 나머지 모든 경우는 불가능한 경우
					sb.append(invalid).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static void count() {
		// 말의 개수 세기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 'O')
					countO++;
				else if (board[i][j] == 'X')
					countX++;
			}
		}
	}

	public static int checkRow(char player) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			// 가로
			boolean flag = true;
			for (int j = 0; j < 3; j++) {
				if (player != board[i][j])
					flag = false;
			}
			if (flag)
				count++;

			// 세로
			flag = true;
			for (int j = 0; j < 3; j++) {
				if (player != board[j][i])
					flag = false;
			}
			if (flag)
				count++;
		}

		// 대각선 확인
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
			count++;
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
			count++;

		return count;
	}
}
