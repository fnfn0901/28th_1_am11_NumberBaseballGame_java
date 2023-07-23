package Numbaseballgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ver1Frame {
	Frame1 stf;
	MainFrame mf;
	createRN cRN;
	
	JFrame v1frame;
	JButton n1, n2, n3, n4, n5, n6, n7, n8, n9;
	JButton back_again;
	JPanel keyPanel;
	JPanel userNumPanel;
	JPanel baPanel;
	int[] randomNumber = new int[3];
	
	Thread timer;
	
	
	public Ver1Frame() {
		// 숫자 정해짐
		cRN = new createRN();
		int[] randomNumber = new int[3];
		randomNumber = cRN.returnRN();
		
		System.out.println(randomNumber[0]);
		System.out.println(randomNumber[1]);
		System.out.println(randomNumber[2]);
		
		// Timer 설정
		timer = new Thread(new ThreadTimer());
		timer.start();
		
		v1frame = new JFrame("Version1 Start");
		v1frame.setSize(700, 700);
		v1frame.setVisible(false);
		
		keyPanel = new JPanel(null);
		keyPanel.setBounds(100, 300, 300, 300);
		keyPanel.setBackground(Color.pink);
		v1frame.add(keyPanel);
		
		userNumPanel = new JPanel(null);
		userNumPanel.setBounds(100, 100, 300, 100);
		userNumPanel.setBackground(Color.RED);
		v1frame.add(userNumPanel);
		
		baPanel = new JPanel(null);
		baPanel.setBounds(50, 50, 50, 50);
		v1frame.add(baPanel);
		
		back_again = new JButton("Again");
		back_again.setBounds(50, 50, 50, 50);
		baPanel.add(back_again);
		back_again.addActionListener(new backButtonEvent());
		
		n1 = new JButton("1");
		n2 = new JButton("2");
		n3 = new JButton("3");
		n4 = new JButton("4");
		n5 = new JButton("5");
		n6 = new JButton("6");
		n7 = new JButton("7");
		n8 = new JButton("8");
		n9 = new JButton("9");

		n1.setBounds(100, 300, 100, 100);
		n2.setBounds(200, 300, 100, 100);
		n3.setBounds(300, 300, 100, 100);
		n4.setBounds(100, 400, 100, 100);
		n5.setBounds(200, 400, 100, 100);
		n6.setBounds(300, 400, 100, 100);
		n7.setBounds(100, 500, 100, 100);
		n8.setBounds(200, 500, 100, 100);
		n9.setBounds(300, 500, 100, 100);
		
		n1.addActionListener(new numButtonEvent());
		
		keyPanel.add(n1);
		keyPanel.add(n2);
		keyPanel.add(n3);
		keyPanel.add(n4);
		keyPanel.add(n5);
		keyPanel.add(n6);
		keyPanel.add(n7);
		keyPanel.add(n8);
		keyPanel.add(n9);
		
	}
	
	class numButtonEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == n1) {
				
			}
		}
	}
	class backButtonEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back_again) {
				timer.interrupt();
				v1frame.setVisible(false);
				new MainFrame();
			}
		}
	}
	
	class ThreadTimer implements Runnable{
		private int seconds = 0;
		
		public void run() {
			try {
				while(true) {
					Thread.sleep(1000);
					seconds++;
					System.out.println("Elapse time: "+seconds+" seconds");
					
				}
			} catch(InterruptedException e) {
				System.out.println("Timer interrupted and reset.");
                //Thread.currentThread().interrupt(); // 스레드 인터럽트 상태를 복구
				//e.printStackTrace();
			}
		}
	}
	
}
