package N11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	static int minTime;
	static int[] lineArr;
	static int[] timeArr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		minTime = Integer.MAX_VALUE; // 정답 : 최소시간
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람 수

		lineArr = new int[N]; // 필요한 시간
		timeArr = new int[N]; // 순서별 필요 시간
		visited = new boolean[N];

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// 사람별 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			lineArr[n] = Integer.parseInt(st.nextToken());
			pq.offer(lineArr[n]);
		}

		// 줄 세우기
		int sum = 0, time = 0;
		while(!pq.isEmpty()) {
			int t = pq.poll();
			sum += t;
			time += sum;
		}
		
		System.out.println(time);
	}

	// 순열 : 시간초과
	static void perm(int cnt) {
		if (cnt == lineArr.length) {
			int sum = 0, time = 0;
			for (int i = 0; i < timeArr.length; i++) {
				sum += timeArr[i];
				time += sum;
			}
			minTime = time < minTime ? time : minTime;
			return;
		}

		for (int i = 0; i < lineArr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			timeArr[cnt] = lineArr[i];
			perm(cnt + 1);
			visited[i] = false;
		}
	}

}
