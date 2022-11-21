package 과제_풀이.ch8;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

enum Vocabulary_MENU {
	Exit(0), Print_Vocabulary(1), Search_a_word(2), Add_a_new_word(3), Delete_a_word(4);

	Vocabulary_MENU(int value) {
		this.value = value;
	}

	private final int value;

	public int value() {
		return value;
	}
}

class Note {
	public HashMap<String, String> word;

	public boolean LoadData(String[] voca) throws IOException {
		word = new HashMap<>();
		if (word.isEmpty()) { // 비었으면 추가하고 true 반환하기
			return true;
		} else { // 안비었으면 뭔가 이상한거 -> false 반환하기
			throw new IOException();
		}
	}

	void operate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= Vocabulary Menu =========\r\n" + " 1. Print Vocabulary\r\n"
				+ " 2. Search a word\r\n" + " 3. Add a new word\r\n" + " 4. Delete a word\r\n" + " 0. Exit\r\n"
				+ "===================================");
		System.out.print(" ==>> ");
		int number = sc.nextInt();
		System.out.println("사용자가 입력한 값  : " + number);
	}
}

public class Main {

	private static final String[] voca = { "amazing,amaze, surprising, wonderful", "chat,chatter, pratter",
			"minimal,min, very small in quantity, value, or degree", "supermarket,mart, a large shop.",
			"wellbeing,happyiness, health and happiness" };

	public static void main(String[] args) {
		Note note = new Note();

		try {
			if (note.LoadData(voca)) {
				System.out.println("Vocabulary is loaded. (Total words : " + note.word.size() + ")");
			} else {
				System.out.println("Error : Vocabulary isn't loaded.");
				return;
			}
		} catch (IOException e) {
			System.out.println("Error : Can't load vocadata.");
			return;
		}
		note.operate();
		System.out.println("Good bye.");
	}
}