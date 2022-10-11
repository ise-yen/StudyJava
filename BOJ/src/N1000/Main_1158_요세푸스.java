package N1000;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 요세푸스 문제
public class Main_1158_요세푸스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();

		int n = sc.nextInt();
		int k = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		System.out.print("<");
		int i = 1;
		while (q.size() > 0) {
			if (i % k == 0) {
				System.out.print(q.peek());
				q.remove();
				if (q.size() > 0)
					System.out.print(", ");
				else
					System.out.print(">");
			} else {
				int tmp = q.peek();
				q.offer(tmp);
				q.remove();
			}
			i++;
		}
		
		sc.close();
	}
}
