
package entity;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Deposite implements SQLData, Serializable{
      
       private int amount;
       private String amount2;
       private int s_account_no;
       private int r_account_no;
       private String branch;
       private String s_phone_no;
       private String dates;
       private String role;
       private String sql_type;

    public Deposite() {
    }

    public Deposite(int AMOUNT, String AMOUNT2, int FROM, int TO, String BRANCH, String PNUM, String date, String role) {
        this.amount = AMOUNT;
        this.amount2 = AMOUNT2;
        this.s_account_no = FROM;
        this.r_account_no = TO;
        this.branch = BRANCH;
        this.s_phone_no = PNUM;
        this.dates = date;
        this.role = role;
    }

    public int getAMOUNT() {
        return amount;
    }

    public void setAMOUNT(int AMOUNT) {
        this.amount = AMOUNT;
    }

    public String getAMOUNT2() {
        return amount2;
    }

    public void setAMOUNT2(String AMOUNT2) {
        this.amount2 = AMOUNT2;
    }

    public int getFROM() {
        return s_account_no;
    }

    public void setFROM(int FROM) {
        this.s_account_no = FROM;
    }

    public int getTO() {
        return r_account_no;
    }

    public void setTO(int TO) {
        this.r_account_no = TO;
    }

    public String getBRANCH() {
        return branch;
    }

    public void setBRANCH(String BRANCH) {
        this.branch = BRANCH;
    }

    public String getPNUM() {
        return s_phone_no;
    }

    public void setPNUM(String PNUM) {
        this.s_phone_no = PNUM;
    }

    public String getDate() {
        return dates;
    }

    public void setDate(String date) {
        this.dates = date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        amount = stream.readInt();
        amount2 = stream.readString();
        r_account_no = stream.readInt();
        s_account_no = stream.readInt();
        branch = stream.readString();
        s_phone_no = stream.readString();
        dates = stream.readString();
        role = stream.readString();
        sql_type = typeName;
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeInt(amount);
        stream.writeString(amount2);
        stream.writeInt(r_account_no);
        stream.writeInt(s_account_no);
        stream.writeString(branch);
        stream.writeString(s_phone_no);
        stream.writeString(dates);
        stream.writeString(role);
    }
      
}