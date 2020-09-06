package com.example.geedha.company_details_corporate;

public class Company {
    private String name;
    private String email;
    private String password;


    public Company(){}

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




    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +", password='" + getPassword() + "'" +
                "}";
    }
}
