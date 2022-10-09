package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int res = 0; // 가장 많이 먹었을 때 디저트 개수

		// 0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(br.readLine());
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

// 카페 투어
// 맵에는 종류 번호가 들어가 있음
// 대각선으로 움직여서 시작점으로 돌아오기
// 지도 범위 넘어가면 안됨
// 같은 게 들어가면 안됨(list에 넣고 같은 값이 있는지 찾기)
// 한 곳만 방문하면 안됨
// 왔던 노선을 지나가면 안됨
// 아무 디저트도 못 먹으면 -1 출력

// <최악의 경우 계산>
//