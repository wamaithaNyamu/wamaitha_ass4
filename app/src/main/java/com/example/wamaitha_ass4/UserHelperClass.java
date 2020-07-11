package com.example.wamaitha_ass4;


public class UserHelperClass {
    String fname,lname,username,password,domain,account,description;

    public UserHelperClass() {

    }

    public UserHelperClass(String fname, String lname, String username, String password, String domain, String account, String description) {

        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.domain = domain;
        this.account = account;
        this.description = description;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }



    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }




    public String getUsername() {
        return username;
    }

    public void setUserame(String name) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }



    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


