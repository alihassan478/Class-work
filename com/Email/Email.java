package com.Email;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPass=10 ;
    private String alternateEmail;
    private String companySuffix = "nextbigthing.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //call method asking for department
        this.department = setDept();

        // call a method that give password
        this.password = randomPass(defaultPass);
        System.out.println("Password: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // ask for the department

    private String setDept() {
        System.out.println("DEPARTMENT CODES\n 1 for sales \n 2 for Development \n 3 for Accounting \n 0 for none\n Enter the Department code : ");
        Scanner in = new Scanner(System.in);
        int dept = in.nextInt();
        if(dept == 1){ return "Sales";}
        else if(dept == 2){ return "Development";}
        else if(dept == 3){ return "Accounting";}
        else if(dept == 0){ return "None";}
        else {
            return "";
        }
    }

    // Generate random password
    private String randomPass(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        char[] password = new char[length];
        for(int i = 0 ; i<length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }


    // set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    //alternate emails

    public void alternateEmail(String email){
        this.alternateEmail = email;
    }

    // change the password
    public void changePass(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMail Box Capacity: " + mailBoxCapacity + "mb";
    }
}
