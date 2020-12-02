package entity;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Employee implements Serializable{
    
    private int id;
    private User userinfo;
    private Address addressinfo;
    private String dates;
    private int status; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(User userinfo) {
        this.userinfo = userinfo;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Address getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(Address addressinfo) {
        this.addressinfo = addressinfo;
    }
}
