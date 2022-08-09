package src.N1200;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			Queue<Integer> q = new LinkedList<>();
			int test_case = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int size = 8;
			for (int i = 0; i < size; i++) {
				int n = Integer.parseInt(st.nextToken());
				q.add(n);
			}

			int front = q.peek();
			while (front > 0) {
				for (int i = 1; i <= 5; i++) {
					front -= i;
					if (front <= 0)
						front = 0;
					q.offer(front);
					q.poll();
					if (front == 0)
						break;
					front = q.peek();
				}
			}

			System.out.print("#" + test_case + " ");
			while(!q.isEmpty()) {
				System.out.print(q.peek() + " ");
				q.poll();
			}
			System.out.println();
		}
		br.close();
	}
}
