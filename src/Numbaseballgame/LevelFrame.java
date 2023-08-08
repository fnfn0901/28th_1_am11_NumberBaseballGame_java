package Numbaseballgame;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.*;

public class LevelFrame extends JDialog{
	
	JButton lb1;
	JButton lb2;
	JButton lb3;
	JButton rb1;
	
	JPanel jp1;
	
	JDialog jdpractice = new JDialog();
	
	int levelState; // 2, 3, 4
	
	
	static ImageIcon backIcon = new ImageIcon("img/backImage2.png");
	
	public LevelFrame(JFrame frame) {
		super(frame, "Select Level", true);
		setVisible(false);
		setSize(1000,700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		jp1 = new JPanel(null) {
			public void paintComponent(Graphics g) {
				g.drawImage(backIcon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		add(jp1);
		jp1.setSize(1000, 700);
		
		lb1 = new JButton("Level 1");
		lb2 = new JButton("Levle 2");
		lb3 = new JButton("Level 3");
		rb1 = new JButton("게임 방법");
		
				
		lb1.setBounds(180,400,195,50);
		lb2.setBounds(395,400,195,50);
		lb3.setBounds(610,400,195,50);
		rb1.setBounds(250,470,500,50);
		
		
		jp1.add(lb1);
		jp1.add(lb2);
		jp1.add(lb3);
		jp1.add(rb1);
		
		//playFrame = new PlayFrame();
		
		lb1.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				//playFrame.level1f.setVisible(true);
				//playFrame.initFirst(2);
				levelState = 2;
				setVisible(false);
			}
		});
		lb2.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Level2Frame();
				//playFrame.level1f.setVisible(true);
				//playFrame.initFirst(3);
				levelState = 3;
				setVisible(false);
			}
		});
		lb3.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Level3Frame();
				//playFrame.level1f.setVisible(true);
				//playFrame.initFirst(4);
				levelState = 4;
				setVisible(false);
			}
		});
		
		rb1.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new RuleFrame(frame);
				String st = "<html><center>게임 방법<br>&nbsp"
						+ "<p>1. 난이도를 선택한다.<p>레벨 1은 2자리, 레벨2는 3자리, "
						+ "레벨3은 4자리 숫자로 진행된다.<p>&nbsp<p>2. 사용되는 숫자는 1에서"
						+ " 9까지 서로 다른 숫자이다.<p>&nbsp<p>3. 숫자는 맞지만 위치가 틀렸을 때는 ball."
						+ "<p>숫자와 위치가 전부 맞으면 strike.<p>숫자와 위치가 전부 틀리면 out."
						+ "<p>&nbsp<p>4. 무엇이 볼이고 스트라이크인지는 알려주지 않는다."
						+ "<p>&nbsp<p>5. 9회안에 숫자를 맞히면 게임 승리!</center></html>";
				JOptionPane.showMessageDialog(null, st);
			}
		});
	}

	
}