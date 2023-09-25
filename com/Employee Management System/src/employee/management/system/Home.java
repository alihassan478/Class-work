package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

    Home() {
        setLayout(null);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/Home.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1120,630,Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img4 = new JLabel(img3);
        img4.setBounds(0,0,1120,630);
        add(img4);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(50,50,800,40);
        heading.setFont(new Font("Arial" , Font.BOLD , 25));
        img4.add(heading);

        JLabel heading2 = new JLabel("Get all the details about the employees");
        heading2.setBounds(50,85,400,20);
        heading2.setFont(new Font("Arial" , Font.PLAIN , 15));
        img4.add(heading2);

        JButton add = new JButton("Add Employee");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor on hover
        add.setBounds(50,140,150,50);
        img4.add(add);

        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                add.setBackground(Color.darkGray);
                add.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                add.setForeground(Color.WHITE);
                add.setBackground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new AddEmployee();
            }
        });

        JButton view = new JButton("View Employee");
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.setBorderPainted(false);
        view.setFocusPainted(false);
        view.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        view.setBounds(220,140,150,50);
        img4.add(view);

        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                view.setBackground(Color.darkGray);
                view.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                view.setForeground(Color.WHITE);
                view.setBackground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new ViewEmployee();
            }
        });

        JButton update = new JButton("Update Employee");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBorderPainted(false);
        update.setFocusPainted(false);
        update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.setBounds(50,210,150,50);
        img4.add(update);

        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                update.setBackground(Color.darkGray);
                update.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                update.setForeground(Color.WHITE);
                update.setBackground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new ViewEmployee();
            }
        });

        JButton remove = new JButton("Remove Employee");
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.setBorderPainted(false);
        remove.setFocusPainted(false);
        remove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        remove.setBounds(220,210,150,50);
        img4.add(remove);

        remove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                remove.setBackground(Color.darkGray);
                remove.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                remove.setForeground(Color.WHITE);
                remove.setBackground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new Remove();
            }
        });
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Home.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_SMOOTH);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0, 0, 1120, 630);
//        add(image);

        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Home();
    }
}
