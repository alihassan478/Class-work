package com.singer;

public class Singer {
    private String name;
    private String gender;
    private String nationality;
    private Date debutYear;

    //Constructors


    public Singer(String name, String gender, String nationality, Date debutYear) {
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.debutYear = debutYear;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDebutYear(Date debutYear) {
        this.debutYear = debutYear;
    }

    // Getters


    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getDebutYear() {
        return debutYear;
    }

    // to String
    @Override
    public String toString() {
        return String.format("\nSinger name : %s\nGender : %s\nNationality : %s\nDebut Year : %s" , name,nationality,gender,debutYear);
    }
}
