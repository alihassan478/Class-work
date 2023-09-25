package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Remove extends JFrame {

    Choice cEmpid;

    JButton delete , back;


    Remove() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50,50,100,30);
        add(labelempid);

        cEmpid = new Choice();
        cEmpid.setBounds(200,50,170,30);
        add(cEmpid);

        try {
            Conn c = new Conn();
            Connection connection = c.getConnection();
            String query = "SELECT * FROM employee";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                cEmpid.add(rs.getString("empid"));
            }

        } catch (Exception err) {
            err.printStackTrace();
        }


        JLabel name = new JLabel("Name");
        name.setBounds(50,100,100,30);
        add(name);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50,150,100,30);
        add(phone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,200,100,30);
        add(email);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,150,30);
        add(lblemail);



        cEmpid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    Connection connection = c.getConnection();
                    String query = "SELECT * FROM employee WHERE empid= '"+cEmpid.getSelectedItem()+"'";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()){
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }

                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        });

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/jasd.jpg"));
        Image img2 = img1.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img4 = new JLabel(img3);
        img4.setBounds(600,30,300,300);
        add(img4);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor on hover
        back.setBounds(50,250,80,30);
        add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new Home();
            }
        });

        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBorderPainted(false);
        delete.setFocusPainted(false);
        delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor on hover
        delete.setBounds(150,250,80,30);
        add(delete);

        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Conn c = new Conn();
                    Connection connection = c.getConnection();
                    String query = "DELETE FROM employee WHERE empid='"+cEmpid.getSelectedItem()+"'";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);

                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully!");
                    setVisible(false);
                    new Home();


                } catch (Exception error) {
                    error.printStackTrace();
                }
            }
        });

        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Remove();
    }
}
