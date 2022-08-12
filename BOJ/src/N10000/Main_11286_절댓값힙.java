package N10000;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11286_절댓값힙 {
	static class MinHeap implements Comparable<MinHeap> {
		int value;

		public MinHeap(int value) {
			this.value = value;
		}

		@Override
		public int compareTo(MinHeap o) {
			if(Math.abs(this.value) < Math.abs(o.value)) return -1;
			else if(Math.abs(this.value) > Math.abs(o.value)) return 1;
			// 값이 같으면 더 작은 값이 앞으로
			else {
				return this.value <= o.value ? -1 : 1;
			}
		}

		@Override
		public String toString() {
			return value + " ";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<MinHeap> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x != 0) {
				pq.offer(new MinHeap(x));
			} else {
				// 절대값이 가장 작은 값을 출력
				// 1. 비었을 때 : 0 출력
				if(pq.size() == 0) System.out.println(0);
				else {
					System.out.println(pq.poll());
				}
			} 
		}
	}

}
