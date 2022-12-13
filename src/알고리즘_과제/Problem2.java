package 알고리즘_과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem2 {

	public static int changeValue(int n) {
//		return n == 0 ? 1 : 0;
		if (n == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> initList = new ArrayList<>();

		// 1. 사용자에게 좌표의 초기 상태를 입력받는다.
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				initList.add(Integer.parseInt(st.nextToken()));
			}
		}

		// 2. 초기 상태에 따라 배열을 초기화한다.
		int intArr[][] = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				intArr[i][j] = initList.get(i * 3 + j);
			}
		}
//		System.out.println("<최초 입력>");
//		printArray(intArr);

		// 3. 사용자에게 입력의 개수와 좌표를 입력받는다.
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		for (int i = 0; i < n; i++) {

			StringTokenizer pos = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(pos.nextToken()) - 1;
			int y = Integer.parseInt(pos.nextToken()) - 1;

			// 4. 입력받은 좌표에 따라 배열의 값을 바꾸고, 몇 번의 시도만에 게임이 끝나는지 출력한다.

			// 4-1) 자기 값 바꾸기
			changeValue(intArr[x][y]);

			// 4-2) 주변 값 바꾸기
			changeAdjacentValue(intArr, x, y);

//			printArray(intArr); // 결과 확인용 테스트 코드

			if (isAllOne(intArr) || isAllZero(intArr)) {
				System.out.println(cnt);
				return;
			}
			cnt++;
		}

		System.out.println(-1);
	}

//	private static void printArray(int[][] intArr) {
//		System.out.println(Arrays.toString(intArr[0]));
//		System.out.println(Arrays.toString(intArr[1]));
//		System.out.println(Arrays.toString(intArr[2]));
//		System.out.println();
//	}

	private static void changeAdjacentValue(int[][] intArr, int x, int y) {

		// 4-1) 본인 값 바꾸기
		intArr[x][y] = changeValue(intArr[x][y]);
		// 4-2) 위쪽 값 바꾸기
		if (y - 1 >= 0) {
			intArr[x][y - 1] = changeValue(intArr[x][y - 1]);
		}
		// 4-3) 왼쪽 값 바꾸기
		if (x - 1 >= 0) {
			intArr[x - 1][y] = changeValue(intArr[x - 1][y]);
		}
		// 4-4) 오른쪽 값 바꾸기
		if (x + 1 < 3) {
			intArr[x + 1][y] = changeValue(intArr[x + 1][y]);
		}
		// 4-5) 아래쪽 값 바꾸기
		if (y + 1 < 3) {
			intArr[x][y + 1] = changeValue(intArr[x][y + 1]);
		}
	}

	private static boolean isAllOne(int[][] intArr) {
		for (int i = 0; i < intArr.length; i++) {
			for (int j = 0; j < intArr[i].length; j++) {
				if (intArr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isAllZero(int[][] intArr) {
		for (int i = 0; i < intArr.length; i++) {
			for (int j = 0; j < intArr[i].length; j++) {
				if (intArr[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}