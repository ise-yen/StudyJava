package N11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11000_강의실배정 {

	public static void main(String[] args) throws IOException {

		///// =====> 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 강의 수
		int[][] lecture = new int[N][2]; // index번째 강의가 강의실이 배정됐는지 체크
		for (int n = 0; n < lecture.length; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lecture[n][0] = Integer.parseInt(st.nextToken());
			lecture[n][1] = Integer.parseInt(st.nextToken());
		}
		///// <===== 입력 끝

		Arrays.sort(lecture, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 1. 시작 시간 기준으로 오름차순 정렬
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		// [Debug] 입력, 정렬 체크
		for (int n = 0; n < N; n++) {
			System.out.println(lecture[n][0] + " " + lecture[n][1]);
		}

		// 강의 종료 시간
		PriorityQueue<Integer> endTime = new PriorityQueue<>();
		endTime.offer(lecture[0][1]);

		for (int i = 1; i < lecture.length - 1; i++) {
			if (lecture[i][0] >= endTime.peek()) {
				endTime.poll();
				endTime.offer(lecture[i][1]);
			} else {
				endTime.offer(lecture[i][1]);
			}

		}

		System.out.println(endTime.size());

	}

}

/*
 * test case 8 1 5 3 8 1 2 2 4 3 4 6 7 7 8 8 9
 */