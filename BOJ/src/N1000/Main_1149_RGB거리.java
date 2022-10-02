package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int res = 0; // 정답

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 집 번호 : 1~N번
		int[][] cost = new int[N + 1][3]; // N개의 집, rgb
		int[][] minCostColor = new int[N + 1][3]; // N개 집의 제일 적은 비용의 색상
		for (int n = 1; n < cost.length; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				cost[n][c] = Integer.parseInt(st.nextToken());
			}
		}
		// ======== 입력 끝

		for (int n = 1; n < cost.length; n++) {
			minCostColor[n][0] = Math.min(minCostColor[n - 1][1], minCostColor[n - 1][2]) + cost[n][0];
			minCostColor[n][1] = Math.min(minCostColor[n - 1][0], minCostColor[n - 1][2]) + cost[n][1];
			minCostColor[n][2] = Math.min(minCostColor[n - 1][1], minCostColor[n - 1][0]) + cost[n][2];
		}
		res = Math.min(Math.min(minCostColor[N][0], minCostColor[N][1]), minCostColor[N][2]);

//		int start = 0;
//		for (int n = 1; n < N; n++) {
//			if (minCostColor[n] == minCostColor[n + 1]) {
//				// 다음 집과 다른 색상으로
//				int c1 = 0, c2 = 0;
//				switch (minCostColor[n]) {
//				case 0:
//					c1 = 1;
//					c2 = 2;
//					break;
//				case 1:
//					c1 = 0;
//					c2 = 2;
//					break;
//				case 2:
//					c1 = 0;
//					c2 = 1;
//					break;
//				}
//				if (cost[n][c1] < cost[n][c2]) {
//					start += cost[n][c1];
//				} else if (cost[n][c1] > cost[n][c2]) {
//					start += cost[n][c2];
//				} else {
//					if (c1 == minCostColor[n])
//						start += cost[n][c2];
//					else
//						start += cost[n][c1];
//				}
//			} else {
//				start += cost[n][minCostColor[n]];
//			}
//		} // 집 다 돌았음
//		res = start;
		System.out.println(res);
	}
}

/*
 * 1번 집 색 != 2번 집 색 N-1번 색 != N번 색 i-1 != i != i+1
 * 
 * 
 * 1층을 최솟값 + 로 시작했을 때 => 2층을.. => 3층을.. 으로 계산하기
 * 
 * 
 * 
 * 
 */
