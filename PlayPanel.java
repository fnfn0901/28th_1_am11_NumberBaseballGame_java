package Numbaseballgame;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.io.File;
import java.io.IOException;
 
class PlayPanel extends JPanel{
	
	Image record;
	
	// PlayFrame에서 받아올 플레이 시간
	int playTime;
	Color colorTrans = new Color(255, 0, 0, 0);
	
	int tryCount = 0;
	int[][] selectNum = new int[10][4];
	int[][] saveSBO = new int[10][3];
	Image[] imgArray = new Image[10];
	Image[] imgArray_SBO = new Image[10];
	Image[] imgArray_Try = new Image[10];
	Image[] imgArray_Timer = new Image[10];
	
	
	Graphics2D g2D_img;
	Graphics2D g2D_time;
	
	BufferedImage bufRecord = new BufferedImage(500, 600, BufferedImage.TYPE_INT_ARGB);
	BufferedImage bufTimer = new BufferedImage(160, 60, BufferedImage.TYPE_INT_ARGB);


	

	ImageIcon iistrikeBall = new ImageIcon("strikeBall.png");
	ImageIcon iiballBall = new ImageIcon("ballBall.png");
	ImageIcon iioutBall = new ImageIcon("outBall.png");
	
	Image istrikeBall = iistrikeBall.getImage();
	Image iballBall = iiballBall.getImage();
	Image ioutBall = iioutBall.getImage();
	
	
	//Path이미지
	Number_Image classimage = new Number_Image();
	
		
	public PlayPanel() {
  
	    g2D_img = bufRecord.createGraphics();
	    g2D_time = bufTimer.createGraphics(); // 그래픽 객체와 버퍼이미지 연결 // 그래픽객체 time에 그리면 bufTimer(버퍼이미지)에 그려지는 것
	   
	    for(int i=0; i<10; i++){
	    	imgArray[i] = classimage.Number_Draw(0.8, false, Color.blue, Color.white, 2, i);
	    	imgArray_SBO[i] = classimage.Number_Draw(0.8, false, Color.red, Color.white, 2, i);
	    	imgArray_Try[i] = classimage.Number_Draw(0.8, false, Color.BLACK, Color.white, 2, i);
	    	imgArray_Timer[i] = classimage.Number_Draw(1.0, false, Color.BLACK, Color.white, 3, i);
	   	}
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D drawRecord = (Graphics2D) g; // 그래픽 객체
		
		drawRecord.drawImage(bufRecord, 0, 90, null);
		
		drawRecord.drawImage(bufTimer, 0, 10, null);
	}
	
	// 플레이시간 화면에 그리기 위한 함수
	public void drawTimer() {
		
		
		//g2D_time
		int numDig = 0; // 숫자 자릿수
		int[] numArray = new int[4]; // 각 자릿수의 숫자 저장할 배열
		int temp = playTime;
		
		
		
		numArray[0] = (int) (temp / 1000);
		temp = temp - numArray[0]*1000;
		numArray[1] = (int) (temp/100);
		temp = temp - numArray[1]*100;
		numArray[2] = (int) (temp/10);
		numArray[3] = temp - numArray[2]*10;
		
		
		
		// 버퍼 이미지 지움
		g2D_time.setBackground(colorTrans);
		g2D_time.clearRect(0, 0, 160, 60);
		
		
		for (int i=0; i < 4;i++) {
			g2D_time.drawImage(imgArray_Timer[numArray[i]], i*40, 0, this);
		}
		
	}
	
	
	public void drawPlayPanel(int tryCount, int[][] selectNum, int[][] saveSBO) {
	    this.tryCount = tryCount;
	    
	    
	    this.selectNum = selectNum;
	    this.saveSBO = saveSBO;
	    System.out.println("YES");
	    
	    //버퍼이미지 지움
	    g2D_img.setBackground(colorTrans);
	    g2D_img.clearRect(0, 0, 500, 600);
	    
	    
	    g2D_img.drawImage(istrikeBall, 300, 0, this);
	    g2D_img.drawImage(iballBall, 350, 0, this);
	    g2D_img.drawImage(ioutBall, 400, 0, this);
	    
	    
	    for (int i = 0; i < tryCount; i++) {
	    	if (i == 9) {
	    		g2D_img.drawImage(imgArray_Try[1], 0, 60 + (i*50), this);
	    		g2D_img.drawImage(imgArray_Try[0], 40, 60 + (i*50), this);
	    	}
	    	else g2D_img.drawImage(imgArray_Try[i+1], 40, 60 + (i*50), this);
	    	if (selectNum[i][0] != 0)
	            //g2DImg.drawString(String.valueOf(selectNum[i][0]), 100, 150 + (i*50));
	        	g2D_img.drawImage(imgArray[selectNum[i][0]], 100, 60 + (i*50), this);
	        if (selectNum[i][1] != 0)
	        	//g2DImg.drawString(String.valueOf(selectNum[i][1]), 150, 150 + (i*50));
	        	g2D_img.drawImage(imgArray[selectNum[i][1]], 140, 60 + (i*50), this);
	        if (selectNum[i][2] != 0)
	        	//g2DImg.drawString(String.valueOf(selectNum[i][2]), 200, 150 + (i*50));
        		g2D_img.drawImage(imgArray[selectNum[i][2]], 180, 60 + (i*50), this);
	        if (selectNum[i][3] != 0)
	        	//g2DImg.drawString(String.valueOf(selectNum[i][3]), 250, 150 + (i*50));
	        	g2D_img.drawImage(imgArray[selectNum[i][3]], 220, 60 + (i*50), this);

	        
	        g2D_img.drawImage(imgArray_SBO[saveSBO[i][0]], 310, 60 + (i*50), this);
	        g2D_img.drawImage(imgArray_SBO[saveSBO[i][1]], 360, 60 + (i*50), this);
	        g2D_img.drawImage(imgArray_SBO[saveSBO[i][2]], 410, 60 + (i*50), this);
	    }
	    
	    
	    
	}
}

