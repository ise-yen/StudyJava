package N11000;
import java.util.Scanner;

// 하노이
public class Main_11729_하노이 {
	static int n;
	static int cnt;
	public static void move(int n, int start, int temp, int end) {
		cnt++;
		if (n == 1)
			System.out.println(start + " " + end);
		else {
			move(n - 1, start, end, temp);
			System.out.println(start + " " + end);
			move(n - 1, temp, start, end);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// top을 end로 옮기기
		move(n, 1, 2, 3);
		System.out.println(cnt);
		
		sc.close();
	}
}
