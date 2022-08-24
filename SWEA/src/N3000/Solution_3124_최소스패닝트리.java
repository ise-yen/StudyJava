package N3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return Integer.compare((this.weight, o.weight);
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

	}

	static int[] parents;
	static int V, E;
	static Edge[] edgeArr;

	// 크기가 1인 서로소 집합 생성
	static void make() {

		parents = new int[V];

		// 모든 노드가 자신을 부모로 하는 (대표자) 집합으로 만듦
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

	}

	// a의 대표자 찾기
	static int find(int a) {
		if (parents[a] == a) {
			System.out.println("parents[" + a + "] = " + a);
			return a;
		}

		// 우리의 대표자를 나의 부모로.. : path compression
		System.out.println("parents[" + a + "] = " + "find(parents[" + a + "] = " + find(parents[a]));
		return parents[a] = find(parents[a]);
	}

	// 리턴값 : true ==> union 성공
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			System.out.println("union(" + a + " == " + b + ") : " + "fasle");
			return false;
		}
		parents[bRoot] = aRoot;
		System.out.println("union(" + a + ", " + b + ") 집합의 대장 : " + aRoot);
		return true;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) { // start of Test Case
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수
			edgeArr = new Edge[E];

			// 간선 정보 입력
			for (int i = 0; i < edgeArr.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				edgeArr[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			make();
			Arrays.sort(edgeArr);

			int minWeight = Integer.MAX_VALUE;
			int cnt = 0;
			int result = 0;

			for (Edge edge : edgeArr) {
				System.out.println(edge.toString());
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					System.out.println(" + " + edge.weight + " = " + result);
					if (++cnt == V - 1) {
						System.out.println(V - 1 + "아웃");
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(minWeight).append("\n");
		}
	}

}
