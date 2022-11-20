package ch6;

import java.util.Scanner;
import java.util.StringTokenizer;

class TextProcess {
	String wholeMsg; // 메세지 전체
	String text; // 앞 메세지 - 무조건 대문자
	String keyword; // 키워드

	public TextProcess(String input) { // 객체 생성 시, 입력받은 텍스트를 기반으로 생성자 함수 수행
		StringTokenizer st = new StringTokenizer(input.trim(), "/");
		this.wholeMsg = input.trim();
		this.text = st.nextToken().trim();

		char[] charedText = text.toCharArray();
		for (int i = 0; i < charedText.length; i++) {
			if (charedText[i] >= 'a' && charedText[i] <= 'z') {
				charedText[i] -= 32;
			}
		}
		this.text = String.valueOf(charedText).trim(); // this.text는 무조건 대문자
		this.keyword = st.nextToken().trim();
	}

	public int getTextLength(String input) { // 입력받은 텍스트의 전체 길이를 정수로 반환
		return text.length();
	}

	public int getWordCount(String input) { // 입력받은 텍스트의 단어 수를 정수로 반환
		StringTokenizer st = new StringTokenizer(text, " +");
		return st.countTokens();
	}

	public int getAlphabetCount(String input) { // 입력받은 텍스트의 문자(A~Z) 수를 정수로 반환

		int countOfText = 0;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (isMiniChar(c) || isBigChar(c))
				countOfText++;
		}
		return countOfText;
	}

	public int getNumCount(String input) { // 입력받은 텍스트의 숫자(0~9) 수를 정수로 반환
		int countOfNumber = 0;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (isNumber(c))
				countOfNumber++;
		}
		return countOfNumber;
	}

	public int getSpeChrCount(String input) { // 입력받은 텍스트의 특수기호 수를 정수로 반환
		// 위 문자, 숫자, 스페이스 글자를 제외한 모든 글자('\t','\n' 등 포함)는 특수기호로 취급한다.
		int countOfSpecialSign = 0;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (!isNumber(c) && !isMiniChar(c) && !isBigChar(c) && !isSpaceBar(c)) {
				countOfSpecialSign++;
			}
		}
		return countOfSpecialSign;
	}

	private boolean isNumber(char c) {
		return (c >= '0' && c <= '9');
	}

	private boolean isMiniChar(char c) {
		return (c >= 'a' && c <= 'z');
	}

	private boolean isBigChar(char c) {
		return (c >= 'A' && c <= 'Z');
	}

	private boolean isSpaceBar(char c) {
		return c == ' ';
	}

	public boolean checkText() { // 입력받은 텍스트에서 찾고자 하는 키워드가 있는지 여부를 반환

		return text.contains(keyword.toUpperCase()); // 일단 나머지 구현하고 나서 이야기하자.
	}

	@Override // overriding
	public String toString() { // TextProcess 객체를 출력(println)하였을 때, 문제에서 요구하는 양식대로 출력하도록 toString() 함수를
								// overriding
		return "Hello";
	}

}

public class Main { // 메인 클래스

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // 텍스트를 입력받기 위한 Scanner 객체 생성
		while (true) { // 텍스트를 연속으로 입력받기 위한 while loop
			System.out.print("Input Msg: ");
			String str = s.nextLine(); // 1. 문제에서 요구하는 형태로 입력 문구 및 입력받은 텍스트 출력
			str.trim(); // 2. 입력받은 텍스트의 불필요한 양쪽 공백 제거
			if (str.equals("exit")) { // 3. exit가 입력되었을 때, 무한 루프 종료
				System.out.println("exit");
				System.out.println("Good bye!");
				break;
			}
			TextProcess tp = new TextProcess(str); // 4. TextProcess 객체 생성

			tp.getTextLength(str);

			// ------------------출력 구분선------------------

			System.out.println(str); // TextProcess 객체 정보 출력
			System.out.println("Text: " + tp.text);
			System.out.println("Text Length: " + tp.getTextLength(str));
			System.out.println("Word Count: " + tp.getWordCount(str));
			System.out.println("Alphabet Count: " + tp.getAlphabetCount(str));
			System.out.println("Number Count: " + tp.getNumCount(str));
			System.out.println("Special Character Count: " + tp.getSpeChrCount(str));

			if (tp.checkText()) {
				System.out.println("Thers is the keyword in the input text.");
			} else {
				System.out.println("Thers is no keyword in the input text.");
			}
			System.out.println();
		}
		s.close(); // Scanner 객체 종료
		// 종료메세지 출력
	}
}
