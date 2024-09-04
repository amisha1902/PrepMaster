package com.example.interviewprep;

public class ReadWriteuserdetails {
    public String   age, institution, email, pass;
    public ReadWriteuserdetails(){};
    public  ReadWriteuserdetails(String Email, String Age, String Institution, String Password){
        this.age = Age;
        this.email=Email;
        this.institution = Institution;
        this.pass= Password;
    }
}
