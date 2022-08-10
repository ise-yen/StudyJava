package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {

	static int[][] arr;
	static int[][] res;
	static int N;
	static int M;
	static int R;
	static int max;

	static void Turn(int k, int n, int m) {
		for (int r = 0; r < R; r++) {
			int tmp = arr[k][k];
			// 상
			for (int j = k; j < m; j++) {
				int i = k;
				if (j == m - 1)
					arr[i][j] = arr[i + 1][j];
				else
					arr[i][j] = arr[i][j + 1];
			}
			// 좌
			for (int i = k; i < n; i++) {
				int j = m - 1;
				if (i != n - 1)
					arr[i][j] = arr[i + 1][j];
			}
			// 하
			for (int j = m - 1; j >= k; j--) {
				int i = n - 1;
				if (j == k)
					arr[i][j] = arr[i - 1][j];
				else
					arr[i][j] = arr[i][j - 1];
			}
			// 우
			for (int i = n - 1; i >= k; i--) {
				int j = k;
				if(i != k)
					arr[i][j] = arr[i - 1][j];
			}
			arr[k + 1][k] = tmp;

			// 디버깅
//			System.out.println("k : " + k);
//			for (int i = k; i < n; i++) {
//				for (int j = k; j < m; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//
//			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		res = new int[N][M];

		max = Math.min(N, M) / 2 - 1;
		while (max >= 0) {
			Turn(max, N - max, M - max);
			max--;
		}

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
