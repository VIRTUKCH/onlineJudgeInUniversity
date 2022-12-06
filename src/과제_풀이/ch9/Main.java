//package 과제_풀이.ch9;
//
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.GridLayout;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//
//class TenColorButtonFrame extends JFrame {
//	Color[] color = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA,
//			Color.GRAY, Color.PINK, Color.LIGHT_GRAY };
//
//	TenColorButtonFrame() {
//		super("Ten Color Buttons Frame"); // 1. 타이틀 달기 - 수퍼클래스의 생성자 호출
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 2. 프레임 윈도우 닫으면 프로그램 종료
//		Container c = getContentPane(); // 3. 컨텐트 팬 알아내서 c에 저장하기
//
//		c.setLayout(new GridLayout(1, 10)); // 4. 레이아웃 설정
//
//		JButton btn[] = new JButton[10]; // 5. btn[]선언 및 초기화
//		for (int i = 0; i < btn.length; i++) {
//			btn[i] = new JButton(String.valueOf(i)); // 5-1. 버튼별로 숫자를 입력해주어야 함.
//			btn[i].setOpaque(true); // 5-3. 버튼 배경색 보이게 하기
//			btn[i].setBackground(color[i]); // 5-2. 버튼별로 배경색을 바꾸어주어야 함.
//			c.add(btn[i]); // 5-4. 컨테이너에 컴포넌트(버튼) 추가.
//		}
//		setSize(500, 200);
//		setVisible(true);
//	}
//}
//
//public class TenColorApp_20194397 extends JFrame {
//	public static void main(String[] args) {
//		TenColorButtonFrame tc = new TenColorButtonFrame();
//	}
//}
