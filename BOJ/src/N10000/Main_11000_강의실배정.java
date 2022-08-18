package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11000_강의실배정 {
	static int N; // 강의 수
	static int[][] lecture;
	static boolean[] isLectureAssign; // index번째 강의가 강의실이 배정됐는지 체크

	public static void main(String[] args) throws IOException {
		int res = 0;

		///// =====> 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lecture = new int[N][2];
		for (int n = 0; n < lecture.length; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lecture[n][0] = Integer.parseInt(st.nextToken());
			lecture[n][1] = Integer.parseInt(st.nextToken());
		}
		///// <===== 입력 끝

		// 1. 시작 시간 기준으로 오름차순 정렬
		Arrays.sort(lecture, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

//		// [Debug] 입력, 정렬 체크
//		for (int n = 0; n < N; n++) {
//			System.out.println(lecture[n][0] + " " + lecture[n][1]);
//		}

		isLectureAssign = new boolean[N];
		for (int i = 0; i < lecture.length - 1; i++) {
			boolean isAssign = false;
			int pre = i;
			if (!isLectureAssign[i]) {
				isAssign = true;
				isLectureAssign[i] = true;
			} else {
				continue;
			}
			for (int j = i + 1; j < lecture.length; j++) {
				int post = j;
				if (!isLectureAssign[j]) {
					if (lecture[pre][1] <= lecture[post][0]) {
						isAssign = true;
						isLectureAssign[j] = true;
						pre = post;
					}
				}
			}
			if (isAssign)
				res++;
		}
		System.out.println(res);
	}

}
