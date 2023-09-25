package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Splash extends JFrame {

    Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(60, 30, 1200, 60);
        heading.setFont(new Font("Arial", Font.PLAIN, 60));
        heading.setForeground(Color.BLACK);
        add(heading);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/18771.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1050, 500, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        JButton b1 = new JButton("CLICK HERE TO CONTINUE");
        b1.setFont(new Font("Arial", Font.BOLD, 16)); // Use a different font and size
        b1.setBounds(380, 400, 300, 70);

        // Customize the button appearance
        b1.setBackground(Color.BLACK); // Set a custom background color
        b1.setForeground(Color.WHITE); // Set the text color
        b1.setBorderPainted(false); // Remove button border
        b1.setFocusPainted(false); // Remove focus border
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor on hover

        // Add hover effect
        b1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b1.setBackground(Color.darkGray);
                b1.setForeground(Color.WHITE);// Change background color on hover
            }

            public void mouseExited(MouseEvent e) {
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);// Restore background color on exit
            }

            public void mousePressed(MouseEvent e) {
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
                setVisible(false);
                new Login();
            }
        });

        // Add the button to the frame
        image.add(b1);


        setSize(1170, 650);
        setLocation(200, 100);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Splash();
    }
}