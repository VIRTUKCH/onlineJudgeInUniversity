package 과제_풀이.ch8;

import java.util.HashMap;
import java.util.Scanner;

class Note {
	public HashMap<String, String> word;
	Scanner sc;

	Note() {
		sc = new Scanner(System.in);
	}

	// 여기에서 단어장에 단어 다 추가해줘야 함.
	public boolean LoadData(String[] voca) {
		word = new HashMap<>();
		if (word.isEmpty()) { // 비었으면 추가하고 true 반환하기
			// 1. Key와 Value를 알맞게 짝지어서 단어를 추가한다.
			for (int i = 0; i < voca.length; i++) {
				String[] strArr = voca[i].split(",", 2); // 컴마를 기준으로 두 개로 나눕니다
				word.put(strArr[0], strArr[1]); // 컴마를 기준으로 좌우로 나누어서 저장
			}
			return true;
		} else { // 안비었으면 뭔가 이상한거 -> false 반환하기
			return false;
		}
	}

	void operate() {
		while (true) {
			System.out.println();
			System.out.println("========= Vocabulary Menu =========\r\n" + " 1. Print Vocabulary\r\n"
					+ " 2. Search a word\r\n" + " 3. Add a new word\r\n" + " 4. Delete a word\r\n" + " 0. Exit\r\n"
					+ "===================================");
			System.out.print(" ==>> ");
			int number = sc.nextInt();
			switch (number) {
			case 1:
				printVocabulary();
				break;
			case 2:
				searchWord();
				break;
			case 3:
				addNewWord();
				break;
			case 4:
				deleteWord();
				break;
			case 0:
				return; // 0을 입력하면 프로그램을 종료시켜 버린다.
			}
		}
	}

	// case 1:
	private void printVocabulary() {
		System.out.println("=================== Vocabulary ===================");
		System.out.println("amazing : " + word.get("amazing"));
		System.out.println("chat : " + word.get("chat"));
		System.out.println("minimal : " + word.get("minimal"));
		System.out.println("supermarket : " + word.get("supermarket"));
		System.out.println("wellbeing : " + word.get("wellbeing"));
		System.out.println("==================================================");
	}

	// case 2:
	private void searchWord() {
		System.out.print("Enter a word to search : ");
		String searchWord = sc.next();
		sc.nextLine();

		if (word.get(searchWord) == null) {
			System.out.println("Your entered word does not exist.");
		} else {
			System.out.println(searchWord + " : " + word.get(searchWord));
		}
	}

	// case 3:
	private void addNewWord() {
		System.out.print("Enter a word to append : ");
		String wordToAppend = sc.next();
		sc.nextLine();
		System.out.print("Meaning : ");
		String meaningOfWord = sc.nextLine();
		word.put(wordToAppend, meaningOfWord);
		System.out.println("Word is appended successfully.");
	}

	// case 4:
	private void deleteWord() {
		System.out.print("Enter a word to remove : ");
		String wordToRemove = sc.next();
		word.remove(wordToRemove);
		System.out.println("The word is removed successfully.");
	}

}

public class Main {

	private static final String[] voca = { "amazing,amaze, surprising, wonderful", "chat,chatter, pratter",
			"minimal,min, very small in quantity, value, or degree", "supermarket,mart, a large shop.",
			"wellbeing,happyiness, health and happiness" };

	public static void main(String[] args) {
		Note note = new Note();

		if (note.LoadData(voca)) {
			System.out.println("Vocabulary is loaded. (Total words : " + note.word.size() + ")");
		} else {
			System.out.println("Error : Vocabulary isn't loaded.");
			return;
		}
		note.operate();
		System.out.println("Good bye.");
	}
}