package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	static int[][] W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		W = new int[N + 1][N + 1];
		for (int i = 1; i < W.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < W[i].length; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start 지점부터
		visited = new boolean[N + 1]; // 방문한 도시인지
		min = Integer.MAX_VALUE;
		dfs(1, 1, 0, 1);
//		System.out.println();
		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}

	static boolean[] visited;
	static int min;

	static void dfs(int start, int end, int sum, int cnt) {
		int cantMove = 0;
		// 도시를 전부 돌았고, start한 곳으로 돌아왔을 때
		if (cnt == visited.length && start == end) {
//			System.out.println("[종료]" + start + " -> " + end + " : " + sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 1; i < W.length; i++) {
			// 갈 수 없는 곳(==0)이면 가지말고 다음 도시로 가보기
			if (W[start][i] == 0)
				continue;

			// 다음 갈 곳이 시작지점인데 시작 지점 빼고 도시를 다 돌았으면
			if (i == end && cnt == visited.length - 1) {
				int sum2 = sum + W[start][i];
//				System.out.println(start + " -> " + i + " : " + sum2 + "(" + cnt + ")");
				dfs(i, end, sum2, cnt + 1);
			}
			// 아직 도시를 다 안돌았으면 visit 안한 곳만 돌기(시작 지점은 가지 말기)
			if (i != end && cnt < visited.length - 1 && !visited[i]) {
				visited[i] = true;
				int sum2 = sum + W[start][i];
//				System.out.println(start + " -> " + i + " : " + sum2 + "(" + cnt + ")");
				dfs(i, end, sum2, cnt + 1);
				visited[i] = false;
			}

		}
	}
}
