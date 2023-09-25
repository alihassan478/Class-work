package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame {
    JTable jtable;
    Choice employeeid;
    JButton search,print,update,back;

    ViewEmployee() {
//        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        employeeid = new Choice();
        employeeid.setBounds(425,90,150,40);
        add(employeeid);

        JLabel text = new JLabel("All Employees");
        text.setBounds(350,30,250,40);
        text.setFont(new Font("Arial",Font.BOLD,30));
        add(text);


        JLabel subtext = new JLabel("Search By Id");
        subtext.setBounds(330,80,450,40);
        subtext.setFont(new Font("Arial",Font.PLAIN,15));
        add(subtext);


        try {
            Conn conn = new Conn();
            Connection connection = conn.getConnection();
            String selectQuery = "SELECT * FROM employee";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String empid = rs.getString("empid");
                System.out.println("Employee ID: " + empid); // Add this line for debugging
                employeeid.add(empid);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }


        jtable = new JTable();




        try {
            Conn conn = new Conn();
            Connection connection = conn.getConnection();
            String selectQuery = "SELECT * FROM employee";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs != null) {
                // Use DbUtils to convert ResultSet to a TableModel and set it to the JTable
                jtable.setModel(DbUtils.resultSetToTableModel(rs));
            } else {
                JOptionPane.showMessageDialog(null, "No data found.");
            }



            rs.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBorderPainted(false);
        search.setFocusPainted(false);
        search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        search.setBounds(250,130,90,30);
        add(search);

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String query = "SELECT * FROM employee WHERE empid='"+employeeid.getSelectedItem()+"'";

                try {
                    Conn conn = new Conn();
                    Connection connection = conn.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet rs = preparedStatement.executeQuery();
                    jtable.setModel(DbUtils.resultSetToTableModel(rs));
                } catch(Exception err) {
                    err.printStackTrace();
                }
            }
        });

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBorderPainted(false);
        update.setFocusPainted(false);
        update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.setBounds(350,130,90,30);
        add(update);

        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new Update(employeeid.getSelectedItem());
            }
        });

        print = new JButton("Print");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setBorderPainted(false);
        print.setFocusPainted(false);
        print.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        print.setBounds(450,130,90,30);
        add(print);

        print.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    jtable.print();
                } catch (PrinterException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBounds(550,130,90,30);
        add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new Home();
            }
        });
        JScrollPane jsp  = new JScrollPane(jtable);
        jsp.setBounds(0,180,900,600);
        add(jsp);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }


    public static void main(String[] args) {
        new ViewEmployee();
    }
}
