package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {

	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int N, M, K; // 세로크기, 가로크기, 배양 시간
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int res = 0; // 살아있는 줄기세포 개수 = 비활성상태+활성상태
			
			// 0. 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map =  new int[N][M];
			
			for(int i =0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ===== 입력 끝
			
			
			System.out.println("#" + " " + t + " " + res);
		}

	}

}
