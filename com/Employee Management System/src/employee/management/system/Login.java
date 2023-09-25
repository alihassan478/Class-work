package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {
    JTextField Iusername,Ipassword;
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username = new JLabel("Username: ");
        username.setBounds(40,20,100,30);
        add(username);

        Iusername = new JTextField();
        Iusername.setBounds(160,20,150,30);
        add(Iusername);

        JLabel password = new JLabel("Password: ");
        password.setBounds(40,60,100,30);
        add(password);

        Ipassword = new JTextField();
        Ipassword.setBounds(160 , 60 , 150 , 30);
        add(Ipassword);

        JButton b2 = new JButton("Login");
        b2.setFont(new Font("Arial" , Font.BOLD , 12));
        b2.setBounds(230 , 100 , 80,30);
        add(b2);

        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b2.addMouseListener(new MouseAdapter () {
            public void mouseEntered(MouseEvent e) {
                b2.setBackground(Color.darkGray);
            }

            public void mouseExited(MouseEvent e) {
                b2.setBackground(Color.BLACK);
            }


            public void mousePressed(MouseEvent e) {
                try {
                    String username = Iusername.getText();
                    String password = Ipassword.getText();

                    Conn c = new Conn();
//                    String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
//
//                    ResultSet rs = c.s.executeQuery(query);
//                    if(rs.next()) {
//                        setVisible(false);
//                    } else {
//                        JOptionPane.showMessageDialog(null,"Invalid username or password");
//                        setVisible(false);
//                    }
                    Connection connection = c.getConnection(); // Implement this method in Conn

                    String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    ResultSet rs = preparedStatement.executeQuery();

                    if(rs.next()) {
                        setVisible(false);
                        new Home();
                    } else {
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                        setVisible(false);
                    }

                } catch (Exception er) {
                    er.printStackTrace();
                }
            }
        });

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/user.png"));
        Image im = img1.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(im);
        JLabel img3 = new JLabel(img2);
        img3.setBounds(400,25,100,100);
        add(img3);

        setSize(600,300);
        setLocation(450,200);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Login();
    }
}
