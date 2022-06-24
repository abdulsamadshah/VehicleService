package com.example.vehicleservice;

public class users {
    String name,email,countryname;

    public users(String name, String email, String countryname) {
        this.name = name;
        this.email = email;
        this.countryname = countryname;
    }

    public users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
