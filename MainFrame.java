package practice_bbg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame {
	Frame1 f1;
	
	public MainFrame() {
		f1 = new Frame1();
		f1.jf1.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
