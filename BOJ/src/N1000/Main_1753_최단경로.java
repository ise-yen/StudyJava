package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

//	static int[][] adjM;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int start = Integer.parseInt(br.readLine()); // 시작정점 번호
//		adjM = new int[V + 1][V + 1]; // 정점 번호가 1부터 시작하므로

		PriorityQueue<Node>[] adjM = new PriorityQueue[V + 1];

		int INF = Integer.MAX_VALUE;
		for (int i = 1; i < adjM.length; i++) {
			adjM[i] = new PriorityQueue<Node>();
		}
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 시작
			int v = Integer.parseInt(st.nextToken()); // 도착
			int w = Integer.parseInt(st.nextToken()); // 간선 가중치 (10이하의 자연수)
			adjM[u].add(new Node(v, w));
		}

//		다익스트라 (음의 수 사용 x)
		int[] Dis = new int[adjM.length]; // 출발지에서 자신으로 오는데 필요한 최소비용
		Arrays.fill(Dis, Integer.MAX_VALUE); // 큰 값으로 초기화

		Dis[start] = 0; // 출발 정점 처리

		while (!adjM[start].isEmpty()) {
			Node tmp = adjM[start].poll();
			int to = tmp.to;
			int weight = tmp.weight;

			if (Dis[to] != Integer.MAX_VALUE)
				continue;

			Dis[to] = weight;

			for (Node n : adjM[to]) {
				adjM[start].add(new Node(n.to, n.weight + weight));
			}
		}

		for (int end = 1; end < adjM.length; end++) {
			if (end == start)
				sb.append(0).append("\n");
			else if (Dis[end] == INF)
				sb.append("INF\n");
			else
				sb.append(Dis[end]).append("\n");
		}
		System.out.println(sb);
	}

}
