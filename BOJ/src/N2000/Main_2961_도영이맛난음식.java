package N2000;

import java.util.Scanner;

public class Main_2961_도영이맛난음식 {
	static int N;
	static int[][] taste;
	static boolean[] visited;
	static int totalS = 1;
	static int totalB;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 재료

		taste = new int[N][2];
		visited = new boolean[N];
		for (int n = 0; n < N; n++) {
			taste[n][0] = sc.nextInt(); // 신맛
			taste[n][1] = sc.nextInt(); // 쓴만
		}

		min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			System.out.println("재료 조합 : ");
			totalS = 1;
			totalB = 0;
			combination(visited, 0, N, i);
			System.out.println("<<<다음 방문>>>");
		}
		System.out.println(min);

		sc.close();
	}

	static void combination(boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					totalS *= taste[i][0];
					totalB += taste[i][1];
					print(i, taste[i][0], taste[i][1], totalS, totalB);
				}
				int sub = Math.abs(totalS - totalB);
				min = Math.min(min, sub);
			}
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	static void print(int i, int s, int b, int ts, int tb) {
		System.out.println("[" + i + "방문]");
		System.out.println(" s: " + s + ",  b: " + b);
		System.out.println("ts: " + ts + ", tb: " + tb);
		System.out.println();
	}

}
