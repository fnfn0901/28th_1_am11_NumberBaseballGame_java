package Numbaseballgame;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

class Number_Image{
	
	int image_width=40, image_height=60;
	int image_width2=80, image_height2=80;

	GeneralPath[] path_ = new GeneralPath[11];
	BufferedImage buf_image;
	BufferedImage buf_image2;

	Color co_bbbg = Color.white;
	Color co_bbout = Color.black;
	Color co_bbstring = new Color(128, 0, 0);
	int s_bbout = 1;
	int s_bbstring = 2;



	Number_Image(){
		for(int i=0; i<10; i++) path_[i] = new GeneralPath(GeneralPath.WIND_EVEN_ODD);;
	}
	
	public Image Number_Draw(double ds_sc, boolean ds_rep, Color co_out, Color co_in, int s_boder, int image_num){
		double ds_minus=1.0, ds_xmax;
		int dimage_width=(int)(image_width*ds_sc);
		int dimage_height=(int)(image_height*ds_sc);
		buf_image = new BufferedImage(dimage_width, dimage_height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d_image = buf_image.createGraphics();
		for(int i=0; i<10; i++) path_[i].reset();
		if(ds_rep){ds_minus=-1.0; ds_xmax=(double)dimage_width;}
		else {ds_minus=1.0; ds_xmax=0.0;}
		
		// path_[0]  
		path_[0].moveTo((ds_minus*3.100+ds_xmax)*ds_sc, 30.200*ds_sc);
		path_[0].quadTo((ds_minus*3.300+ds_xmax)*ds_sc, 3.500*ds_sc, (ds_minus*20.200+ds_xmax)*ds_sc, 3.700*ds_sc);
		path_[0].quadTo((ds_minus*38.000+ds_xmax)*ds_sc, 4.100*ds_sc, (ds_minus*37.600+ds_xmax)*ds_sc, 30.500*ds_sc);
		path_[0].quadTo((ds_minus*38.100+ds_xmax)*ds_sc, 57.600*ds_sc, (ds_minus*20.300+ds_xmax)*ds_sc, 56.800*ds_sc);
		path_[0].quadTo((ds_minus*1.700+ds_xmax)*ds_sc, 55.500*ds_sc, (ds_minus*3.100+ds_xmax)*ds_sc, 30.200*ds_sc);
		path_[0].moveTo((ds_minus*19.900+ds_xmax)*ds_sc, 12.600*ds_sc);
		path_[0].quadTo((ds_minus*11.800+ds_xmax)*ds_sc, 13.000*ds_sc, (ds_minus*12.000+ds_xmax)*ds_sc, 30.200*ds_sc);
		path_[0].quadTo((ds_minus*11.900+ds_xmax)*ds_sc, 47.200*ds_sc, (ds_minus*20.200+ds_xmax)*ds_sc, 48.000*ds_sc);
		path_[0].quadTo((ds_minus*28.600+ds_xmax)*ds_sc, 47.000*ds_sc, (ds_minus*28.300+ds_xmax)*ds_sc, 30.300*ds_sc);
		path_[0].quadTo((ds_minus*27.900+ds_xmax)*ds_sc, 11.700*ds_sc, (ds_minus*19.900+ds_xmax)*ds_sc, 12.600*ds_sc);
		
		// path_[1]  
		path_[1].moveTo((ds_minus*14.500+ds_xmax)*ds_sc, 19.500*ds_sc);
		path_[1].lineTo((ds_minus*9.300+ds_xmax)*ds_sc, 14.800*ds_sc);
		path_[1].lineTo((ds_minus*21.200+ds_xmax)*ds_sc, 4.200*ds_sc);
		path_[1].lineTo((ds_minus*30.000+ds_xmax)*ds_sc, 4.300*ds_sc);
		path_[1].lineTo((ds_minus*30.000+ds_xmax)*ds_sc, 56.400*ds_sc);
		path_[1].lineTo((ds_minus*20.600+ds_xmax)*ds_sc, 56.200*ds_sc);
		path_[1].lineTo((ds_minus*20.600+ds_xmax)*ds_sc, 14.600*ds_sc);
		path_[1].closePath();
		
		// path_[2]  
		path_[2].moveTo((ds_minus*6.200+ds_xmax)*ds_sc, 7.600*ds_sc);
		path_[2].quadTo((ds_minus*16.300+ds_xmax)*ds_sc, 2.100*ds_sc, (ds_minus*24.900+ds_xmax)*ds_sc, 4.000*ds_sc);
		path_[2].quadTo((ds_minus*36.100+ds_xmax)*ds_sc, 7.700*ds_sc, (ds_minus*35.700+ds_xmax)*ds_sc, 18.500*ds_sc);
		path_[2].quadTo((ds_minus*35.700+ds_xmax)*ds_sc, 27.500*ds_sc, (ds_minus*15.900+ds_xmax)*ds_sc, 47.500*ds_sc);
		path_[2].lineTo((ds_minus*36.300+ds_xmax)*ds_sc, 47.500*ds_sc);
		path_[2].lineTo((ds_minus*36.300+ds_xmax)*ds_sc, 56.800*ds_sc);
		path_[2].lineTo((ds_minus*4.700+ds_xmax)*ds_sc, 56.800*ds_sc);
		path_[2].lineTo((ds_minus*4.700+ds_xmax)*ds_sc, 47.000*ds_sc);
		path_[2].quadTo((ds_minus*25.300+ds_xmax)*ds_sc, 24.900*ds_sc, (ds_minus*25.000+ds_xmax)*ds_sc, 20.900*ds_sc);
		path_[2].quadTo((ds_minus*27.500+ds_xmax)*ds_sc, 12.200*ds_sc, (ds_minus*20.500+ds_xmax)*ds_sc, 12.700*ds_sc);
		path_[2].quadTo((ds_minus*16.000+ds_xmax)*ds_sc, 12.400*ds_sc, (ds_minus*8.500+ds_xmax)*ds_sc, 15.500*ds_sc);
		path_[2].closePath();
		
		// path_[3]  
		path_[3].moveTo((ds_minus*0.000+ds_xmax)*ds_sc, 0.000*ds_sc);
		path_[3].moveTo((ds_minus*5.900+ds_xmax)*ds_sc, 6.300*ds_sc);
		path_[3].quadTo((ds_minus*20.900+ds_xmax)*ds_sc, 0.200*ds_sc, (ds_minus*30.600+ds_xmax)*ds_sc, 6.600*ds_sc);
		path_[3].quadTo((ds_minus*39.100+ds_xmax)*ds_sc, 14.100*ds_sc, (ds_minus*34.300+ds_xmax)*ds_sc, 23.000*ds_sc);
		path_[3].quadTo((ds_minus*32.400+ds_xmax)*ds_sc, 27.200*ds_sc, (ds_minus*26.000+ds_xmax)*ds_sc, 29.000*ds_sc);
		path_[3].quadTo((ds_minus*30.300+ds_xmax)*ds_sc, 29.000*ds_sc, (ds_minus*34.000+ds_xmax)*ds_sc, 33.900*ds_sc);
		path_[3].quadTo((ds_minus*39.900+ds_xmax)*ds_sc, 46.300*ds_sc, (ds_minus*29.000+ds_xmax)*ds_sc, 54.100*ds_sc);
		path_[3].quadTo((ds_minus*17.800+ds_xmax)*ds_sc, 60.000*ds_sc, (ds_minus*3.500+ds_xmax)*ds_sc, 54.600*ds_sc);
		path_[3].lineTo((ds_minus*5.200+ds_xmax)*ds_sc, 46.500*ds_sc);
		path_[3].quadTo((ds_minus*17.800+ds_xmax)*ds_sc, 51.500*ds_sc, (ds_minus*23.300+ds_xmax)*ds_sc, 46.700*ds_sc);
		path_[3].quadTo((ds_minus*28.500+ds_xmax)*ds_sc, 42.000*ds_sc, (ds_minus*25.200+ds_xmax)*ds_sc, 37.500*ds_sc);
		path_[3].quadTo((ds_minus*21.700+ds_xmax)*ds_sc, 33.200*ds_sc, (ds_minus*11.000+ds_xmax)*ds_sc, 33.700*ds_sc);
		path_[3].lineTo((ds_minus*11.000+ds_xmax)*ds_sc, 24.800*ds_sc);
		path_[3].quadTo((ds_minus*20.000+ds_xmax)*ds_sc, 25.400*ds_sc, (ds_minus*23.200+ds_xmax)*ds_sc, 22.400*ds_sc);
		path_[3].quadTo((ds_minus*28.700+ds_xmax)*ds_sc, 16.700*ds_sc, (ds_minus*23.800+ds_xmax)*ds_sc, 13.500*ds_sc);
		path_[3].quadTo((ds_minus*19.100+ds_xmax)*ds_sc, 10.100*ds_sc, (ds_minus*8.000+ds_xmax)*ds_sc, 14.600*ds_sc);
		path_[3].closePath();
		
		// path_[4]  
		path_[4].moveTo((ds_minus*24.100+ds_xmax)*ds_sc, 44.400*ds_sc);
		path_[4].lineTo((ds_minus*2.000+ds_xmax)*ds_sc, 44.400*ds_sc);
		path_[4].lineTo((ds_minus*2.000+ds_xmax)*ds_sc, 35.700*ds_sc);
		path_[4].lineTo((ds_minus*22.000+ds_xmax)*ds_sc, 4.900*ds_sc);
		path_[4].lineTo((ds_minus*31.800+ds_xmax)*ds_sc, 4.900*ds_sc);
		path_[4].lineTo((ds_minus*31.800+ds_xmax)*ds_sc, 36.000*ds_sc);
		path_[4].lineTo((ds_minus*37.900+ds_xmax)*ds_sc, 36.000*ds_sc);
		path_[4].lineTo((ds_minus*37.900+ds_xmax)*ds_sc, 44.400*ds_sc);
		path_[4].lineTo((ds_minus*31.800+ds_xmax)*ds_sc, 44.400*ds_sc);
		path_[4].lineTo((ds_minus*31.800+ds_xmax)*ds_sc, 56.500*ds_sc);
		path_[4].lineTo((ds_minus*24.100+ds_xmax)*ds_sc, 56.500*ds_sc);
		path_[4].lineTo((ds_minus*24.100+ds_xmax)*ds_sc, 44.400*ds_sc);
		path_[4].moveTo((ds_minus*24.100+ds_xmax)*ds_sc, 36.000*ds_sc);
		path_[4].lineTo((ds_minus*10.900+ds_xmax)*ds_sc, 36.000*ds_sc);
		path_[4].lineTo((ds_minus*24.100+ds_xmax)*ds_sc, 15.000*ds_sc);
		path_[4].lineTo((ds_minus*24.100+ds_xmax)*ds_sc, 36.000*ds_sc);
		
		// path_[5]  
		path_[5].moveTo((ds_minus*34.800+ds_xmax)*ds_sc, 12.000*ds_sc);
		path_[5].lineTo((ds_minus*16.400+ds_xmax)*ds_sc, 12.000*ds_sc);
		path_[5].lineTo((ds_minus*15.900+ds_xmax)*ds_sc, 24.200*ds_sc);
		path_[5].quadTo((ds_minus*24.000+ds_xmax)*ds_sc, 23.100*ds_sc, (ds_minus*30.600+ds_xmax)*ds_sc, 26.700*ds_sc);
		path_[5].quadTo((ds_minus*42.500+ds_xmax)*ds_sc, 37.200*ds_sc, (ds_minus*32.700+ds_xmax)*ds_sc, 51.800*ds_sc);
		path_[5].quadTo((ds_minus*22.400+ds_xmax)*ds_sc, 61.000*ds_sc, (ds_minus*6.100+ds_xmax)*ds_sc, 54.600*ds_sc);
		path_[5].lineTo((ds_minus*6.900+ds_xmax)*ds_sc, 46.800*ds_sc);
		path_[5].quadTo((ds_minus*20.900+ds_xmax)*ds_sc, 52.200*ds_sc, (ds_minus*25.600+ds_xmax)*ds_sc, 45.700*ds_sc);
		path_[5].quadTo((ds_minus*29.800+ds_xmax)*ds_sc, 37.600*ds_sc, (ds_minus*24.300+ds_xmax)*ds_sc, 34.200*ds_sc);
		path_[5].quadTo((ds_minus*18.600+ds_xmax)*ds_sc, 30.100*ds_sc, (ds_minus*6.900+ds_xmax)*ds_sc, 33.800*ds_sc);
		path_[5].lineTo((ds_minus*7.600+ds_xmax)*ds_sc, 4.200*ds_sc);
		path_[5].lineTo((ds_minus*34.800+ds_xmax)*ds_sc, 4.300*ds_sc);
		path_[5].closePath();
		
		// path_[6]  
		path_[6].moveTo((ds_minus*35.200+ds_xmax)*ds_sc, 5.300*ds_sc);
		path_[6].quadTo((ds_minus*17.000+ds_xmax)*ds_sc, 0.400*ds_sc, (ds_minus*7.400+ds_xmax)*ds_sc, 12.700*ds_sc);
		path_[6].quadTo((ds_minus*0.100+ds_xmax)*ds_sc, 27.800*ds_sc, (ds_minus*4.500+ds_xmax)*ds_sc, 45.700*ds_sc);
		path_[6].quadTo((ds_minus*8.400+ds_xmax)*ds_sc, 57.700*ds_sc, (ds_minus*20.300+ds_xmax)*ds_sc, 57.100*ds_sc);
		path_[6].quadTo((ds_minus*34.700+ds_xmax)*ds_sc, 57.100*ds_sc, (ds_minus*37.100+ds_xmax)*ds_sc, 41.200*ds_sc);
		path_[6].quadTo((ds_minus*37.800+ds_xmax)*ds_sc, 26.400*ds_sc, (ds_minus*23.100+ds_xmax)*ds_sc, 22.800*ds_sc);
		path_[6].quadTo((ds_minus*17.000+ds_xmax)*ds_sc, 22.000*ds_sc, (ds_minus*12.100+ds_xmax)*ds_sc, 25.800*ds_sc);
		path_[6].quadTo((ds_minus*12.800+ds_xmax)*ds_sc, 17.600*ds_sc, (ds_minus*18.100+ds_xmax)*ds_sc, 14.000*ds_sc);
		path_[6].quadTo((ds_minus*23.700+ds_xmax)*ds_sc, 10.500*ds_sc, (ds_minus*34.700+ds_xmax)*ds_sc, 13.600*ds_sc);
		path_[6].lineTo((ds_minus*35.200+ds_xmax)*ds_sc, 5.300*ds_sc);
		path_[6].moveTo((ds_minus*15.800+ds_xmax)*ds_sc, 32.800*ds_sc);
		path_[6].quadTo((ds_minus*23.500+ds_xmax)*ds_sc, 28.800*ds_sc, (ds_minus*27.900+ds_xmax)*ds_sc, 36.300*ds_sc);
		path_[6].quadTo((ds_minus*30.100+ds_xmax)*ds_sc, 44.900*ds_sc, (ds_minus*24.300+ds_xmax)*ds_sc, 48.000*ds_sc);
		path_[6].quadTo((ds_minus*16.700+ds_xmax)*ds_sc, 50.800*ds_sc, (ds_minus*13.600+ds_xmax)*ds_sc, 44.900*ds_sc);
		path_[6].quadTo((ds_minus*10.300+ds_xmax)*ds_sc, 37.100*ds_sc, (ds_minus*15.800+ds_xmax)*ds_sc, 32.800*ds_sc);
		
		
		// path_[7]  
		path_[7].moveTo((ds_minus*4.800+ds_xmax)*ds_sc, 12.700*ds_sc);
		path_[7].lineTo((ds_minus*3.700+ds_xmax)*ds_sc, 3.900*ds_sc);
		path_[7].lineTo((ds_minus*35.600+ds_xmax)*ds_sc, 3.700*ds_sc);
		path_[7].lineTo((ds_minus*36.100+ds_xmax)*ds_sc, 12.900*ds_sc);
		path_[7].lineTo((ds_minus*17.600+ds_xmax)*ds_sc, 57.300*ds_sc);
		path_[7].lineTo((ds_minus*8.100+ds_xmax)*ds_sc, 56.900*ds_sc);
		path_[7].lineTo((ds_minus*26.800+ds_xmax)*ds_sc, 12.900*ds_sc);
		path_[7].closePath();
		
		// path_[8]  
		path_[8].moveTo((ds_minus*14.600+ds_xmax)*ds_sc, 29.200*ds_sc);
		path_[8].quadTo((ds_minus*4.000+ds_xmax)*ds_sc, 24.100*ds_sc, (ds_minus*4.100+ds_xmax)*ds_sc, 16.400*ds_sc);
		path_[8].quadTo((ds_minus*4.800+ds_xmax)*ds_sc, 5.000*ds_sc, (ds_minus*20.200+ds_xmax)*ds_sc, 3.400*ds_sc);
		path_[8].quadTo((ds_minus*34.800+ds_xmax)*ds_sc, 3.300*ds_sc, (ds_minus*36.600+ds_xmax)*ds_sc, 15.800*ds_sc);
		path_[8].quadTo((ds_minus*34.200+ds_xmax)*ds_sc, 24.800*ds_sc, (ds_minus*26.000+ds_xmax)*ds_sc, 29.500*ds_sc);
		path_[8].quadTo((ds_minus*37.700+ds_xmax)*ds_sc, 33.000*ds_sc, (ds_minus*38.300+ds_xmax)*ds_sc, 43.000*ds_sc);
		path_[8].quadTo((ds_minus*36.200+ds_xmax)*ds_sc, 57.400*ds_sc, (ds_minus*20.300+ds_xmax)*ds_sc, 57.200*ds_sc);
		path_[8].quadTo((ds_minus*4.300+ds_xmax)*ds_sc, 56.200*ds_sc, (ds_minus*2.900+ds_xmax)*ds_sc, 43.400*ds_sc);
		path_[8].quadTo((ds_minus*2.700+ds_xmax)*ds_sc, 34.100*ds_sc, (ds_minus*14.600+ds_xmax)*ds_sc, 29.200*ds_sc);
		path_[8].moveTo((ds_minus*20.400+ds_xmax)*ds_sc, 23.100*ds_sc);
		path_[8].quadTo((ds_minus*14.900+ds_xmax)*ds_sc, 22.000*ds_sc, (ds_minus*13.400+ds_xmax)*ds_sc, 16.600*ds_sc);
		path_[8].quadTo((ds_minus*13.300+ds_xmax)*ds_sc, 11.800*ds_sc, (ds_minus*20.300+ds_xmax)*ds_sc, 11.300*ds_sc);
		path_[8].quadTo((ds_minus*27.400+ds_xmax)*ds_sc, 12.000*ds_sc, (ds_minus*27.100+ds_xmax)*ds_sc, 16.500*ds_sc);
		path_[8].quadTo((ds_minus*26.500+ds_xmax)*ds_sc, 21.700*ds_sc, (ds_minus*20.400+ds_xmax)*ds_sc, 23.100*ds_sc);
		path_[8].moveTo((ds_minus*20.500+ds_xmax)*ds_sc, 35.000*ds_sc);
		path_[8].quadTo((ds_minus*28.900+ds_xmax)*ds_sc, 37.700*ds_sc, (ds_minus*29.400+ds_xmax)*ds_sc, 42.900*ds_sc);
		path_[8].quadTo((ds_minus*28.700+ds_xmax)*ds_sc, 47.900*ds_sc, (ds_minus*20.400+ds_xmax)*ds_sc, 48.900*ds_sc);
		path_[8].quadTo((ds_minus*13.100+ds_xmax)*ds_sc, 48.300*ds_sc, (ds_minus*12.200+ds_xmax)*ds_sc, 43.000*ds_sc);
		path_[8].quadTo((ds_minus*11.900+ds_xmax)*ds_sc, 38.300*ds_sc, (ds_minus*20.500+ds_xmax)*ds_sc, 35.000*ds_sc);
		
		// path_[9]  
		path_[9].moveTo((ds_minus*27.000+ds_xmax)*ds_sc, 35.700*ds_sc);
		path_[9].quadTo((ds_minus*23.800+ds_xmax)*ds_sc, 38.600*ds_sc, (ds_minus*17.400+ds_xmax)*ds_sc, 37.900*ds_sc);
		path_[9].quadTo((ds_minus*1.700+ds_xmax)*ds_sc, 35.400*ds_sc, (ds_minus*2.000+ds_xmax)*ds_sc, 21.200*ds_sc);
		path_[9].quadTo((ds_minus*2.500+ds_xmax)*ds_sc, 4.200*ds_sc, (ds_minus*19.300+ds_xmax)*ds_sc, 3.400*ds_sc);
		path_[9].quadTo((ds_minus*32.600+ds_xmax)*ds_sc, 3.000*ds_sc, (ds_minus*35.600+ds_xmax)*ds_sc, 18.300*ds_sc);
		path_[9].quadTo((ds_minus*39.100+ds_xmax)*ds_sc, 46.600*ds_sc, (ds_minus*26.500+ds_xmax)*ds_sc, 53.500*ds_sc);
		path_[9].quadTo((ds_minus*16.200+ds_xmax)*ds_sc, 59.700*ds_sc, (ds_minus*3.700+ds_xmax)*ds_sc, 55.300*ds_sc);
		path_[9].lineTo((ds_minus*4.900+ds_xmax)*ds_sc, 47.900*ds_sc);
		path_[9].quadTo((ds_minus*16.300+ds_xmax)*ds_sc, 50.400*ds_sc, (ds_minus*20.700+ds_xmax)*ds_sc, 46.600*ds_sc);
		path_[9].quadTo((ds_minus*26.000+ds_xmax)*ds_sc, 42.300*ds_sc, (ds_minus*27.000+ds_xmax)*ds_sc, 35.700*ds_sc);
		path_[9].moveTo((ds_minus*26.300+ds_xmax)*ds_sc, 19.900*ds_sc);
		path_[9].quadTo((ds_minus*26.000+ds_xmax)*ds_sc, 11.500*ds_sc, (ds_minus*18.600+ds_xmax)*ds_sc, 11.700*ds_sc);
		path_[9].quadTo((ds_minus*10.900+ds_xmax)*ds_sc, 12.100*ds_sc, (ds_minus*10.300+ds_xmax)*ds_sc, 20.700*ds_sc);
		path_[9].quadTo((ds_minus*11.500+ds_xmax)*ds_sc, 29.400*ds_sc, (ds_minus*19.100+ds_xmax)*ds_sc, 29.200*ds_sc);
		path_[9].quadTo((ds_minus*26.700+ds_xmax)*ds_sc, 28.800*ds_sc, (ds_minus*26.300+ds_xmax)*ds_sc, 19.900*ds_sc);

		g2d_image.setColor(co_in);
		g2d_image.fill(path_[image_num]);
		g2d_image.setStroke(new BasicStroke(s_boder));
		g2d_image.setColor(co_out);
		g2d_image.draw(path_[image_num]);
		return buf_image;
	}


	public Image BBNumber_Draw(double ds_sc, boolean ds_rep, Color co_out, Color co_in, int s_boder, int image_num){
		double ds_minus=1.0, ds_xmax;
		int dimage_width=(int)(image_width2*ds_sc);
		int dimage_height=(int)(image_height2*ds_sc);
		buf_image2 = new BufferedImage(dimage_width, dimage_height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d_image2 = buf_image2.createGraphics();
		if(ds_rep){ds_minus=-1.0; ds_xmax=(double)dimage_width;}
		else {ds_minus=1.0; ds_xmax=0.0;}

		GeneralPath path_01 = new GeneralPath();
		GeneralPath path_02 = new GeneralPath();
		Ellipse2D.Double elippse_01 = new Ellipse2D.Double(0.000*ds_sc, 0.000*ds_sc, 80.000*ds_sc, 80.000*ds_sc);

		// path_01  
		path_01.moveTo(18.000*ds_sc, 6.900*ds_sc);
		path_01.quadTo(37.400*ds_sc, 40.000*ds_sc, 18.000*ds_sc, 73.100*ds_sc);
		path_01.moveTo(62.000*ds_sc, 73.100*ds_sc);
		path_01.quadTo(42.600*ds_sc, 40.000*ds_sc, 62.000*ds_sc, 6.900*ds_sc);
		path_01.moveTo(17.900*ds_sc, 9.700*ds_sc);
		
		// path_02  
		path_02.moveTo(17.800*ds_sc, 9.500*ds_sc);
		path_02.lineTo(20.300*ds_sc, 7.900*ds_sc);
		path_02.moveTo(19.400*ds_sc, 12.200*ds_sc);
		path_02.lineTo(21.800*ds_sc, 10.800*ds_sc);
		path_02.moveTo(21.100*ds_sc, 15.400*ds_sc);
		path_02.lineTo(23.400*ds_sc, 14.100*ds_sc);
		path_02.moveTo(22.300*ds_sc, 18.800*ds_sc);
		path_02.lineTo(24.900*ds_sc, 17.900*ds_sc);
		path_02.moveTo(23.400*ds_sc, 21.900*ds_sc);
		path_02.lineTo(26.000*ds_sc, 20.800*ds_sc);
		path_02.moveTo(24.300*ds_sc, 24.800*ds_sc);
		path_02.lineTo(26.900*ds_sc, 24.100*ds_sc);
		path_02.moveTo(25.000*ds_sc, 27.500*ds_sc);
		path_02.lineTo(27.700*ds_sc, 26.700*ds_sc);
		path_02.moveTo(25.400*ds_sc, 30.300*ds_sc);
		path_02.lineTo(28.300*ds_sc, 29.700*ds_sc);
		path_02.moveTo(26.000*ds_sc, 33.500*ds_sc);
		path_02.lineTo(28.500*ds_sc, 33.100*ds_sc);
		path_02.moveTo(26.100*ds_sc, 36.600*ds_sc);
		path_02.lineTo(29.100*ds_sc, 36.500*ds_sc);
		path_02.moveTo(26.500*ds_sc, 40.000*ds_sc);
		path_02.lineTo(29.600*ds_sc, 40.000*ds_sc);
		
		path_02.moveTo(17.800*ds_sc, 70.500*ds_sc);
		path_02.lineTo(20.300*ds_sc, 72.100*ds_sc);
		path_02.moveTo(19.400*ds_sc, 67.800*ds_sc);
		path_02.lineTo(21.800*ds_sc, 69.200*ds_sc);
		path_02.moveTo(21.100*ds_sc, 64.600*ds_sc);
		path_02.lineTo(23.400*ds_sc, 65.900*ds_sc);
		path_02.moveTo(22.300*ds_sc, 61.200*ds_sc);
		path_02.lineTo(24.900*ds_sc, 62.100*ds_sc);
		path_02.moveTo(23.400*ds_sc, 58.100*ds_sc);
		path_02.lineTo(26.000*ds_sc, 59.200*ds_sc);
		path_02.moveTo(24.300*ds_sc, 55.200*ds_sc);
		path_02.lineTo(26.900*ds_sc, 55.900*ds_sc);
		path_02.moveTo(25.000*ds_sc, 52.200*ds_sc);
		path_02.lineTo(27.700*ds_sc, 53.300*ds_sc);
		path_02.moveTo(25.400*ds_sc, 49.700*ds_sc);
		path_02.lineTo(28.300*ds_sc, 50.300*ds_sc);
		path_02.moveTo(26.000*ds_sc, 46.500*ds_sc);
		path_02.lineTo(28.500*ds_sc, 46.900*ds_sc);
		path_02.moveTo(26.100*ds_sc, 43.400*ds_sc);
		path_02.lineTo(29.100*ds_sc, 43.500*ds_sc);
		
		path_02.moveTo(62.200*ds_sc, 9.500*ds_sc);
		path_02.lineTo(59.700*ds_sc, 7.900*ds_sc);
		path_02.moveTo(60.600*ds_sc, 12.200*ds_sc);
		path_02.lineTo(58.200*ds_sc, 10.800*ds_sc);
		path_02.moveTo(58.900*ds_sc, 15.400*ds_sc);
		path_02.lineTo(56.600*ds_sc, 14.100*ds_sc);
		path_02.moveTo(57.700*ds_sc, 18.800*ds_sc);
		path_02.lineTo(55.100*ds_sc, 17.900*ds_sc);
		path_02.moveTo(56.600*ds_sc, 21.900*ds_sc);
		path_02.lineTo(54.000*ds_sc, 20.800*ds_sc);
		path_02.moveTo(55.700*ds_sc, 24.800*ds_sc);
		path_02.lineTo(53.100*ds_sc, 24.100*ds_sc);
		path_02.moveTo(55.000*ds_sc, 27.500*ds_sc);
		path_02.lineTo(52.300*ds_sc, 26.700*ds_sc);
		path_02.moveTo(54.600*ds_sc, 30.300*ds_sc);
		path_02.lineTo(51.700*ds_sc, 29.700*ds_sc);
		path_02.moveTo(54.000*ds_sc, 33.500*ds_sc);
		path_02.lineTo(51.500*ds_sc, 33.100*ds_sc);
		path_02.moveTo(53.900*ds_sc, 36.600*ds_sc);
		path_02.lineTo(50.900*ds_sc, 36.500*ds_sc);
		path_02.moveTo(53.500*ds_sc, 40.000*ds_sc);
		path_02.lineTo(50.900*ds_sc, 40.000*ds_sc);
		
		path_02.moveTo(62.200*ds_sc, 70.500*ds_sc);
		path_02.lineTo(59.700*ds_sc, 72.100*ds_sc);
		path_02.moveTo(60.600*ds_sc, 67.800*ds_sc);
		path_02.lineTo(58.200*ds_sc, 69.200*ds_sc);
		path_02.moveTo(58.900*ds_sc, 64.600*ds_sc);
		path_02.lineTo(56.600*ds_sc, 65.900*ds_sc);
		path_02.moveTo(57.700*ds_sc, 61.200*ds_sc);
		path_02.lineTo(55.100*ds_sc, 62.100*ds_sc);
		path_02.moveTo(56.600*ds_sc, 58.100*ds_sc);
		path_02.lineTo(54.000*ds_sc, 59.200*ds_sc);
		path_02.moveTo(55.700*ds_sc, 55.200*ds_sc);
		path_02.lineTo(53.100*ds_sc, 55.900*ds_sc);
		path_02.moveTo(55.000*ds_sc, 52.200*ds_sc);
		path_02.lineTo(52.300*ds_sc, 53.300*ds_sc);
		path_02.moveTo(54.600*ds_sc, 49.700*ds_sc);
		path_02.lineTo(51.700*ds_sc, 50.300*ds_sc);
		path_02.moveTo(54.000*ds_sc, 46.500*ds_sc);
		path_02.lineTo(51.500*ds_sc, 46.900*ds_sc);
		path_02.moveTo(53.900*ds_sc, 43.400*ds_sc);
		path_02.lineTo(50.900*ds_sc, 43.500*ds_sc);

		g2d_image2.setColor(co_bbbg);
		g2d_image2.fill(elippse_01);
		g2d_image2.setStroke(new BasicStroke(s_bbout));
		g2d_image2.setColor(co_bbout);
		g2d_image2.draw(elippse_01);
		g2d_image2.draw(path_01);
		g2d_image2.setStroke(new BasicStroke(s_bbstring));
		g2d_image2.setColor(co_bbstring);
		g2d_image2.draw(path_02);


		for(int i=0; i<10; i++) path_[i].reset();
		// path_[0]  
		path_[0].moveTo((ds_minus*23.100+ds_xmax)*ds_sc, 40.200*ds_sc);
		path_[0].quadTo((ds_minus*23.300+ds_xmax)*ds_sc, 13.500*ds_sc, (ds_minus*40.200+ds_xmax)*ds_sc, 13.700*ds_sc);
		path_[0].quadTo((ds_minus*58.000+ds_xmax)*ds_sc, 14.100*ds_sc, (ds_minus*57.600+ds_xmax)*ds_sc, 40.500*ds_sc);
		path_[0].quadTo((ds_minus*58.100+ds_xmax)*ds_sc, 67.600*ds_sc, (ds_minus*40.300+ds_xmax)*ds_sc, 66.800*ds_sc);
		path_[0].quadTo((ds_minus*21.700+ds_xmax)*ds_sc, 65.500*ds_sc, (ds_minus*23.100+ds_xmax)*ds_sc, 40.200*ds_sc);
		path_[0].moveTo((ds_minus*39.900+ds_xmax)*ds_sc, 22.600*ds_sc);
		path_[0].quadTo((ds_minus*31.800+ds_xmax)*ds_sc, 23.000*ds_sc, (ds_minus*32.000+ds_xmax)*ds_sc, 40.200*ds_sc);
		path_[0].quadTo((ds_minus*31.900+ds_xmax)*ds_sc, 57.200*ds_sc, (ds_minus*40.200+ds_xmax)*ds_sc, 58.000*ds_sc);
		path_[0].quadTo((ds_minus*48.600+ds_xmax)*ds_sc, 57.000*ds_sc, (ds_minus*48.300+ds_xmax)*ds_sc, 40.300*ds_sc);
		path_[0].quadTo((ds_minus*47.900+ds_xmax)*ds_sc, 21.700*ds_sc, (ds_minus*39.900+ds_xmax)*ds_sc, 22.600*ds_sc);
		
		// path_[1]  
		path_[1].moveTo((ds_minus*34.500+ds_xmax)*ds_sc, 29.500*ds_sc);
		path_[1].lineTo((ds_minus*29.300+ds_xmax)*ds_sc, 24.800*ds_sc);
		path_[1].lineTo((ds_minus*41.200+ds_xmax)*ds_sc, 14.200*ds_sc);
		path_[1].lineTo((ds_minus*50.000+ds_xmax)*ds_sc, 14.300*ds_sc);
		path_[1].lineTo((ds_minus*50.000+ds_xmax)*ds_sc, 66.400*ds_sc);
		path_[1].lineTo((ds_minus*40.600+ds_xmax)*ds_sc, 66.200*ds_sc);
		path_[1].lineTo((ds_minus*40.600+ds_xmax)*ds_sc, 24.600*ds_sc);
		path_[1].closePath();
		
		// path_[2]  
		path_[2].moveTo((ds_minus*26.200+ds_xmax)*ds_sc, 17.600*ds_sc);
		path_[2].quadTo((ds_minus*36.300+ds_xmax)*ds_sc, 12.100*ds_sc, (ds_minus*44.900+ds_xmax)*ds_sc, 14.000*ds_sc);
		path_[2].quadTo((ds_minus*56.100+ds_xmax)*ds_sc, 17.700*ds_sc, (ds_minus*55.700+ds_xmax)*ds_sc, 28.500*ds_sc);
		path_[2].quadTo((ds_minus*55.700+ds_xmax)*ds_sc, 37.500*ds_sc, (ds_minus*35.900+ds_xmax)*ds_sc, 57.500*ds_sc);
		path_[2].lineTo((ds_minus*56.300+ds_xmax)*ds_sc, 57.500*ds_sc);
		path_[2].lineTo((ds_minus*56.300+ds_xmax)*ds_sc, 66.800*ds_sc);
		path_[2].lineTo((ds_minus*24.700+ds_xmax)*ds_sc, 66.800*ds_sc);
		path_[2].lineTo((ds_minus*24.700+ds_xmax)*ds_sc, 57.000*ds_sc);
		path_[2].quadTo((ds_minus*45.300+ds_xmax)*ds_sc, 34.900*ds_sc, (ds_minus*45.000+ds_xmax)*ds_sc, 30.900*ds_sc);
		path_[2].quadTo((ds_minus*47.500+ds_xmax)*ds_sc, 22.200*ds_sc, (ds_minus*40.500+ds_xmax)*ds_sc, 22.700*ds_sc);
		path_[2].quadTo((ds_minus*36.000+ds_xmax)*ds_sc, 22.400*ds_sc, (ds_minus*28.500+ds_xmax)*ds_sc, 25.500*ds_sc);
		path_[2].closePath();
		
		// path_[3]  
		path_[3].moveTo((ds_minus*20.000+ds_xmax)*ds_sc, 10.000*ds_sc);
		path_[3].moveTo((ds_minus*25.900+ds_xmax)*ds_sc, 16.300*ds_sc);
		path_[3].quadTo((ds_minus*40.900+ds_xmax)*ds_sc, 10.200*ds_sc, (ds_minus*50.600+ds_xmax)*ds_sc, 16.600*ds_sc);
		path_[3].quadTo((ds_minus*59.100+ds_xmax)*ds_sc, 24.100*ds_sc, (ds_minus*54.300+ds_xmax)*ds_sc, 33.000*ds_sc);
		path_[3].quadTo((ds_minus*52.400+ds_xmax)*ds_sc, 37.200*ds_sc, (ds_minus*46.000+ds_xmax)*ds_sc, 39.000*ds_sc);
		path_[3].quadTo((ds_minus*50.300+ds_xmax)*ds_sc, 39.000*ds_sc, (ds_minus*54.000+ds_xmax)*ds_sc, 43.900*ds_sc);
		path_[3].quadTo((ds_minus*59.900+ds_xmax)*ds_sc, 56.300*ds_sc, (ds_minus*49.000+ds_xmax)*ds_sc, 64.100*ds_sc);
		path_[3].quadTo((ds_minus*37.800+ds_xmax)*ds_sc, 70.000*ds_sc, (ds_minus*23.500+ds_xmax)*ds_sc, 64.600*ds_sc);
		path_[3].lineTo((ds_minus*25.200+ds_xmax)*ds_sc, 56.500*ds_sc);
		path_[3].quadTo((ds_minus*37.800+ds_xmax)*ds_sc, 61.500*ds_sc, (ds_minus*43.300+ds_xmax)*ds_sc, 56.700*ds_sc);
		path_[3].quadTo((ds_minus*48.500+ds_xmax)*ds_sc, 52.000*ds_sc, (ds_minus*45.200+ds_xmax)*ds_sc, 47.500*ds_sc);
		path_[3].quadTo((ds_minus*41.700+ds_xmax)*ds_sc, 43.200*ds_sc, (ds_minus*31.000+ds_xmax)*ds_sc, 43.700*ds_sc);
		path_[3].lineTo((ds_minus*31.000+ds_xmax)*ds_sc, 34.800*ds_sc);
		path_[3].quadTo((ds_minus*40.000+ds_xmax)*ds_sc, 35.400*ds_sc, (ds_minus*43.200+ds_xmax)*ds_sc, 32.400*ds_sc);
		path_[3].quadTo((ds_minus*48.700+ds_xmax)*ds_sc, 26.700*ds_sc, (ds_minus*43.800+ds_xmax)*ds_sc, 23.500*ds_sc);
		path_[3].quadTo((ds_minus*39.100+ds_xmax)*ds_sc, 20.100*ds_sc, (ds_minus*28.000+ds_xmax)*ds_sc, 24.600*ds_sc);
		path_[3].closePath();
		
		// path_[4]  
		path_[4].moveTo((ds_minus*44.100+ds_xmax)*ds_sc, 54.400*ds_sc);
		path_[4].lineTo((ds_minus*22.000+ds_xmax)*ds_sc, 54.400*ds_sc);
		path_[4].lineTo((ds_minus*22.000+ds_xmax)*ds_sc, 45.700*ds_sc);
		path_[4].lineTo((ds_minus*42.000+ds_xmax)*ds_sc, 14.900*ds_sc);
		path_[4].lineTo((ds_minus*51.800+ds_xmax)*ds_sc, 14.900*ds_sc);
		path_[4].lineTo((ds_minus*51.800+ds_xmax)*ds_sc, 46.000*ds_sc);
		path_[4].lineTo((ds_minus*57.900+ds_xmax)*ds_sc, 46.000*ds_sc);
		path_[4].lineTo((ds_minus*57.900+ds_xmax)*ds_sc, 54.400*ds_sc);
		path_[4].lineTo((ds_minus*51.800+ds_xmax)*ds_sc, 54.400*ds_sc);
		path_[4].lineTo((ds_minus*51.800+ds_xmax)*ds_sc, 66.500*ds_sc);
		path_[4].lineTo((ds_minus*44.100+ds_xmax)*ds_sc, 66.500*ds_sc);
		path_[4].lineTo((ds_minus*44.100+ds_xmax)*ds_sc, 54.400*ds_sc);
		path_[4].moveTo((ds_minus*44.100+ds_xmax)*ds_sc, 46.000*ds_sc);
		path_[4].lineTo((ds_minus*30.900+ds_xmax)*ds_sc, 46.000*ds_sc);
		path_[4].lineTo((ds_minus*44.100+ds_xmax)*ds_sc, 25.000*ds_sc);
		path_[4].lineTo((ds_minus*44.100+ds_xmax)*ds_sc, 46.000*ds_sc);
		
		// path_[5]  
		path_[5].moveTo((ds_minus*54.800+ds_xmax)*ds_sc, 22.000*ds_sc);
		path_[5].lineTo((ds_minus*36.400+ds_xmax)*ds_sc, 22.000*ds_sc);
		path_[5].lineTo((ds_minus*35.900+ds_xmax)*ds_sc, 34.200*ds_sc);
		path_[5].quadTo((ds_minus*44.000+ds_xmax)*ds_sc, 33.100*ds_sc, (ds_minus*50.600+ds_xmax)*ds_sc, 36.700*ds_sc);
		path_[5].quadTo((ds_minus*62.500+ds_xmax)*ds_sc, 47.200*ds_sc, (ds_minus*52.700+ds_xmax)*ds_sc, 61.800*ds_sc);
		path_[5].quadTo((ds_minus*42.400+ds_xmax)*ds_sc, 71.000*ds_sc, (ds_minus*26.100+ds_xmax)*ds_sc, 64.600*ds_sc);
		path_[5].lineTo((ds_minus*26.900+ds_xmax)*ds_sc, 56.800*ds_sc);
		path_[5].quadTo((ds_minus*40.900+ds_xmax)*ds_sc, 62.200*ds_sc, (ds_minus*45.600+ds_xmax)*ds_sc, 55.700*ds_sc);
		path_[5].quadTo((ds_minus*49.800+ds_xmax)*ds_sc, 47.600*ds_sc, (ds_minus*44.300+ds_xmax)*ds_sc, 44.200*ds_sc);
		path_[5].quadTo((ds_minus*38.600+ds_xmax)*ds_sc, 40.100*ds_sc, (ds_minus*26.900+ds_xmax)*ds_sc, 43.800*ds_sc);
		path_[5].lineTo((ds_minus*27.600+ds_xmax)*ds_sc, 14.200*ds_sc);
		path_[5].lineTo((ds_minus*54.800+ds_xmax)*ds_sc, 14.300*ds_sc);
		path_[5].closePath();
		
		// path_[6]  
		path_[6].moveTo((ds_minus*55.200+ds_xmax)*ds_sc, 15.300*ds_sc);
		path_[6].quadTo((ds_minus*37.000+ds_xmax)*ds_sc, 10.400*ds_sc, (ds_minus*27.400+ds_xmax)*ds_sc, 22.700*ds_sc);
		path_[6].quadTo((ds_minus*20.100+ds_xmax)*ds_sc, 37.800*ds_sc, (ds_minus*24.500+ds_xmax)*ds_sc, 55.700*ds_sc);
		path_[6].quadTo((ds_minus*28.400+ds_xmax)*ds_sc, 67.700*ds_sc, (ds_minus*40.300+ds_xmax)*ds_sc, 67.100*ds_sc);
		path_[6].quadTo((ds_minus*54.700+ds_xmax)*ds_sc, 67.100*ds_sc, (ds_minus*57.100+ds_xmax)*ds_sc, 51.200*ds_sc);
		path_[6].quadTo((ds_minus*57.800+ds_xmax)*ds_sc, 36.400*ds_sc, (ds_minus*43.100+ds_xmax)*ds_sc, 32.800*ds_sc);
		path_[6].quadTo((ds_minus*37.000+ds_xmax)*ds_sc, 32.000*ds_sc, (ds_minus*32.100+ds_xmax)*ds_sc, 35.800*ds_sc);
		path_[6].quadTo((ds_minus*32.800+ds_xmax)*ds_sc, 27.600*ds_sc, (ds_minus*38.100+ds_xmax)*ds_sc, 24.000*ds_sc);
		path_[6].quadTo((ds_minus*43.700+ds_xmax)*ds_sc, 20.500*ds_sc, (ds_minus*54.700+ds_xmax)*ds_sc, 23.600*ds_sc);
		path_[6].lineTo((ds_minus*55.200+ds_xmax)*ds_sc, 15.300*ds_sc);
		path_[6].moveTo((ds_minus*35.800+ds_xmax)*ds_sc, 42.800*ds_sc);
		path_[6].quadTo((ds_minus*43.500+ds_xmax)*ds_sc, 38.800*ds_sc, (ds_minus*47.900+ds_xmax)*ds_sc, 46.300*ds_sc);
		path_[6].quadTo((ds_minus*50.100+ds_xmax)*ds_sc, 54.900*ds_sc, (ds_minus*44.300+ds_xmax)*ds_sc, 58.000*ds_sc);
		path_[6].quadTo((ds_minus*36.700+ds_xmax)*ds_sc, 60.800*ds_sc, (ds_minus*33.600+ds_xmax)*ds_sc, 54.900*ds_sc);
		path_[6].quadTo((ds_minus*30.300+ds_xmax)*ds_sc, 47.100*ds_sc, (ds_minus*35.800+ds_xmax)*ds_sc, 42.800*ds_sc);
		
		
		// path_[7]  
		path_[7].moveTo((ds_minus*24.800+ds_xmax)*ds_sc, 22.700*ds_sc);
		path_[7].lineTo((ds_minus*23.700+ds_xmax)*ds_sc, 13.900*ds_sc);
		path_[7].lineTo((ds_minus*55.600+ds_xmax)*ds_sc, 13.700*ds_sc);
		path_[7].lineTo((ds_minus*56.100+ds_xmax)*ds_sc, 22.900*ds_sc);
		path_[7].lineTo((ds_minus*37.600+ds_xmax)*ds_sc, 67.300*ds_sc);
		path_[7].lineTo((ds_minus*28.100+ds_xmax)*ds_sc, 66.900*ds_sc);
		path_[7].lineTo((ds_minus*46.800+ds_xmax)*ds_sc, 22.900*ds_sc);
		path_[7].closePath();
		
		// path_[8]  
		path_[8].moveTo((ds_minus*34.600+ds_xmax)*ds_sc, 39.200*ds_sc);
		path_[8].quadTo((ds_minus*24.000+ds_xmax)*ds_sc, 34.100*ds_sc, (ds_minus*24.100+ds_xmax)*ds_sc, 26.400*ds_sc);
		path_[8].quadTo((ds_minus*24.800+ds_xmax)*ds_sc, 15.000*ds_sc, (ds_minus*40.200+ds_xmax)*ds_sc, 13.400*ds_sc);
		path_[8].quadTo((ds_minus*54.800+ds_xmax)*ds_sc, 13.300*ds_sc, (ds_minus*56.600+ds_xmax)*ds_sc, 25.800*ds_sc);
		path_[8].quadTo((ds_minus*54.200+ds_xmax)*ds_sc, 34.800*ds_sc, (ds_minus*46.000+ds_xmax)*ds_sc, 39.500*ds_sc);
		path_[8].quadTo((ds_minus*57.700+ds_xmax)*ds_sc, 43.000*ds_sc, (ds_minus*58.300+ds_xmax)*ds_sc, 53.000*ds_sc);
		path_[8].quadTo((ds_minus*56.200+ds_xmax)*ds_sc, 67.400*ds_sc, (ds_minus*40.300+ds_xmax)*ds_sc, 67.200*ds_sc);
		path_[8].quadTo((ds_minus*24.300+ds_xmax)*ds_sc, 66.200*ds_sc, (ds_minus*22.900+ds_xmax)*ds_sc, 53.400*ds_sc);
		path_[8].quadTo((ds_minus*22.700+ds_xmax)*ds_sc, 44.100*ds_sc, (ds_minus*34.600+ds_xmax)*ds_sc, 39.200*ds_sc);
		path_[8].moveTo((ds_minus*40.400+ds_xmax)*ds_sc, 33.100*ds_sc);
		path_[8].quadTo((ds_minus*34.900+ds_xmax)*ds_sc, 32.000*ds_sc, (ds_minus*33.400+ds_xmax)*ds_sc, 26.600*ds_sc);
		path_[8].quadTo((ds_minus*33.300+ds_xmax)*ds_sc, 21.800*ds_sc, (ds_minus*40.300+ds_xmax)*ds_sc, 21.300*ds_sc);
		path_[8].quadTo((ds_minus*47.400+ds_xmax)*ds_sc, 22.000*ds_sc, (ds_minus*47.100+ds_xmax)*ds_sc, 26.500*ds_sc);
		path_[8].quadTo((ds_minus*46.500+ds_xmax)*ds_sc, 31.700*ds_sc, (ds_minus*40.400+ds_xmax)*ds_sc, 33.100*ds_sc);
		path_[8].moveTo((ds_minus*40.500+ds_xmax)*ds_sc, 45.000*ds_sc);
		path_[8].quadTo((ds_minus*48.900+ds_xmax)*ds_sc, 47.700*ds_sc, (ds_minus*49.400+ds_xmax)*ds_sc, 52.900*ds_sc);
		path_[8].quadTo((ds_minus*48.700+ds_xmax)*ds_sc, 57.900*ds_sc, (ds_minus*40.400+ds_xmax)*ds_sc, 58.900*ds_sc);
		path_[8].quadTo((ds_minus*33.100+ds_xmax)*ds_sc, 58.300*ds_sc, (ds_minus*32.200+ds_xmax)*ds_sc, 53.000*ds_sc);
		path_[8].quadTo((ds_minus*31.900+ds_xmax)*ds_sc, 48.300*ds_sc, (ds_minus*40.500+ds_xmax)*ds_sc, 45.000*ds_sc);
		
		// path_[9]  
		path_[9].moveTo((ds_minus*47.000+ds_xmax)*ds_sc, 45.700*ds_sc);
		path_[9].quadTo((ds_minus*43.800+ds_xmax)*ds_sc, 48.600*ds_sc, (ds_minus*37.400+ds_xmax)*ds_sc, 47.900*ds_sc);
		path_[9].quadTo((ds_minus*21.700+ds_xmax)*ds_sc, 45.400*ds_sc, (ds_minus*22.000+ds_xmax)*ds_sc, 31.200*ds_sc);
		path_[9].quadTo((ds_minus*22.500+ds_xmax)*ds_sc, 14.200*ds_sc, (ds_minus*39.300+ds_xmax)*ds_sc, 13.400*ds_sc);
		path_[9].quadTo((ds_minus*52.600+ds_xmax)*ds_sc, 13.000*ds_sc, (ds_minus*55.600+ds_xmax)*ds_sc, 28.300*ds_sc);
		path_[9].quadTo((ds_minus*59.100+ds_xmax)*ds_sc, 56.600*ds_sc, (ds_minus*46.500+ds_xmax)*ds_sc, 63.500*ds_sc);
		path_[9].quadTo((ds_minus*36.200+ds_xmax)*ds_sc, 69.700*ds_sc, (ds_minus*23.700+ds_xmax)*ds_sc, 65.300*ds_sc);
		path_[9].lineTo((ds_minus*24.900+ds_xmax)*ds_sc, 57.900*ds_sc);
		path_[9].quadTo((ds_minus*36.300+ds_xmax)*ds_sc, 60.400*ds_sc, (ds_minus*40.700+ds_xmax)*ds_sc, 56.600*ds_sc);
		path_[9].quadTo((ds_minus*46.000+ds_xmax)*ds_sc, 52.300*ds_sc, (ds_minus*47.000+ds_xmax)*ds_sc, 45.700*ds_sc);
		path_[9].moveTo((ds_minus*46.300+ds_xmax)*ds_sc, 29.900*ds_sc);
		path_[9].quadTo((ds_minus*46.000+ds_xmax)*ds_sc, 21.500*ds_sc, (ds_minus*38.600+ds_xmax)*ds_sc, 21.700*ds_sc);
		path_[9].quadTo((ds_minus*30.900+ds_xmax)*ds_sc, 22.100*ds_sc, (ds_minus*30.300+ds_xmax)*ds_sc, 30.700*ds_sc);
		path_[9].quadTo((ds_minus*31.500+ds_xmax)*ds_sc, 39.400*ds_sc, (ds_minus*39.100+ds_xmax)*ds_sc, 39.200*ds_sc);
		path_[9].quadTo((ds_minus*46.700+ds_xmax)*ds_sc, 38.800*ds_sc, (ds_minus*46.300+ds_xmax)*ds_sc, 29.900*ds_sc);


		g2d_image2.setColor(co_in);
		g2d_image2.fill(path_[image_num]);
		g2d_image2.setStroke(new BasicStroke(s_boder));
		g2d_image2.setColor(co_out);
		g2d_image2.draw(path_[image_num]);



		return buf_image2;
	}

}