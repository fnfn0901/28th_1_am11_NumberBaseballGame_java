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
	//ImageIcon backIcon = new ImageIcon("background.png");

	//gameEndFrame endFrame;
	//SnowflakeBB_Image sfimage = new SnowflakeBB_Image();
	
	static ImageIcon backIcon = new ImageIcon();
	
	static Number_Image classimage = new Number_Image();
	
	// Frame
	static JFrame level1f = new JFrame("Level1");
	static gameEndFrame endFrame; ///gameTime(플레이시간)변수와 tryGame(시도횟수)변수를 넘겨줄 예정
	

	
	
	static JButton back = new JButton("Back");
	

	static Thread timerThr;
	
	// 쓰레드를 종료시킬 변수
	static Boolean threadEnd = true;
	
	static JPanel buttonPan = new JPanel(null) {
		public void paintComponent(Graphics g) {
			g.drawImage(backIcon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
			
		}
	};
	//JPanel recordPan = new JPanel(null);
	
	static PlayPanel playPan = new PlayPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(backIcon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	};
	
	// level 변수 => 2 : 2개 숫자로 플레이 / 3 : 3개 숫자로 플레이 / 4 : 4개 숫자로 플레이
	static int level_numCount;
	
	// 랜덤으로 주어질 두 수 저장할 배열
	static int[] randomNumber = new int[4];

	
	// 랜덤으로 주어질 두 수 저장할 arrayList (randomNumber)
	static ArrayList<Integer> rnList = new ArrayList<>();
	
	
	// 선택된 숫자를 저장할 배열
	static int[] saveSelectNum = new int[4];
	static int[] saveStrikeBallOut = new int[3]; // [0] : Strike 개수 / [1] : Ball 개수 / [2] : Out 개수
	
	static int[][] tenSelectNum = new int[10][4];
	static int[][] tenStrikeBallOut = new int[10][3];
	
	
	
	// 필요한 버튼
	//JButton[] numB = new JButton[9]; // 1~9 숫자 버튼
	static JButton n1,n2,n3,n4,n5,n6,n7,n8,n9;
	// n1~n9까지 저장할 ArrayList
	static ArrayList<JButton> numbuttonList = new ArrayList<>();
	
    
	static JButton numOkB = new JButton("OK"); // 선택한 숫자 확정하는 버튼 (숫자를 모두 선택해야 활성화)
	static JButton numDelB = new JButton("Delete"); // 선택한 숫자를 지우는 버튼
	
	
	
	
	// 기타 변수
	static int selectState = 0; 
	// 숫자가 총 몇개가 선택된 상태인지를 저장할 변수
	// 0 : 0개 선택, 1 : 1개 선택, 2 : 2개 선택, 3 : 3개 선택
	
	static int tryGame; // 게임을 시도한 횟수
	
	
	//Image[] imgBaseballNum = new Image[10]; 
	static ImageIcon[] imgIconBN = new ImageIcon[10];
	static ImageIcon[] imgIconBN2 = new ImageIcon[10];
	
	
	// 이미지
	// 생성자 인수 : 현재클래스명.class.getResource("/패키지명/이미지폴더명/이미지파일명")
	
	
	static JLabel[] jlImg = new JLabel[4];
	
	
	//=> 수정 : JLabel을 배열로 선언해서 인덱스번호를 selectState로 한 뒤 img 넣기
	//jl_n1.setBounds();
	
	
	 
	public PlayFrame() {
		//endFrame = new gameEndFrame(level1f);
		
		
		//endFrame = new gameEndFrame(level1f);
		//endFrame.setVisible(false);
		
		
		
		for(int i=0; i<9; i++){
			//imgBaseballNum[i] = playPan.classimage.BBNumber_Draw(0.8, false, Color.blue, Color.white, 2, i);
			imgIconBN[i] = new ImageIcon(playPan.classimage.BBNumber_Draw(0.8, false, Color.blue, Color.white, 4, i+1));
			imgIconBN2[i] = new ImageIcon(playPan.classimage.BBNumber_Draw(1.2, false, Color.red, Color.white, 5, i+1));
	   	}
		
		
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0 ; j < 4; j++) {
				tenSelectNum[i][j] = 0;
			}
			for (int k = 0; k < 3; k++) {

				tenStrikeBallOut[i][k] = 0;
			}
		}
		
		// Frame 설정
		level1f.setSize(1000, 700);
		level1f.setLayout(null);
		
		//rnList = returnRN();
		level1f.setVisible(false);
		level1f.setLocationRelativeTo(null);
		
		
		// saveSelectNum 배열 초기화 - 값이 0이면 아무것도 선택되지 않은 상태
		
		
		level1f.add(buttonPan);
		buttonPan.setBounds(0, 0, 500, 700);
		
		
		//GameEndFrame 생성
		//endFrame = new gameEndFrame(level1f);
		
		
		// 기록 보여줄 Panel
		level1f.add(playPan);
		playPan.setBounds(500, 0, 500, 700);
		playPan.setBackground(Color.GREEN);
		
		
		// timer 설정
		//timerLab.setSize(200, 100);
		//timerLab.setFont(new Font("Serif", Font.BOLD, 30));
		//timerLab.setBounds(50, 50, 200, 100);
		//level1f.add(timerLab);
		
		timerThr = new Thread(new TimerThread());
	
		
		/*버튼 모양 야구공*/
		
		n1 = new JButton(imgIconBN[0]);
		n2 = new JButton(imgIconBN[1]);
		n3 = new JButton(imgIconBN[2]);
		n4 = new JButton(imgIconBN[3]);
		n5 = new JButton(imgIconBN[4]);
		n6 = new JButton(imgIconBN[5]);
		n7 = new JButton(imgIconBN[6]);
		n8 = new JButton(imgIconBN[7]);
		n9 = new JButton(imgIconBN[8]);
		
		//n1.setBorderPainted(false); // 외곽선 없애기
		
	
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
			numbutton.setBorderPainted(false); // 외곽선 없애기
			numbutton.setContentAreaFilled(false); // 투명하게
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
		
		
		// numButtonEvent 등록
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
	
		
		// IMG넣는 JLabel 생성
		for (int i = 0; i<4;i++) {
			jlImg[i] = new JLabel("None", JLabel.CENTER);
		}
		
		tryGame = 0;
		//initFirst(3);
		
		
		timerThr.start();
		
	}
	
	static public void initFirst(int level) {
		// 타이머 시작
		//timerThr.start();
		//gameTime = 0;
		
		// 타이머 초기화
		playPan.playTime = 0;
		//timerThr.start();
		
		level_numCount = level;
		randomNumber = returnRN();
		
		tryGame = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0 ; j < 4; j++) {
				tenSelectNum[i][j] = 0;
			}
			for (int k = 0; k < 3; k++) {

				tenStrikeBallOut[i][k] = 0;
			}
		}
		//playPan.drawPlayPanel(tryGame, tenSelectNum, tenStrikeBallOut);
		//playPan.repaint();
		
		
		// 추후 수정
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
	// n차 시도 후, numOkB을 누르면 벼튼 및 출력 상태를 초기화하는 함수
	static public void init() {
		selectState = 0;
		tryGame += 1;
		numbuttonOpen();
		numDelB.setEnabled(false);
		numOkB.setEnabled(false);
		
		for (int i = 0; i < level_numCount ; i++) {
			jlImg[i].setIcon(null);
		}
		
	}
	
	
	// 컴퓨터가 서로 다른 수를 지정하여 리턴하는 함수
	static public int[] returnRN() {
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
	
	// 컴퓨터에서 지정한 랜덤한 두수와 비교하는 함수
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
	
	// 비교 결과를 화면에 출력하는 함수 // 수정
	public void printResult() {
		System.out.print(tryGame + "회차 | ");
		for (int i = 0; i < level_numCount ; i++) {
			System.out.print(saveSelectNum[i] + " ");
		}
		System.out.print("| " + saveStrikeBallOut[0] + "STRIKE " + saveStrikeBallOut[1] + "BALL " + saveStrikeBallOut[2] + "OUT");
		System.out.println();
	}
	
		
	// n1 ~ n9 버튼을 모두 비활성화하는 함수
	public void numbuttonClose() {
		for (JButton numbutton : numbuttonList) {
			numbutton.setEnabled(false);
			numOkBOpen();
		}
	}
	
	// numOkB 버튼을 활성화하는 함수
	public void numOkBOpen() {
		numOkB.setEnabled(true);
	}
	
	// numDelB 버튼을 선택할 때 비활성화 된 버튼을 다시 활성화하는 함수
	static public void numbuttonOpen() {
		
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
	// n1~n9 클릭했을 때 선택한 숫자를 화면에 출력하는 이벤트
	
	
	
	
	
	
	// 이벤트 함수
	class numButtonEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			numDelB.setEnabled(true);
			if (e.getSource() == n1) {
				//System.out.println("Before selectState : " + selectState + "개 선택");
				saveSelectNum[selectState] = 1;
				
				//System.out.println("selected 1");
				jlImg[selectState].setIcon(imgIconBN2[0]);
				selectState += 1;
				//System.out.println("Now selectState : " + selectState + "개 선택");
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
	
	
	// numDelB를 클릭했을 때 선택된 숫자를 화면에서 지우는 이벤트
	class numDelBEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == numDelB) {
				System.out.println("Delete");
				selectState -= 1;
				jlImg[selectState].setIcon(null);
				
				// numDelB를 눌렀을 때 numOkB를 다시 비활성화
				numOkB.setEnabled(false);
				
				numbuttonOpen();
				System.out.println("After Del : selectState : " + selectState);
			}
		}
	}
	
	// 숫자를 모두 선택했을 때 선택한 숫자를 확정하고 검사하는 이벤트
	class numOkBEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == numOkB) {
				//System.out.println("Ok");
				//System.out.println("saveSelectNum[0] : " + saveSelectNum[0]);
				//System.out.println("saveSelectNum[1] : " + saveSelectNum[1]);
				
				// 컴퓨터에서 지정한 랜덤한 두수와 비교하는 함수
				inputResult();
				printResult();
				
				// 시도횟수, 선택한 숫자, 스트라이크, 볼, 아웃 여부
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
				
				
				if (tenStrikeBallOut[tryGame-1][0] == level_numCount) {
					////GameEndFrame endFrame = new GameEndFrame();
					//endFrame.setVisible(true);
					// endFrame에 시도 횟수와 시간 전달
					//gameEndFrame.setVisible(true);
					System.out.println("time : " + playPan.playTime);
					System.out.println(tryGame);
					System.out.println("GameClear");
					
					numOkB.setEnabled(false);
					numDelB.setEnabled(false);
					
					endFrame.tryNumber = tryGame;
					int time1 = playPan.playTime;
					endFrame.passedTime = time1;
					
					endFrame.clearOrOver = 1; // game clear
					
					
					endFrame = new gameEndFrame(level1f);
					endFrame.setVisible(true);
					
					
					if(endFrame.restartB == 1) {
						System.out.println("restartB 눌림");
						playPan.g2D_img.clearRect(0, 0, 500, 600);
						playPan.repaint();
						initFirst(level_numCount);
						
						
					}
					else if(endFrame.endB == 1){
						System.out.print("endB 눌림");
						threadEnd = false;
					}
					
				}
				else if (tryGame == 10) {
					//GameOver
					//endFrame.setVisible(true);
					// endFrame에 시도 횟수와 시간 전달
					System.out.println("GameOver");

					numOkB.setEnabled(false);
					numDelB.setEnabled(false);
					
					endFrame.tryNumber = tryGame;
					
					int time1 = playPan.playTime;
					endFrame.passedTime = time1;
					
					endFrame.clearOrOver = 0; // game Over
					
					//endFrame.enputResult(playPan.playTime, tryGame);
					
					
					endFrame = new gameEndFrame(level1f);
					endFrame.setVisible(true);
					
					if(endFrame.restartB == 1) {
						System.out.println("restartB 눌림");
						playPan.g2D_img.clearRect(0, 0, 500, 600);
						playPan.repaint();
						initFirst(level_numCount);
						
						
					}
					else if(endFrame.endB == 1){
						System.out.print("endB 눌림");
						threadEnd = false;
					}
					
					threadEnd = false;
					
				}
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
                //Thread.currentThread().interrupt(); // 스레드 인터럽트 상태를 복구
				//e.printStackTrace();
			}
		}
	}


}
