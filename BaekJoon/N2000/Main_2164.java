import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		// 카드 초기화
		for(int i =1; i <= N; i++) {
			q.add(i);
		}
		
		while(q.size() > 1) {
			// 첫 번째 카드 버리기
			q.remove(); 
			
			// 첫 번째(가 된 두 번째)카드를 제일 마지막 순서로
			q.add(q.peek());
			q.remove();
		}
		// 남은 한 장 출력
		System.out.println(q.peek());
	}

}
