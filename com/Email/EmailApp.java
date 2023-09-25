package com.Email;

public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("Ali" , "Hassan");
        em1.changePass("AKHKJ!@#");
        em1.alternateEmail("alihassan478@icloud.com");
        em1.setMailBoxCapacity(1000);
        System.out.println(em1.showInfo());
//        System.out.println("Alternate email is: " +em1.getAlternateEmail());
//        System.out.println("New password: "+em1.getPassword());
//        System.out.println("Mail Box Capacity: "+em1.getMailBoxCapacity());

    }

}
