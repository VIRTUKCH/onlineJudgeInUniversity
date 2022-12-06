//package 과제_풀이.ch9;
//
//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.FlowLayout;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//class NorthPanel extends JPanel {
//	public NorthPanel() {
//		setBackground(Color.LIGHT_GRAY); // 백그라운드 색을 GRAY로 설정
//		setOpaque(true); // 배경색이 보이게 함.
//		setLayout(new FlowLayout(FlowLayout.CENTER)); // 배치관리자를 FlowLayout으로 설정(Default와 같음)
//
//		add(new Button("열기"));
//		add(new Button("닫기"));
//		add(new Button("나가기"));
//	}
//}
//
//class SouthPanel extends JPanel {
//	public SouthPanel() {
//		setBackground(Color.YELLOW); // 백그라운드 색을 노란색으로 설정한다.
//		setOpaque(true); // 배경색이 보이게 한다.
//		setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽 정렬 사용
//
//		add(new Button("Word Input")); // "Word Input"이라는 문자열을 출력하는 버튼을 더한다.
//		JTextField jtf = new JTextField(15); // textField 가로 15글자짜리
//		add(jtf);
//	}
//}
//
//class CenterPanel extends JPanel {
//	public CenterPanel() {
//		setBackground(Color.WHITE); // 백그라운드 색을 WHITE로 설정한다.
//		setLayout(null); // 배치관리자 없음으로 설정
//
//		for (int i = 0; i < 10; i++) {
//			JLabel label = new JLabel("*");
//			int x = (int) (Math.random() * 250) + 10;
//			int y = (int) (Math.random() * 200) + 10;
//
//			label.setLocation(x, y);
//			label.setSize(20, 20);
//			label.setForeground(Color.RED);
//			add(label);
//		}
//	}
//}
//
//class MultiPanelFrame extends JFrame {
//	public MultiPanelFrame() {
//		super("여러 개의 패널을 가진 프레임"); // 타이틀 달기
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램 종료
//		Container c = getContentPane(); // Default가 BorderLayout 배치
//
//		NorthPanel np = new NorthPanel();
//		SouthPanel sp = new SouthPanel();
//		CenterPanel cp = new CenterPanel();
//
//		c.add(np, BorderLayout.NORTH); // 북쪽에 배치
//		c.add(sp, BorderLayout.SOUTH); // 남쪽에 배치
//		c.add(cp, BorderLayout.CENTER); // 중앙에 배치
//
//		setSize(320, 320);
//		setVisible(true);
//	}
//}
//
//public class MultiPanelApp_20194397 extends JFrame {
//	public static void main(String[] args) {
//		MultiPanelFrame mpf = new MultiPanelFrame();
//	}
//}