package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	static int N;
	static int W, H;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];

			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; i < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// --- 입력 끝
			
			// 목적 : 최대한 많은 벽돌을 제거했을 때, 남은 벽돌의 개수
			// 제거 방법
			// 벽돌을 위에서 친다. -> 숫자-1의 범위 만큼 제거 -> 공중 부양 중인 벽돌은 밑으로 내려옴
			
			
			// 정답 출력
			System.out.println("#" + t + " " + res);
		}
	}

}
