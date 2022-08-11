package N5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	static List<Ingredient> ingreList;

	static int maxT = Integer.MIN_VALUE;
	static int sumL = 0; // 칼로리 합
	static int sumT = 0; // 만족도 합
	static class Ingredient implements Comparable<Ingredient> {
		int t; // 재료에 대한 점수
		int k; // 칼로리

		public Ingredient(int t, int k) {
			this.t = t;
			this.k = k;
		}

		@Override
		public int compareTo(Ingredient o) {
			return this.t - o.t;
		}

		@Override
		public String toString() {
			return "Ingredient [t=" + t + ", k=" + k + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			ingreList = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken()); // 재료에 대한 점수
				int k = Integer.parseInt(st.nextToken()); // 칼로리

				ingreList.add(new Ingredient(t, k));
			}

			Collections.sort(ingreList);


		}

	}

	static void combination(boolean[] visited, int start, int n, int r) {
		if(r==0) {
			return;
		}
		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

}
