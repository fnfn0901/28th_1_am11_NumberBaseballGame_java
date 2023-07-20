package practice_bbg;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinFrame extends JFrame {
    private JTextField userID;
    private JPasswordField userPW;
    private JPasswordField checkPW;
    private JButton okButton;

    public JoinFrame(){
        setTitle("회원가입");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel=new JPanel(new GridLayout(4,2,5,5));

        JLabel userIDJLabel=new JLabel("ID:");
        userID=new JTextField(15);
        userID.setDocument(new NoSpaceDocument());

        JLabel passwordLabel=new JLabel("PW:");
        userPW=new JPasswordField(15);
        userPW.setDocument(new NoSpaceDocument());
        
        JLabel checkPWJLabel=new JLabel("비밀번호 확인");
        checkPW=new JPasswordField(15);

        okButton=new JButton("Sign up");
        okButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                signUp();
            }
        });

        panel.add(userIDJLabel);
        panel.add(userID);
        panel.add(passwordLabel);
        panel.add(userPW);
        panel.add(checkPWJLabel);
        panel.add(checkPW);
        panel.add(new JLabel());
        panel.add(okButton);

        add(panel);

        setVisible(true);
    }

    private void signUp(){
        while(true){
            String enterID=userID.getText();
            String enterPW=new String(userPW.getPassword());
            String enterCheckPW=new String(checkPW.getPassword());

            //id, pw 빈칸인 경우
            if(enterID.isEmpty()||enterPW.isEmpty()){
                JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 바르게 입력해주세요.", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //pw 8자리 미만인 경우
            else if(enterPW.length()<8){
                JOptionPane.showMessageDialog(this, "비밀번호가 8자리 미만입니다.", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            //비밀번호 확인 에러
            else if(!enterPW.equals(enterCheckPW)){
                JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //성공
            else{
                JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다.","회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->new JoinFrame());
    }
}

//id pw에 스페이스 들어가지 않도록 하기
class NoSpaceDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str != null && !str.contains(" ")) {
            super.insertString(offs, str, a);
        }
    }
}