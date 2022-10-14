import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

	static int N, M, V;
	static ArrayList<Point> arrP;
	static ArrayList<Integer>[] arrL;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		arrP = new ArrayList<>(); // q 생성
		visited = new boolean[N + 1];
		arrL = new ArrayList[N + 1]; // 0은 무시. 1부터 시작

		// ArrayList 초기화
		for (int i = 0; i < N + 1; i++) {
			arrL[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			Point p = new Point(x, y);
			arrP.add(p);

			// ArrayList 배열
			arrL[x].add(y);
		}

		dfs_arrayList(V);
		visited = new boolean[N + 1];
		bfs_arrayList(V);

	}

	static boolean[] visited;

	static void bfs_arrayList(int v) {
		Queue<Integer> q = new LinkedList<>(); // 큐 생성
		q.offer(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");

			for (int i = 0; i < arrL[cur].size(); i++) {
				int t = arrL[cur].get(i);
				if (visited[t])
					continue;
				visited[t] = true;
				q.offer(t);
			}
		}
	}

	static void dfs_arrayList(int v) {
		Stack<Integer> s = new Stack<>(); // 스택 생성
		s.push(v);
		visited[v] = true;
		System.out.print(v + " ");
		for (int i = 0; i < arrL[v].size(); i++) {
			int t = arrL[v].get(i);
			if(visited[t])
				continue;
			dfs_arrayList(t);
		}
	}


//	static void bfs(int v) {
//		Queue<Integer> q = new LinkedList<>(); // q 생성
//		q.offer(v);
//		visited[v] = true;
//
//		while (!q.isEmpty()) {
//			int cur = q.poll(); // 1
//			System.out.print(cur + " ");
//
//			for (int i = 0; i < M; i++) {
//				Point t = arrP.get(i);
//				if (visited[t.y])
//					continue;
//				else {
//					if (t.x == cur) {
//						visited[t.y] = true;
//						q.offer(t.y);
//					}
//				}
//			}
//		}
//
//	}
}
// v : 1(0), 
// q : 1 
