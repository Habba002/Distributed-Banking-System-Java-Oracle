/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author Habib
 */
public class User implements SQLData{
    private String sql_type;
    
    private String firstname;
    private String middlename;
    private String lastname;
    private String gender;
    private String phone_no;
    private String occupation;
    private String photo;    

    public String getSql_type() {
        return sql_type;
    }

    public void setSql_type(String sql_type) {
        this.sql_type = sql_type;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        firstname = stream.readString();
        middlename = stream.readString();
        lastname = stream.readString();
        gender = stream.readString();  
        phone_no = stream.readString();
        occupation = stream.readString();
        photo = stream.readString();
        sql_type = typeName;
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(firstname);
        stream.writeString(middlename);
        stream.writeString(lastname);
        stream.writeString(photo);
        stream.writeString(gender);
        stream.writeString(occupation);
        stream.writeString(phone_no);
    }
}