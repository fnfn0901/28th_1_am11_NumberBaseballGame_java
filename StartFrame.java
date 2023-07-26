package Numbaseballgame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JDialog{
	//JFrame sf1;
	JButton lb1;
	JButton jb1;
	/*
	levelFrame lf;
	PlayFrame pf;
	JoinFrame joi;
	LoginFrame log;
	*/
	
	JPanel jp1 = new JPanel();
	
	public StartFrame(JFrame frame) {
		
		super(frame, "StartFrame", true);
		
		//sf1 = new JFrame();
		
		setVisible(false);
		setSize(1000,700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		jp1 = new JPanel(null); /*{
			public void paintComponent(Graphics g) {
				g.drawImage(backIcon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};*/
		add(jp1);
		jp1.setSize(1000, 700);
		
		lb1 = new JButton("login");
		jb1 = new JButton("join");
		lb1.setBounds(285,500,180,50);
		jb1.setBounds(535,500,180,50);
		
		jp1.add(lb1);
		jp1.add(jb1);
		
		
		lb1.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {

				//LoginFrame log = new LoginFrame();
				setVisible(false);
			}
		});
		
		jb1.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {

				//JoinFrame joi = new JoinFrame();
				setVisible(false);
			}
		});
	
	}
	
	/*
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
	}*/


}