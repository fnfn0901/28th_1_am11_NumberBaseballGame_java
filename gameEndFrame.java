package Numbaseballgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameEndFrame extends JDialog {
  //재시작시 이전프레임으로 돌아갈 수 있도록 프레임 저장
  //private JFrame previousFrame;
  
	JPanel panel;
  
  String userID;
  int passedTime;
  int tryNumber;
  int best_passedTime;
  int clearOrOver;
  JButton restartButton;
  JButton levelButton;
  JButton endButton;
  
  JLabel clearOrOverLabel;
  JLabel userIDLabel;
  JLabel passedTimeLabel;
  JLabel tryNumberLabel;
  JLabel bestLabel;
  int restartB = 0; // 1일 때 버튼이 눌린 것
  int levelB = 0;
  int endB = 0;
  static ImageIcon background = new ImageIcon("C:\\Users\\진은빈\\eclipse-workspace\\BaseBallGame_Practice\\img\\backImage4.png");
  
  
  public gameEndFrame(JFrame previousFrame){
	  /*
      //this.previousFrame = previousFrame;

      //setTitle("게임 결과");
	  super(previousFrame, "게임 결과", true);
	  setSize(1000, 700);
  	
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      // 전체 패널을 GridLayout으로 설정
      JPanel mainPanel = new JPanel(new GridLayout(2, 1));

      // 게임 정보를 나타내는 패널
      JPanel gameInfoPanel = new JPanel(new GridLayout(5, 1));
      
      
      System.out.println("gameEndFrame");
      System.out.println(tryNumber);
      System.out.println(passedTime);
      
      
      //게임정보 라벨들 생성
      clearOrOverLabel= new JLabel();
      userIDLabel = new JLabel();
      passedTimeLabel = new JLabel();
      tryNumberLabel = new JLabel();
      bestLabel = new JLabel();
      

      //라벨 가운데 정렬
      clearOrOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
      userIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
      passedTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
      tryNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
      bestLabel.setHorizontalAlignment(SwingConstants.CENTER);
      
      //게임정보 나타내기
      gameInfoPanel.add(clearOrOverLabel);
      gameInfoPanel.add(userIDLabel);
      gameInfoPanel.add(passedTimeLabel);
      gameInfoPanel.add(tryNumberLabel);
      gameInfoPanel.add(bestLabel);

      //버튼을 가운데에 배치하는 패널
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

      //버튼 생성
      restartButton = new JButton("재시작");
      levelButton = new JButton("레벨 선택");
      endButton = new JButton("종료");

      //버튼 크기 조정
      Dimension buttonSize = new Dimension(100, 70);
      restartButton.setPreferredSize(buttonSize);
      levelButton.setPreferredSize(buttonSize);
      endButton.setPreferredSize(buttonSize);

      //버튼 추가
      buttonPanel.add(restartButton);
      buttonPanel.add(levelButton);
      buttonPanel.add(endButton);

      //게임 정보 패널과 버튼 패널을 전체 패널에 추가
      mainPanel.add(gameInfoPanel);
      mainPanel.add(buttonPanel);

      //패널 프레임에 추가
      add(mainPanel);
      */
	  super(previousFrame, "게임 결과", true);
	  setSize(1000, 700);
	        
	  panel = new JPanel(null) {
	  public void paintComponent(Graphics g) {
	       g.drawImage(background.getImage(), 0, 0, null);
	       setOpaque(false);
	       super.paintComponent(g);
	    }
	  };
	  add(panel);
	  panel.setSize(1000, 700);
	      
	  setLocationRelativeTo(null);

	   
	  System.out.println("gameEndFrame");
	  System.out.println(tryNumber);
	  System.out.println(passedTime);
	      
	      
	  //게임정보 라벨들 생성
	  clearOrOverLabel= new JLabel();
	  userIDLabel = new JLabel();
	  passedTimeLabel = new JLabel();
	  tryNumberLabel = new JLabel();
	  bestLabel = new JLabel();
	      
	  clearOrOverLabel.setBounds(400,13,200,50);
	  userIDLabel.setBounds(400,70,200,100);
	  passedTimeLabel.setBounds(400,125,200,100);
	  tryNumberLabel.setBounds(400,180,200,100);
	  bestLabel.setBounds(400,235,200,100);
	      
	  clearOrOverLabel.setFont(new Font("나눔고딕", Font.BOLD, 30));
	  userIDLabel.setFont(new Font("나눔고딕", Font.PLAIN, 20));
	  passedTimeLabel.setFont(new Font("나눔고딕", Font.PLAIN, 20));
	  tryNumberLabel.setFont(new Font("나눔고딕", Font.PLAIN, 20));
	  bestLabel.setFont(new Font("나눔고딕", Font.PLAIN, 20));

	  //라벨 가운데 정렬
	  clearOrOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
	  userIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
	  passedTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
	  tryNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
	  bestLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    
	  //게임정보 나타내기
	  panel.add(clearOrOverLabel);
	  panel.add(userIDLabel);
	  panel.add(passedTimeLabel);
	  panel.add(tryNumberLabel);
	  panel.add(bestLabel);
	     

	  //버튼을 가운데에 배치하는 패널
	  //JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      //버튼 생성
	  restartButton = new JButton("재시작");
	  levelButton = new JButton("레벨 선택");
	  endButton = new JButton("종료");

	  restartButton.setBounds(330, 350, 100, 70);
	  levelButton.setBounds(450, 350, 100, 70);
	  endButton.setBounds(570, 350, 100, 70);
	      
	  //버튼 크기 조정
	  // Dimension buttonSize = new Dimension(100, 70);
	  // restartButton.setPreferredSize(buttonSize);
	  // levelButton.setPreferredSize(buttonSize);
	  // endButton.setPreferredSize(buttonSize);

	  //버튼 추가
	  panel.add(restartButton);
	  //panel.add(levelButton);
	  panel.add(endButton);
      
      

      //재시작 버튼
      restartButton.addActionListener(new ActionListener(){
    	  @Override
          public void actionPerformed(ActionEvent e){
              //이전프레임 보여주고 현재 프레임 숨김
              //previousFrame.setVisible(true);
          	restartB = 1;
          	
          	setVisible(false);
          	//previousFrame.initFirst();
              //previousFrame.initFirst(previousFrame.level_numCount);
              
          }
      });

      //레벨 선택 버튼
      levelButton.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
        	  restartB = 2;
              //levelFrame.java 실행
              //new levelFrame().setVisible(true);
              setVisible(false);
          }
      });

      //종료 버튼
      endButton.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              //종료
        	  endB = 1;
              System.exit(0);
          }
      });
      
  }

  //최고기록 업데이트
  private void updateBestTime(){
      if(best_passedTime==0||passedTime<best_passedTime){
          best_passedTime=passedTime;

          //라벨 변경
          //JLabel bestJLabel=(JLabel)((JPanel)getContentPane().getComponent(0)).getComponent(4);
          //bestJLabel.setText("최고 기록: "+best_passedTime);
      }
  }
  
  public void textPrint() {
      clearOrOverLabel.setText((clearOrOver==0? "Game Over" : "Game Clear"));
      userIDLabel.setText("유저 ID: "+userID);
      passedTimeLabel.setText("게임 시간: "+ passedTime + "초");
      tryNumberLabel.setText("시도 횟수: "+tryNumber);
      bestLabel.setText("최고 기록: "+ best_passedTime);
  }

}