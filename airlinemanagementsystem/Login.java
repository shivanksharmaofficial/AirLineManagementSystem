package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton submit, reset, close;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);     //default layout is bottomlayout
        
        JLabel lblusername = new JLabel("Username");     //jlaabel class to add ovrer the frame
        lblusername.setBounds(20, 20, 100, 20);     //(position from left,top, length,height of label)
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);
        
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);      //to perform action
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400, 250);
        setLocation(600, 250);
        setVisible(true);        //deafult is false
    }
           //overriding the abstract actionPerformed() method of actionLIstener
    public void actionPerformed(ActionEvent ae) {     
        if (ae.getSource() == submit) {          
            String username = tfusername.getText();
            String password = tfpassword.getText();    //getText()is depricated for JPasswordFIELd
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    new Home();
                    setVisible(false);      
                } else {
                    // add dialogbox
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password"); //not formating so null
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == close) {
            setVisible(false);        //frame become invisible
            
            
        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}