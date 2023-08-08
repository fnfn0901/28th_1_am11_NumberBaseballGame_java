package Numbaseballgame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JDialog{
	JButton lb1;
	JButton jb1;
	int login = 0;
	int join = 0;
	
	JPanel jp1 = new JPanel();
	static ImageIcon background = new ImageIcon("img/backImage1.png");
	
	public StartFrame(JFrame frame) {
		
		super(frame, "StartFrame", true);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//sf1 = new JFrame();
		
		setVisible(false);
		setSize(1000,700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		jp1 = new JPanel(null){
		      
	         public void paintComponent(Graphics g) {
	            g.drawImage(background.getImage(), 0, 0, null);
	            setOpaque(false);
	            super.paintComponent(g);
	         }
	      };
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
				login = 1;
				join = 0;
				setVisible(false);
			}
		});
		
		jb1.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {

				//JoinFrame joi = new JoinFrame();
				join = 1;
				login = 0;
				setVisible(false);
			}
		});
	
	}
}