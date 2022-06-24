package com.example.vehicleservice.Worker;

public class workerUsers {
    String wusername, wuseremail, wuseraddress,statename,wimagedata;

    public workerUsers(String wusername, String wuseremail, String wuseraddress, String statename, String wimagedata) {
        this.wusername = wusername;
        this.wuseremail = wuseremail;
        this.wuseraddress = wuseraddress;
        this.statename = statename;
        this.wimagedata = wimagedata;
    }

    public workerUsers() {
    }

    public String getWusername() {
        return wusername;
    }

    public void setWusername(String wusername) {
        this.wusername = wusername;
    }

    public String getWuseremail() {
        return wuseremail;
    }

    public void setWuseremail(String wuseremail) {
        this.wuseremail = wuseremail;
    }

    public String getWuseraddress() {
        return wuseraddress;
    }

    public void setWuseraddress(String wuseraddress) {
        this.wuseraddress = wuseraddress;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getWimagedata() {
        return wimagedata;
    }

    public void setWimagedata(String wimagedata) {
        this.wimagedata = wimagedata;
    }
}