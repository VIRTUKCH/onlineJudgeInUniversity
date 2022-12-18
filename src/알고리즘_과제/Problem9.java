package 알고리즘_과제;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem9 {
	public static void main(String[] asdf1) {
		Scanner sc = new Scanner(System.in);

		int totalNum = sc.nextInt();
		int link = sc.nextInt();
		HashMap<Integer, LinkedList<Integer>> arr = new HashMap<>();
		int a, b;
		LinkedList<Integer> temp;
		for (int i = 0; i < link; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

			if (arr.containsKey(a)) {
				temp = arr.remove(a);
			} else {
				temp = new LinkedList<>();
			}
			temp.add(b);
			arr.put(a, temp);
		}
		int visited[] = new int[totalNum];
		LinkedList<Integer> queue = new LinkedList<>();
		int cnt;
		if (arr.containsKey(1)) {
			temp = arr.get(1);

			for (int i = 0; i < temp.size(); i++) {
				queue.add(temp.get(i));
			}
			cnt = 1;
			visited[0] = 1;
			while (!queue.isEmpty()) {
				a = queue.removeFirst();
				if (visited[a - 1] == 0) {
					visited[a - 1] = 1;
					cnt++;
					if (arr.containsKey(a)) {
						temp = arr.get(a);
						for (int i = 0; i < temp.size(); i++) {
							if (!queue.contains(temp.get(i)))
								queue.addLast(temp.get(i));
						}
					}
				}
			}
		} else {
			cnt = 1;
		}
		System.out.println(cnt);
	}
}