package Numbaseballgame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame1{ // 버전 선택
	Ver1Frame v1f;
	
	JFrame jf1;
	JPanel jp1;
	
	JButton ver1, ver2, ver3;
	
	public Frame1() {
		jf1 = new JFrame("Start");
		jf1.setSize(700, 700);
		jf1.setVisible(false);
		
		jp1 = new JPanel(null);
		jp1.setSize(300, 100);
		jp1.setBounds(200, 300, 300, 100);
		jf1.add(jp1);
		
		
		ver1 = new JButton("version 1");
		ver2 = new JButton("version 2");
		ver3 = new JButton("version 3");
		
		
		ver1.setBounds(200, 300, 100, 100);
		ver2.setBounds(300, 300, 100, 100);
		ver3.setBounds(400, 300, 100, 100);
		
		ver1.addActionListener(new Frame1Event());
		
		jp1.add(ver1);
		jp1.add(ver2);
		jp1.add(ver3);
		
	}
	
	class Frame1Event implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == ver1) {
				System.out.println("Version1 Start");
				jf1.setVisible(false);
				v1f = new Ver1Frame();
				v1f.v1frame.setVisible(true);
				
			}
		}
	}
}
