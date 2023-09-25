package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame {
    JTextField tname , tfname , tsalary , taddress, tphone , temail;
    JDateChooser dcdob;
    JComboBox tedu;
    JButton back,add;

    JLabel empidd;

    Random rand = new Random();
    int Num = rand.nextInt(999999);

    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setFont(new Font("Arial" , Font.BOLD , 30));
        heading.setBounds(290,30,800,40);
        add(heading);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("serif" , Font.PLAIN,20));
        name.setBounds(50,150,150,30);
        add(name);

        tname = new JTextField();
        tname.setBounds(180,153,150,30);
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("serif" , Font.PLAIN,20));
        fname.setBounds(490,150,150,30);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(620,153,150,30);
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("serif" , Font.PLAIN,20));
        dob.setBounds(50,230,150,30);
        add(dob);

        dcdob = new JDateChooser();
        dcdob.setBounds(180,230,150,30);
        add(dcdob);

        JLabel salary = new JLabel("Salary");
        salary.setFont(new Font("serif" , Font.PLAIN,20));
        salary.setBounds(490,230,150,30);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(620,230,150,30);
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("serif" , Font.PLAIN,20));
        address.setBounds(50,310,150,30);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(180,310,150,30);
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("serif" , Font.PLAIN,20));
        phone.setBounds(490,310,150,30);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(620,310,150,30);
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("serif" , Font.PLAIN,20));
        email.setBounds(50,390,150,30);
        add(email);

        temail = new JTextField();
        temail.setBounds(180,390,150,30);
        add(temail);

        JLabel edu = new JLabel("Education");
        edu.setFont(new Font("serif" , Font.PLAIN,20));
        edu.setBounds(490,390,150,30);
        add(edu);

        String degree[] = {"BSCS" , "BSSE" , "BSAI" , "BSIT" , "BSDS" , "BBA" , "MBA"};
        tedu = new JComboBox(degree);
        tedu.setBackground(Color.WHITE);
        tedu.setForeground(Color.BLACK);
        tedu.setBounds(620,390,150,30);
        add(tedu);

        JLabel empid = new JLabel("Employee Id");
        empid.setFont(new Font("serif" , Font.PLAIN,20));
        empid.setBounds(50,470,150,30);
        add(empid);

        empidd = new JLabel("" + Num);
        empidd.setFont(new Font("serif",Font.PLAIN,20));
        empidd.setBounds(180,470,150,30);
        add(empidd);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBounds(270,550,150,50);
        add(back);

        add = new JButton("Add Employee");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor on hover

        add.setBounds(470,550,150,50);
        add(add);

        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String name = tname.getText();
                String fname = tfname.getText();
                String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
                String salary = tsalary.getText();
                String address = taddress.getText();
                String phone = tphone.getText();
                String email = temail.getText();
                String education = (String) tedu.getSelectedItem();
                String empid = empidd.getText();

                try {
                    Conn conn = new Conn();
                    Connection connection = conn.getConnection();

                    String query = "INSERT INTO employee (name, fname, dob, salary, address, phone, email, education, empid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1,name);
                    preparedStatement.setString(2,fname);
                    preparedStatement.setString(3,dob);
                    preparedStatement.setString(4,salary);
                    preparedStatement.setString(5,address);
                    preparedStatement.setString(6,phone);
                    preparedStatement.setString(7,email);
                    preparedStatement.setString(8,education);
                    preparedStatement.setString(9,empid);

                    int rs = preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"details added");
                    setVisible(false);


                } catch (Exception er){
                    er.printStackTrace();
                }
            }
        });

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Home();
                setVisible(false);
            }
        });


        setSize(900,700);
        setLocation(300,70);
        setVisible(true);

    }


    public static void main(String[] args) {
        new AddEmployee();
    }
}
