package Numbaseballgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.*;
import java.util.Random;

import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class PlayFrame {
	//ImageIcon backIcon = new ImageIcon("����̹��� ���");
	
	
	ImageIcon backIcon = new ImageIcon();
	
	Number_Image classimage = new Number_Image();
	
	// Frame
	JFrame level1f = new JFrame("Level1");
	//GameEndFrame endFrame; gameTime(�÷��̽ð�)������ tryGame(�õ�Ƚ��)������ �Ѱ��� ����
	
	
	// ���� �÷��� �ð� ������ ����
	//int gameTime = 0;
	// Ÿ�̸� ������ ��
	//JLabel timerLab = new JLabel(time + "SEC");

	Thread timerThr;
	
	// �����带 �����ų ����
	Boolean threadEnd = true;
	
	JPanel buttonPan = new JPanel(null) {
		public void paintComponent(Graphics g) {
			g.drawImage(backIcon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
			
		}
	};
	//JPanel recordPan = new JPanel(null);
	
	PlayPanel playPan = new PlayPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(backIcon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	};
	
	// level ���� => 2 : 2�� ���ڷ� �÷��� / 3 : 3�� ���ڷ� �÷��� / 4 : 4�� ���ڷ� �÷���
	int level_numCount;
	
	// �������� �־��� �� �� ������ �迭
	int[] randomNumber = new int[4];

	
	// �������� �־��� �� �� ������ arrayList (randomNumber)
	ArrayList<Integer> rnList = new ArrayList<>();
	
	
	// ���õ� ���ڸ� ������ �迭
	int[] saveSelectNum = new int[4];
	int[] saveStrikeBallOut = new int[3]; // [0] : Strike ���� / [1] : Ball ���� / [2] : Out ����
	
	int[][] tenSelectNum = new int[10][4];
	int[][] tenStrikeBallOut = new int[10][3];
	
	
	
	// �ʿ��� ��ư
	//JButton[] numB = new JButton[9]; // 1~9 ���� ��ư
	JButton n1,n2,n3,n4,n5,n6,n7,n8,n9;

	// n1~n9���� ������ ArrayList
	ArrayList<JButton> numbuttonList = new ArrayList<>();
	
    
	JButton numOkB = new JButton("OK"); // ������ ���� Ȯ���ϴ� ��ư (���ڸ� ��� �����ؾ� Ȱ��ȭ)
	JButton numDelB = new JButton("Delete"); // ������ ���ڸ� ����� ��ư
	
	// ��ü�� ���� �г�
	//JPanel numBPan = new JPanel(null); // ���ڹ�ư ���� �г�
	
	
	// ��Ÿ ����
	int selectState = 0; 
	// ���ڰ� �� ��� ���õ� ���������� ������ ����
	// 0 : 0�� ����, 1 : 1�� ����, 2 : 2�� ����, 3 : 3�� ����
	
	int tryGame; // ������ �õ��� Ƚ��
	
	
	// ��ư�� JLabel�� ���� �̹���������
	ImageIcon[] imgIconBN = new ImageIcon[10];
	ImageIcon[] imgIconBN2 = new ImageIcon[10];
	

	// ������ ���� ������ JLabel
	JLabel[] jlImg = new JLabel[4];
	
	
	 
	public PlayFrame() {
		// �̹��������� 1~9 ����
		for(int i=0; i<9; i++){

			imgIconBN[i] = new ImageIcon(playPan.classimage.BBNumber_Draw(0.8, false, Color.blue, Color.white, 4, i+1));
			imgIconBN2[i] = new ImageIcon(playPan.classimage.BBNumber_Draw(1.2, false, Color.red, Color.white, 5, i+1));
	   	}
		
		
		// ������ ����(�ִ� 4����) * 10�� ������ �迭�� �� ������ ������ ���(Strike Ball Out) 0���� �ʱ�ȭ
		for (int i = 0; i < 10; i++) {
			for (int j = 0 ; j < 4; j++) {
				tenSelectNum[i][j] = 0;
			}
			for (int k = 0; k < 3; k++) {

				tenStrikeBallOut[i][k] = 0;
			}
		}
		
		// Frame ����
		level1f.setSize(1000, 700);
		level1f.setLayout(null);
		
		//rnList = returnRN();
		level1f.setVisible(false);

		
		
		level1f.add(buttonPan);
		buttonPan.setBounds(0, 0, 500, 700);
		
		
		// ��� ������ Panel
		level1f.add(playPan);
		playPan.setBounds(500, 0, 500, 700);
		playPan.setBackground(Color.GREEN);
		
		
		// timer ����
		//timerLab.setSize(200, 100);
		//timerLab.setFont(new Font("Serif", Font.BOLD, 30));
		//timerLab.setBounds(50, 50, 200, 100);
		//level1f.add(timerLab);
		
		timerThr = new Thread(new TimerThread());
	
		
		/*��ư ��� �߱���*/
		
		n1 = new JButton(imgIconBN[0]);
		n2 = new JButton(imgIconBN[1]);
		n3 = new JButton(imgIconBN[2]);
		n4 = new JButton(imgIconBN[3]);
		n5 = new JButton(imgIconBN[4]);
		n6 = new JButton(imgIconBN[5]);
		n7 = new JButton(imgIconBN[6]);
		n8 = new JButton(imgIconBN[7]);
		n9 = new JButton(imgIconBN[8]);
		
		//n1.setBorderPainted(false); // �ܰ��� ���ֱ�
		
	
		numbuttonList.add(n1);
		numbuttonList.add(n2);
		numbuttonList.add(n3);
		numbuttonList.add(n4);
		numbuttonList.add(n5);
		numbuttonList.add(n6);
		numbuttonList.add(n7);
		numbuttonList.add(n8);
		numbuttonList.add(n9);
		
		for (JButton numbutton : numbuttonList) {
			numbutton.setBorderPainted(false); // �ܰ��� ���ֱ�
			numbutton.setContentAreaFilled(false); // �����ϰ�
		}
		
		
		n1.setBounds(50, 300, 100, 100);
		n2.setBounds(150, 300, 100, 100);
		n3.setBounds(250, 300, 100, 100);
		n4.setBounds(50, 400, 100, 100);
		n5.setBounds(150, 400, 100, 100);
		n6.setBounds(250, 400, 100, 100);
		n7.setBounds(50, 500, 100, 100);
		n8.setBounds(150, 500, 100, 100);
		n9.setBounds(250, 500, 100, 100);
		
		
		// numButtonEvent ���
		for (JButton numbutton : numbuttonList) {
			numbutton.addActionListener(new numButtonEvent());
		}
		
		buttonPan.add(n1);
		buttonPan.add(n2);
		buttonPan.add(n3);
		buttonPan.add(n4);
		buttonPan.add(n5);
		buttonPan.add(n6);
		buttonPan.add(n7);
		buttonPan.add(n8);
		buttonPan.add(n9);
		
		
		numOkB.setBounds(350, 300, 100, 100);
		buttonPan.add(numOkB);
		numOkB.addActionListener(new numOkBEvent());
		numOkB.setEnabled(false);
		
		
		numDelB.setBounds(350, 400, 100, 100);
		buttonPan.add(numDelB);
		numDelB.addActionListener(new numDelBEvent());
		numDelB.setEnabled(false);
	
		
		// IMG�ִ� JLabel ����
		for (int i = 0; i<4;i++) {
			jlImg[i] = new JLabel("None", JLabel.CENTER);
		}
		
		tryGame = 0;

		
		
		timerThr.start();
		
	}
	
	public void initFirst(int level) {
		
		
		// Ÿ�̸� �ʱ�ȭ
		playPan.playTime = 0;
		
		level_numCount = level;
		randomNumber = returnRN();
		
	
		for(int i = 0; i < level_numCount ; i++) {
			saveSelectNum[i] = 0;
		}
		for (int i = 0 ; i < level_numCount ; i++) {
			int jlImg_xpos = 0;
			int jlImg_ypos = 160;
			
			jlImg[i].setFont(new Font("Serif", Font.BOLD, 11));
			jlImg[i].setBackground(Color.BLUE);
			//jlImg[i].setOpaque(true);
			if (level_numCount == 2) {
				jlImg_xpos = 120 + 100*i;
				jlImg[2].setVisible(false);
				jlImg[3].setVisible(false);
			}
			if (level_numCount == 3) {
				jlImg_xpos = 90 + 100*i;
				jlImg[2].setVisible(true);
				jlImg[3].setVisible(false);
			}
			if (level_numCount == 4) {
				jlImg_xpos = 50 + 100*i;
				jlImg[2].setVisible(true);
				jlImg[3].setVisible(true);
			}
			jlImg[i].setBounds(jlImg_xpos, jlImg_ypos, 100, 100);
			jlImg[i].setOpaque(true); 
			level1f.add(jlImg[i]);
			
			
		}
		
		init();
	}

	// n�� �õ� ��, numOkB�� ������ ��ư �� ��� ���¸� �ʱ�ȭ�ϴ� �Լ�
	public void init() {
		selectState = 0;
		tryGame += 1;
		numbuttonOpen();
		numDelB.setEnabled(false);
		numOkB.setEnabled(false);
		
		for (int i = 0; i < level_numCount ; i++) {
			jlImg[i].setIcon(null);
		}
		
	}
	
	
	// ��ǻ�Ͱ� ���� �ٸ� ���� �����Ͽ� �����ϴ� �Լ�
	public int[] returnRN() {
		//ArrayList<Integer> rnList = new ArrayList<>();
		while(rnList.size()< level_numCount) {
			Random random = new Random();
			int rn = random.nextInt(8) + 1;
			if (rnList.contains(rn)) continue;
			else rnList.add(rn);
		}
		for (int i = 0; i < level_numCount; i++) {
			randomNumber[i] = rnList.get(i);
			System.out.println(randomNumber[i]);
		}
		return randomNumber;
	
	}
	
	// ��ǻ�Ϳ��� ������ ������ �μ��� ���ϴ� �Լ�
	public void inputResult() {
		int countS = 0;
		int countB = 0; 
		int countO = 0;
		
		// Strike 
		for (int i = 0; i < level_numCount ; i++) {
			for (int j = 0; j < level_numCount; j++) {
				if(randomNumber[i] == saveSelectNum[i] && i == j) {
					countS +=1;
				}
			}
		}
		saveStrikeBallOut[0] = countS;
		
		
		// Ball
		for (int i = 0; i < level_numCount ; i++) {
			for (int j = 0; j < level_numCount ; j++) {
				if(randomNumber[i] == saveSelectNum[j] && i != j) {
					//System.out.println("i, j : " + i + ", " + j);
					countB +=1;
				}
			}
		}
		saveStrikeBallOut[1]= countB;
		
		
		// Out
		for (int i = 0; i < level_numCount ; i++) {
			for (int j = 0; j < level_numCount; j++) {
				if (randomNumber[i] == saveSelectNum[j]) break;
				if (j == level_numCount - 1) countO += 1;
			}
		}
		saveStrikeBallOut[2]= countO;
		
	}
	
	// �� ����� ȭ�鿡 ����ϴ� �Լ� // ����
	public void printResult() {
		System.out.print(tryGame + "ȸ�� | ");
		for (int i = 0; i < level_numCount ; i++) {
			System.out.print(saveSelectNum[i] + " ");
		}
		System.out.print("| " + saveStrikeBallOut[0] + "STRIKE " + saveStrikeBallOut[1] + "BALL " + saveStrikeBallOut[2] + "OUT");
		System.out.println();
	}
	
		
	// n1 ~ n9 ��ư�� ��� ��Ȱ��ȭ�ϴ� �Լ�
	public void numbuttonClose() {
		for (JButton numbutton : numbuttonList) {
			numbutton.setEnabled(false);
			numOkBOpen();
		}
	}
	
	// numOkB ��ư�� Ȱ��ȭ�ϴ� �Լ�
	public void numOkBOpen() {
		numOkB.setEnabled(true);
	}
	
	// numDelB ��ư�� ������ �� ��Ȱ��ȭ �� ��ư�� �ٽ� Ȱ��ȭ�ϴ� �Լ�
	public void numbuttonOpen() {
		
		if (selectState == 0) {
			for (JButton numbutton : numbuttonList) {
				numbutton.setEnabled(true);
			}
			for (int i = 0; i < 4; i++) {
				saveSelectNum[i] = 0;
			}
		}
		
		if (selectState == 1) {
			for (JButton numbutton1 : numbuttonList) {
				numbutton1.setEnabled(true);
				if (saveSelectNum[0] == 1) {
					n1.setEnabled(false);
				}
				else if (saveSelectNum[0] == 2) {
					n2.setEnabled(false);
				}
				else if (saveSelectNum[0] == 3) {
					n3.setEnabled(false);
				}
				else if (saveSelectNum[0] == 4) {
					n4.setEnabled(false);
				}
				else if (saveSelectNum[0] == 5) {
					n5.setEnabled(false);
				}
				else if (saveSelectNum[0] == 6) {
					n6.setEnabled(false);
				}
				else if (saveSelectNum[0] == 7) {
					n7.setEnabled(false);
				}
				else if (saveSelectNum[0] == 8) {
					n8.setEnabled(false);
				}
				else if (saveSelectNum[0] == 9) {
					n9.setEnabled(false);
				}
				
			}
			saveSelectNum[1] = 0;
			//System.out.println("saveSelectNum[0] : " + saveSelectNum[0]);
			//System.out.println("saveSelectNum[1] : " + saveSelectNum[1]);
		}

		
	}
	// n1~n9 Ŭ������ �� ������ ���ڸ� ȭ�鿡 ����ϴ� �̺�Ʈ
	
	
	
	
	
	
	// �̺�Ʈ �Լ�
	class numButtonEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			numDelB.setEnabled(true);
			if (e.getSource() == n1) {
				//System.out.println("Before selectState : " + selectState + "�� ����");
				saveSelectNum[selectState] = 1;
				
				//System.out.println("selected 1");
				jlImg[selectState].setIcon(imgIconBN2[0]);
				selectState += 1;
				//System.out.println("Now selectState : " + selectState + "�� ����");
				n1.setEnabled(false);
				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
			if (e.getSource() == n2) {
				//System.out.println("selected 2");
				saveSelectNum[selectState] = 2;
				jlImg[selectState].setIcon(imgIconBN2[1]);
				selectState += 1;
				//System.out.println("selectState : " + selectState);
				n2.setEnabled(false);

				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
			if (e.getSource() == n3) {
				//System.out.println("selected 3");
				saveSelectNum[selectState] = 3;
				jlImg[selectState].setIcon(imgIconBN2[2]);
				selectState += 1;
				//System.out.println("selectState : " + selectState);
				n3.setEnabled(false);

				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
			if (e.getSource() == n4) {
				//System.out.println("selected 4");
				saveSelectNum[selectState] = 4;
				jlImg[selectState].setIcon(imgIconBN2[3]);
				selectState += 1;
				//System.out.println("selectState : " + selectState);
				n4.setEnabled(false);

				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
			if (e.getSource() == n5) {
				//System.out.println("selected 5");
				saveSelectNum[selectState] = 5;
				jlImg[selectState].setIcon(imgIconBN2[4]);
				selectState += 1;
				//System.out.println("selectState : " + selectState);
				n5.setEnabled(false);

				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
			if (e.getSource() == n6) {
				//System.out.println("selected 6");
				saveSelectNum[selectState] = 6;
				jlImg[selectState].setIcon(imgIconBN2[5]);
				selectState += 1;
				//System.out.println("selectState : " + selectState);
				n6.setEnabled(false);

				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
			if (e.getSource() == n7) {
				System.out.println("selected 7");
				saveSelectNum[selectState] = 7;
				jlImg[selectState].setIcon(imgIconBN2[6]);
				selectState += 1;
				System.out.println("selectState : " + selectState);
				n7.setEnabled(false);

				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
			if (e.getSource() == n8) {
				System.out.println("selected 8");
				saveSelectNum[selectState] = 8;
				jlImg[selectState].setIcon(imgIconBN2[7]);
				selectState += 1;
				System.out.println("selectState : " + selectState);
				n8.setEnabled(false);

				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
			if (e.getSource() == n9) {
				System.out.println("selected 9");
				saveSelectNum[selectState] = 9;
				jlImg[selectState].setIcon(imgIconBN2[8]);
				selectState += 1;
				System.out.println("selectState : " + selectState);
				n9.setEnabled(false);

				if (selectState == level_numCount) {
					numbuttonClose();
				}
			}
				
		}
	}
	
	
	// numDelB�� Ŭ������ �� ���õ� ���ڸ� ȭ�鿡�� ����� �̺�Ʈ
	class numDelBEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == numDelB) {
				System.out.println("Delete");
				selectState -= 1;
				jlImg[selectState].setIcon(null);
				
				// numDelB�� ������ �� numOkB�� �ٽ� ��Ȱ��ȭ
				numOkB.setEnabled(false);
				
				numbuttonOpen();
				System.out.println("After Del : selectState : " + selectState);
			}
		}
	}
	
	// ���ڸ� ��� �������� �� ������ ���ڸ� Ȯ���ϰ� �˻��ϴ� �̺�Ʈ
	class numOkBEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == numOkB) {
				//System.out.println("Ok");
				//System.out.println("saveSelectNum[0] : " + saveSelectNum[0]);
				//System.out.println("saveSelectNum[1] : " + saveSelectNum[1]);
				
				// ��ǻ�Ϳ��� ������ ������ �μ��� ���ϴ� �Լ�
				inputResult();
				printResult();
				
				// �õ�Ƚ��, ������ ����, ��Ʈ����ũ, ��, �ƿ� ����
				//playPan.inputTryCount(tryGame);
				//playPan.inputSelectNum(saveSelectNum);
				//playPan.inputSBO(saveStrikeBallOut);
				
				for(int i = 0 ; i < 4; i++) {
					tenSelectNum[tryGame-1][i] = saveSelectNum[i];
					//System.out.println("ten1 : " + tenSelectNum[tryGame-1][i]);
				}
				for(int i = 0; i < 3; i++) {
					tenStrikeBallOut[tryGame-1][i] = saveStrikeBallOut[i];
					//System.out.println("tenSBO : " + tenStrikeBallOut[tryGame-1][i]);
				}
				
				playPan.drawPlayPanel(tryGame, tenSelectNum, tenStrikeBallOut);
				playPan.repaint();
				
				// ��� Strike�� �Ǿ��� �� ����
				if (tenStrikeBallOut[tryGame-1][0] == level_numCount) {
					////GameEndFrame endFrame = new GameEndFrame();
					//endFrame.setVisible(true);
					// endFrame�� �õ� Ƚ���� �ð� ����
					System.out.println("GameClear");
					
					numOkB.setEnabled(false);
					numDelB.setEnabled(false);
					
					threadEnd = false;
				}
				// 10�� �õ����� �� ����
				else if (tryGame == 10) {
					//GameOver
					//endFrame.setVisible(true);
					// endFrame�� �õ� Ƚ���� �ð� ����
					System.out.println("GameOver");

					numOkB.setEnabled(false);
					numDelB.setEnabled(false);
					
					threadEnd = false;
					
				}
				// Ʋ���� �� �ٽ� �õ�
				else {
					init();
				}
				
			}
		}
	}
	
	class TimerThread implements Runnable{
		public void run() {
			try {
				while(threadEnd) {
					Thread.sleep(1000);
					//gameTime++;
					playPan.drawTimer();
					playPan.playTime++;
					playPan.repaint();
				}
			} catch(InterruptedException e) {
				System.out.println("Timer interrupted and reset.");
                //Thread.currentThread().interrupt(); // ������ ���ͷ�Ʈ ���¸� ����
				//e.printStackTrace();
			}
		}
	}


}
