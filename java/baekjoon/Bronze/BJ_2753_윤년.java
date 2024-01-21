package java.baekjoon.Bronze;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [B5] 백준 2753 윤년
 * 메모리 : 11588KB
 * 시간 : 76ms
 * 코드 길이 : 683B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2753">
 */
public class BJ_2753_윤년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(br.readLine());

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
