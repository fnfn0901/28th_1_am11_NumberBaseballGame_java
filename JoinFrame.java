package Numbaseballgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JoinFrame extends JDialog {
	JPanel backPanel = new JPanel(null);
	
	JLabel id_lab = new JLabel("ID: ");
	JLabel pw_lab = new JLabel("PW: ");
	
    JTextField userID_TF = new JTextField(15);
    JPasswordField userPW_TF = new JPasswordField(15);
	
	PlayFrame pf = null;
	
	JButton joinButton = new JButton("Join");
	JButton backStartFrame;
	Database dbd;
	
	int backStart = 0;
	
	String id_st;
	String pw_st;
	
	int isJoinSuccess = 0;
	
	
	//MainFrame mf = null;
    public JoinFrame(JFrame playFrame, PlayFrame m) {
    	super(playFrame, "Join", true);
    	
    	pf = m;
    	
        setSize(300, 200);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        id_lab.setBounds(10, 10, 50, 50);
        userID_TF.setBounds(70, 10, 150, 50);
        pw_lab.setBounds(10, 60, 50, 50);
        userPW_TF.setBounds(70, 60, 150, 50);
        joinButton.setBounds(10, 120, 130, 40);
        
        backStartFrame = new JButton("Back");
        backStartFrame.addActionListener(new BackButtonEvent());
        backStartFrame.setBounds(160, 120, 130, 40);
        
        backPanel.setSize(300, 200);
        add(backPanel);
        
        
        
        backPanel.add(id_lab);
        backPanel.add(userID_TF);
        backPanel.add(pw_lab);
        backPanel.add(userPW_TF);
        backPanel.add(joinButton);
        backPanel.add(backStartFrame);
        
        
        joinButton.addActionListener(new ButtonEvent());

        add(backPanel);
        
        
        dbd = new Database();
        
        setVisible(false);
    }
    
    class BackButtonEvent implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if (e.getSource() == backStartFrame) {
    			backStart = 1;
    			setVisible(false);
    		}
    	}
    }
    
    class ButtonEvent implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		JButton b = (JButton)e.getSource();
    		id_st = userID_TF.getText();
    		pw_st = "";
    		for (int i = 0; i < userPW_TF.getPassword().length;i++) {
    			pw_st = pw_st + userPW_TF.getPassword()[i];
    			
    		}
    		if(b.getText().equals("Join")) {
    			if(id_st.equals("")||pw_st.equals("")) {
    				JOptionPane.showMessageDialog(null, "Please write both id and password", "join failure", JOptionPane.ERROR_MESSAGE);
    				System.out.println("Join Failure : doesn't write both id and password");
    			}
    			else if(!id_st.equals("")&&!pw_st.equals("")) {
    				if (dbd.joinCheck(id_st, pw_st)) {
    					System.out.println("Join Success");
    					isJoinSuccess = 1;
    					JOptionPane.showMessageDialog(null, "Welcome");
    				}
    				else {
    					System.out.println("Join failure");
    					JOptionPane.showMessageDialog(null, "join failure");
    					userID_TF.setText("");
    					userPW_TF.setText("");
    				}
    			}
    			
    		}
    	}
    }
}
