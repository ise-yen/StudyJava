package N14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14510_나무깊이 {
	static int N;
	static int[] tree;
	static int[] dis;
	static int[] remain;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int res = 0;
			N = Integer.parseInt(br.readLine());
			tree = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}

			dis = new int[N];
			for (int i = 0; i < N; i++) {
				dis[i] = max - tree[i];
			}

			remain = new int[N];
			res = solve();
			System.out.println("#" + t + " " + res);
		}
	}

	private static int solve() {
		int days = 0;

		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			days += dis[i] / 3;
			remain[i] = dis[i] % 3;
			if (remain[i] == 1)
				cnt1++;
			else if (remain[i] == 2)
				cnt2++;
		}
		days *= 2;

		System.out.println(Arrays.toString(dis));
		System.out.println(Arrays.toString(remain));
		if (cnt1 == cnt2)
			days += cnt1 * 2;
		else if (cnt1 < cnt2) {
			days += cnt1 * 2;
			int t = cnt2 - cnt1;
			if (t % 3 == 0) {
				days += 4 * (t / 3);
			} else if (t % 3 == 1) {
				days += 4 * (t / 3) + 2;
			} else {
				days += 4 * (t / 3) + 3;
			}

		} else {
			days += cnt2 * 2;
			int t = cnt1 - cnt2;

			days += t + t - 1;
		}

		return days;
	}
}

/*
 * tree : 2 3 10 5 dis : 8 7 0 5 set : 3*2 3*2 0 3*1 remain : 2 1 0 2
 * 
 */