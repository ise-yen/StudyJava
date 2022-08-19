package N1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			////// =====> 입력 시작
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N + 2][2]; // x, y좌표
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} ////// <===== 입력 종료

		} // end of test case
	}

}
