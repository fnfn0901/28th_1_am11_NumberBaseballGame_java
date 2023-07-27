package Numbaseballgame;


import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JDialog {
	
	JPanel backPanel = new JPanel(null);
	
	JLabel id_lab = new JLabel("ID: ");
	JLabel pw_lab = new JLabel("PW: ");
	
    JTextField userID_TF = new JTextField(15);
    JPasswordField userPW_TF = new JPasswordField(15);
    
    String id_st;
	String pw_st;
    
    JButton loginButton;
    JButton backStartFrame;
    int backStart = 0;
    
    PlayFrame pf = null;
    
    Database dbd;
    
    int isLoginSuccess = 0;
    
    public LoginFrame(JFrame playFrame, PlayFrame m) {
        super(playFrame, "Login", true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        pf = m;
        setSize(300, 200);
        setLocationRelativeTo(null);

        
        backPanel.setSize(300, 200);
        add(backPanel);
        
        JLabel userIDLabel = new JLabel("ID:");

        JLabel passwordLabel = new JLabel("PW:");

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ButtonEvent());
        backStartFrame = new JButton("Back");
        backStartFrame.addActionListener(new BackButtonEvent());
        
        backPanel.add(id_lab);
        backPanel.add(userID_TF);
        backPanel.add(pw_lab);
        backPanel.add(userPW_TF);
        backPanel.add(loginButton);
        
        id_lab.setBounds(10, 10, 50, 50);
        userID_TF.setBounds(70, 10, 150, 50);
        pw_lab.setBounds(10, 60, 50, 50);
        userPW_TF.setBounds(70, 60, 150, 50);
        loginButton.setBounds(100, 120, 100, 50);

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
    		for (int i = 0; i < userPW_TF.getPassword().length; i++) {
    			pw_st = pw_st + userPW_TF.getPassword()[i];
    		}
    		if (b.getText().equals("Login")) {
    			if(id_st.equals("") || pw_st.equals("")) {
    				JOptionPane.showMessageDialog(null, "Please write your ID and PW", "Login failure", JOptionPane.ERROR_MESSAGE);
					System.out.println("Login failure > Not write ID and PW");
					
    			}
    			else if(id_st != null && pw_st != null) {
					if(dbd.logincheck(id_st, pw_st)) {	
						System.out.println("Login Success");
						isLoginSuccess = 1;
						JOptionPane.showMessageDialog(null, "Login Success");
						setVisible(false);
					} else {
						System.out.println("Login Failure > Not Correct Login Info");
						JOptionPane.showMessageDialog(null, "Login Failure");
					}
				}
    		}
    	}
    	
    }
}
