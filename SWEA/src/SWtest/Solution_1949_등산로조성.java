package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {
	static int N, K;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int res = 0; // 최대 긴 등산로의 길이
		// 0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}
}

// <등산로 만들기>
// 가장높은 봉우리에서 시작
// 높->낮, 가로or세로, 
// 딱 한 곳을 최대 K 깊이 만큼 지형을 깍을 수 있음

// <최악의 경우 계산>
// 지도 크기 <= 8*8
// 최대 공사 가능 깊이 K <= 5
// 지도의 지형 높이 <= 20
// 봉우리 개수 <= 5
