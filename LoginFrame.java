package practice_bbg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField userID;
    private JPasswordField userPW;
    private JButton okButton;

    public LoginFrame(){
        setTitle("로그인");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel=new JPanel(new GridLayout(3,2,5,5));

        JLabel userIDJLabel=new JLabel(("ID:"));
        userID=new JTextField(15);

        JLabel passwordLabel=new JLabel("PW:");
        userPW=new JPasswordField(15);

        okButton=new JButton("Login");
        okButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                login();
            }
        });

        panel.add(userIDJLabel);
        panel.add(userID);
        panel.add(passwordLabel);
        panel.add(userPW);
        panel.add(new JLabel());
        panel.add(okButton);

        add(panel);

        setVisible(true);
    }
        
    private void login(){
        String enterID=userID.getText();
        String enterPW=new String(userPW.getPassword());

        //id,pw 빈칸인 경우
        if(enterID.isEmpty()||enterPW.isEmpty()){
            JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 바르게 입력해주세요.", "로그인 오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "User ID: "+enterID+"\nPassword: "+enterPW, "Login Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->new LoginFrame());
        
    }
}
