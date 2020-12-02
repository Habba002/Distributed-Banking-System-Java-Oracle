package entity;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Transfer implements Serializable {

    private int amount;
    private String amount2;
    private String s_branch;
    private String s_firstname;
    private String s_middlename;
    private String s_lastname;
    private String s_address;
    private String dates;
    private String r_firstname;
    private String r_middlename;
    private String r_lastname;
    private String r_address;
    private String r_phone;
    private String r_branch;
    private int emp_id;
    private int id;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   

    public Transfer() {
    }

    public String getAmount2() {
        return amount2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount2(String amount2) {
        this.amount2 = amount2;
    }

    public String getS_branch() {
        return s_branch;
    }

    public void setS_branch(String s_branch) {
        this.s_branch = s_branch;
    }

    public String getS_firstname() {
        return s_firstname;
    }

    public void setS_firstname(String s_firstname) {
        this.s_firstname = s_firstname;
    }

    public String getS_middlename() {
        return s_middlename;
    }

    public void setS_middlename(String s_middlename) {
        this.s_middlename = s_middlename;
    }

    public String getS_lastname() {
        return s_lastname;
    }

    public void setS_lastname(String s_lastname) {
        this.s_lastname = s_lastname;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return dates;
    }

    public void setDate(String date) {
        this.dates = date;
    }

    public String getR_firstname() {
        return r_firstname;
    }

    public void setR_firstname(String r_firstname) {
        this.r_firstname = r_firstname;
    }

    public String getR_middlename() {
        return r_middlename;
    }

    public void setR_middlename(String r_middlename) {
        this.r_middlename = r_middlename;
    }

    public String getR_lastname() {
        return r_lastname;
    }

    public void setR_lastname(String r_lastname) {
        this.r_lastname = r_lastname;
    }

    public String getR_address() {
        return r_address;
    }

    public void setR_address(String r_address) {
        this.r_address = r_address;
    }

    public String getR_phone() {
        return r_phone;
    }

    public void setR_phone(String r_phone) {
        this.r_phone = r_phone;
    }

    public String getR_branch() {
        return r_branch;
    }

    public void setR_branch(String r_branch) {
        this.r_branch = r_branch;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
}