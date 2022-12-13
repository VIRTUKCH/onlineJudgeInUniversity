package 알고리즘_과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int scholorship[][] = new int[n][2]; // (1학기, 2학기)

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			scholorship[i][0] = Integer.parseInt(st.nextToken());
			scholorship[i][1] = Integer.parseInt(st.nextToken());
		}

		// ---------------- 학기별 장학금 금액 등록 완료 ----------------

//		System.out.println("1학기로 장학금을 시작한 경우");
		int max1 = dp(scholorship, 0, 0, n); // 1학기 금액으로 시작한 경우

//		System.out.println("2학기로 장학급을 시작한 경우");
		int max2 = dp(scholorship, 0, 1, n); // 2학기 금액으로 시작한 경우

		System.out.println(Math.max(max1, max2));
	}

	// dp함수를 부르는 경우에는, 아래1 옆으로1 or 아래2 옆으로1 셋 중에 최대값을 택할 수 있도록
	private static int dp(int[][] scholorship, int n, int m, int sizeOfInput) {
		if (n == sizeOfInput - 1) {
			return scholorship[sizeOfInput - 1][m];
		} else if (n == sizeOfInput - 2) {
			return scholorship[sizeOfInput - 2][m] + scholorship[sizeOfInput - 1][m == 1 ? 0 : 1];
		}

		if (m == 0) {
//			System.out.println("m이 0인 경우에 이렇게 이동한다.");
//			System.out
//					.println(Math.max(dp(scholorship, n + 1, 1, sizeOfInput), dp(scholorship, n + 2, 0, sizeOfInput)));
			return dp(scholorship, n, 0, sizeOfInput)
					+ Math.max(dp(scholorship, n + 1, 1, sizeOfInput), dp(scholorship, n + 2, 0, sizeOfInput));
		} else {
//			System.out.println("m이 1인 경우에 이렇게 이동한다");
//			System.out
//					.println(Math.max(dp(scholorship, n + 1, 1, sizeOfInput), dp(scholorship, n + 2, 0, sizeOfInput)));
			return dp(scholorship, n, 1, sizeOfInput)
					+ Math.max(dp(scholorship, n + 1, 0, sizeOfInput), dp(scholorship, n + 2, 1, sizeOfInput));
		}
	}
}