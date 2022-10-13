package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

	static Queue<Point> qDFS;
	static Queue<Point> qBFS;
	static Queue<Integer> ansBFS;
	static int N, M, V;

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

		qDFS = new LinkedList<>(); // q 생성
		qBFS = new LinkedList<>(); // q 생성
		// ansDFS = new LinkedList<>(); // q 생성
		ansBFS = new LinkedList<>(); // q 생성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Point p = new Point(x, y);
			qDFS.offer(p);
			qBFS.offer(p);
		}

		dfs();
		ansBFS.offer(V);
		bfs();

	}
	
	static void dfs() {
		while (!qDFS.isEmpty()) {
			Point t = qDFS.poll();
			if (t.x == V) {
				System.out.print(t.y + " ");
			} else {
				qDFS.offer(t);
			}
		}

	}

	static void bfs() {
		while (!qBFS.isEmpty()) {
			Point t = qBFS.poll();
			if (t.x == ansBFS.peek()) {
				System.out.print(ansBFS.peek());
				ansBFS.add(t.y);
			} else {
				qBFS.offer(t);
			}
		}

	}
}
