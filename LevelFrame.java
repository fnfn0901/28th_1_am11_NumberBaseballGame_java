
package Numbaseballgame;

import javax.swing.*;
import java.awt.event.*;

public class LevelFrame {
	JFrame lf1;
	PlayFrame playFrame;
	
	JButton lb1;
	JButton lb2;
	JButton lb3;
	JButton rc1;
	JButton rb1;
	
	public LevelFrame() {
		lf1 = new JFrame();
		lf1.setTitle("숫자 야구 게임");
		lf1.setVisible(true);
		lf1.setSize(1000,700);
		lf1.setLocationRelativeTo(null);
		lf1.getContentPane().setLayout(null);
		
		lb1 = new JButton("Level 1");
		lb2 = new JButton("Levle 2");
		lb3 = new JButton("Level 3");
		rc1 = new JButton("이전 기록 확인");
		rb1 = new JButton("게임 방법");
				
		lb1.setBounds(180,400,195,50);
		lb2.setBounds(395,400,195,50);
		lb3.setBounds(610,400,195,50);
		rc1.setBounds(180,470,300,50);
		rb1.setBounds(505,470,300,50);
		
		lf1.getContentPane().add(lb1);
		lf1.getContentPane().add(lb2);
		lf1.getContentPane().add(lb3);
		lf1.getContentPane().add(rc1);
		lf1.getContentPane().add(rb1);
		
		playFrame = new PlayFrame();
		
		lb1.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				playFrame.level1f.setVisible(true);
				playFrame.initFirst(2);
				//lf1.setVisible(false);
			}
		});
		lb2.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Level2Frame();
				playFrame.level1f.setVisible(true);
				playFrame.initFirst(3);
				lf1.setVisible(false);
			}
		});
		lb3.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Level3Frame();
				playFrame.level1f.setVisible(true);
				playFrame.initFirst(4);
				lf1.setVisible(false);
			}
		});
		rc1.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RecordCheckFrame();
				lf1.setVisible(false);
			}
		});
		rb1.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RuleFrame();
			}
		});
	}

	public class RecordCheckFrame{
		public RecordCheckFrame() {
			JFrame rc1 = new JFrame();
			rc1.setTitle("이전 기록 확인");
			rc1.setVisible(true);
			rc1.setSize(1000,700);
			rc1.setLocationRelativeTo(null);
		}
	}
	
	public class RuleFrame {
		public RuleFrame() {
			JFrame rf1 = new JFrame();
			rf1.setTitle("게임 방법");
			rf1.setVisible(true);
			rf1.setSize(400,500);
			rf1.setLocationRelativeTo(null);
			
			JLabel rl1 = new JLabel();
			rl1.setText("<html><center>게임 방법<br>&nbsp"
					+ "<p>1. 난이도를 선택한다.<p>레벨 1은 2자리, 레벨2는 3자리, "
					+ "레벨3은 4자리 숫자로 진행된다.<p>&nbsp<p>2. 사용되는 숫자는 1에서"
					+ " 9까지 서로 다른 숫자이다.<p>&nbsp<p>3. 숫자는 맞지만 위치가 틀렸을 때는 ball."
					+ "<p>숫자와 위치가 전부 맞으면 strike.<p>숫자와 위치가 전부 틀리면 out."
					+ "<p>&nbsp<p>4. 무엇이 볼이고 스트라이크인지는 알려주지 않는다."
					+ "<p>&nbsp<p>5. 9회안에 숫자를 맞히면 게임 승리!</center></html>");
			rl1.setHorizontalAlignment(JLabel.CENTER);
			rf1.getContentPane().add(rl1);
			
		}

	}

	
}