package 과제_풀이.ch10;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class ClickPracticeFrame extends JFrame {
	public ClickPracticeFrame() {
		super("클릭 연습 용 응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLabel la = new JLabel("C");
		la.setLocation(100, 100);
		la.setSize(20, 20);

		MyMouseAdapter mma = new MyMouseAdapter();
		la.addMouseListener(mma);

		c.add(la);
		setSize(300, 300);
		setVisible(true);
	}

	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			JLabel la = (JLabel) e.getSource();
			Container c = la.getParent(); // 레이블의 부모 컴포넌트 = 컨텐트 팬

			int xBound = c.getWidth() - la.getWidth();
			int yBound = c.getHeight() - la.getHeight();
			int x = (int) (Math.random() * xBound);
			int y = (int) (Math.random() * yBound);

			la.setLocation(x, y);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		new ClickPracticeFrame();
	}
}