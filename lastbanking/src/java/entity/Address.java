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
public class Address implements SQLData{
    private String sql_type;
    
    private String addressinfo;
    private String nationality;
    private String district;
    private String branch;

    public String getSql_type() {
        return sql_type;
    }

    public void setSql_type(String sql_type) {
        this.sql_type = sql_type;
    }

    public String getAddress() {
        return addressinfo;
    }

    public void setAddress(String addressinfo) {
        this.addressinfo = addressinfo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        addressinfo = stream.readString();
        district = stream.readString();
        branch = stream.readString();
        nationality = stream.readString();
        sql_type = typeName;
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(addressinfo);
        stream.writeString(nationality);
        stream.writeString(district);
        stream.writeString(branch);
    }
}