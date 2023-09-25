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

public class Update extends JFrame {
    JTextField tname , tfname , tsalary , taddress, tphone , temail;
    JDateChooser dcdob;
    JComboBox tedu;
    JButton back,add;

    JLabel empidd;

    String empID;

    Random rand = new Random();
    int Num = rand.nextInt(999999);

    Update(String empid){
        this.empID = empid;
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

        JLabel tlname = new JLabel();
        tlname.setBounds(180,153,150,30);
        add(tlname);

        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("serif" , Font.PLAIN,20));
        fname.setBounds(490,150,150,30);
        add(fname);

        JLabel tlfname = new JLabel();
        tlfname.setBounds(620,153,150,30);
        add(tlfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("serif" , Font.PLAIN,20));
        dob.setBounds(50,230,150,30);
        add(dob);

        JLabel dcldob = new JLabel();
        dcldob.setBounds(180,230,150,30);
        add(dcldob);

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

//        JLabel empID = new JLabel("Employee Id");
//        empID.setFont(new Font("serif" , Font.PLAIN,20));
//        empID.setBounds(50,470,150,30);
//        add(empID);

        empidd = new JLabel();
        empidd.setFont(new Font("serif",Font.PLAIN,20));
        empidd.setBounds(180,470,150,30);
        add(empidd);

        try {
            Conn c = new Conn();
            Connection connection = c.getConnection();
            String query = "SELECT * FROM employee WHERE empid='"+empID+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                tlname.setText(rs.getString("name"));
                tlfname.setText(rs.getString("fname"));
                dcldob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBounds(270,550,150,50);
        add(back);

        add = new JButton("Update Employee");
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
                String salary = tsalary.getText();
                String address = taddress.getText();
                String phone = tphone.getText();
                String email = temail.getText();

                try {
                    Conn conn = new Conn();
                    Connection connection = conn.getConnection();

                    String queryString = "UPDATE employee SET  salary=?, address=?, phone=?, email=? WHERE empid=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(queryString);

                    // Set values for the placeholders
                    preparedStatement.setString(1, salary);
                    preparedStatement.setString(2, address);
                    preparedStatement.setString(3, phone);
                    preparedStatement.setString(4, email);
                    preparedStatement.setString(5, empID);

                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"details updated");
                    setVisible(false);
                    new Home();


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
        new Update("");
    }
}
