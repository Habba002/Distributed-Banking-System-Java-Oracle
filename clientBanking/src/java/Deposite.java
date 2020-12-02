


import java.io.Serializable;

public class Deposite implements Serializable{
      
       private int AMOUNT;
       private String AMOUNT2;
       private int FROM;
       private int TO;
       private String BRANCH;
       private String PNUM;
       private String date;
       private String role;

    public Deposite() {
    }

    public Deposite(int AMOUNT, String AMOUNT2, int FROM, int TO, String BRANCH, String PNUM, String date, String role) {
        this.AMOUNT = AMOUNT;
        this.AMOUNT2 = AMOUNT2;
        this.FROM = FROM;
        this.TO = TO;
        this.BRANCH = BRANCH;
        this.PNUM = PNUM;
        this.date = date;
        this.role = role;
    }

    public int getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(int AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getAMOUNT2() {
        return AMOUNT2;
    }

    public void setAMOUNT2(String AMOUNT2) {
        this.AMOUNT2 = AMOUNT2;
    }

    public int getFROM() {
        return FROM;
    }

    public void setFROM(int FROM) {
        this.FROM = FROM;
    }

    public int getTO() {
        return TO;
    }

    public void setTO(int TO) {
        this.TO = TO;
    }

    public String getBRANCH() {
        return BRANCH;
    }

    public void setBRANCH(String BRANCH) {
        this.BRANCH = BRANCH;
    }

    public String getPNUM() {
        return PNUM;
    }

    public void setPNUM(String PNUM) {
        this.PNUM = PNUM;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

  
       
}