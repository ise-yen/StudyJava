package N2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2850_나무자르기 {
	static int[] trees;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); /// 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 나무 길이
		trees = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		cutting(N/2 -1, N-1, N, M);
	}
	
	static void cutting(int start, int end, int N, int M) {
		if(trees[end] - trees[start] > M) {
			cutting(end/2, end, N, M);
		}
		else {
			cutting(start, end/2, N, M);
		}
	}

}
