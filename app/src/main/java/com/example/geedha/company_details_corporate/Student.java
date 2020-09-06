package com.example.geedha.company_details_corporate;

public class Student {
    private String name;
    private String email;
    private String password;
    private float cgpa;
    private long phonenumber;

    public Student(){}

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String  getPassword()
    {
        return this.password;

    }
    public void setPassword(String password){
        this.password = password;
    }
    public float getCgpa(){
        return this.cgpa;
    }
    public void setCgpa(float cgpa){
        this.cgpa = cgpa;
    }
    public long getPhonenumber(){
        return this.phonenumber;
    }
    public void setPhonenumber(long phonenumber){
        this.phonenumber = phonenumber;
    }



    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +", password='" + getPassword() + "'" +", cgpa='" + getCgpa() + "'" +", phonenumber='" + getPhonenumber() + "'" +
                "}";
    }
}
