package Numbaseballgame;

import javax.swing.*;
import java.awt.event.*;

public class StartFrame {
	JFrame sf1;
	JButton lb1;
	JButton jb1;
	
	public StartFrame() {
	sf1 = new JFrame();
	sf1.setTitle("숫자 야구 게임");
	sf1.setVisible(true);
	sf1.setSize(1000,700);
	sf1.setLocationRelativeTo(null);
	sf1.getContentPane().setLayout(null);
	
	lb1 = new JButton("login");
	jb1 = new JButton("join");
	lb1.setBounds(285,500,180,50);
	jb1.setBounds(535,500,180,50);
	
	sf1.getContentPane().add(lb1);
	sf1.getContentPane().add(jb1);
	
	lb1.addActionListener(new ActionListener( ) {
		@Override
		public void actionPerformed(ActionEvent e) {
			new LoginFrame();
			sf1.setVisible(false);
		}
	});
	
	jb1.addActionListener(new ActionListener( ) {
		@Override
		public void actionPerformed(ActionEvent e) {
			new JoinFrame();
			sf1.setVisible(false);
		}
	});
	
	}
	
	//임의로 만든 클래스
	public class LoginFrame{
		public LoginFrame() {
			JFrame lg1 = new JFrame();
			lg1.setTitle("Login");
			lg1.setVisible(true);
			lg1.setSize(1000,700);
			lg1.setLocationRelativeTo(null);
		}
	}
	public class JoinFrame{
		public JoinFrame() {
			JFrame jb1 = new JFrame();
			jb1.setTitle("Join");
			jb1.setVisible(true);
			jb1.setSize(1000,700);
			jb1.setLocationRelativeTo(null);
		}
	}



	public static void main(String[] args) {
		new StartFrame();
	}

}
