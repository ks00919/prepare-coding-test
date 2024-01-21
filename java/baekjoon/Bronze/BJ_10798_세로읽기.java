package java.baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * [B1] 백준 10798 세로읽기
 * 메모리 : 11504KB
 * 시간 : 76ms
 * 코드 길이 : 701B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10798">
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] list = new char[5][];
        for (int i = 0; i < list.length; i++) {
            // 입력 문자열을 문자 배열로 저장
            list[i] = br.readLine().toCharArray();
        }

        // 결과 문자열 저장 객체 생성
        StringBuilder sb = new StringBuilder();
        // 가로 문자열 최대 15
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++)
                // 문자 전체 배열 중 세로로 저장
                if (i < list[j].length) {
                    sb.append(list[j][i]);
                }
        }
        // 출력
        System.out.println(sb.toString());
    }
}
