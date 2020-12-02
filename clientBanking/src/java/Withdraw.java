



import java.io.Serializable;

public class Withdraw implements Serializable {

    private int ACNUMBER;
    private int AMOUNT;
    private String AMOUNT2;
    private String EMP;

    public Withdraw() {
    }

    public Withdraw(int ACNUMBER, int AMOUNT, String AMOUNT2, String EMP) {
        this.ACNUMBER = ACNUMBER;
        this.AMOUNT = AMOUNT;
        this.AMOUNT2 = AMOUNT2;
        this.EMP=EMP;
    }

    public String getEMP() {
        return EMP;
    }

    public void setEMP(String EMP) {
        this.EMP = EMP;
    }

    public int getACNUMBER() {
        return ACNUMBER;
    }

    public void setACNUMBER(int ACNUMBER) {
        this.ACNUMBER = ACNUMBER;
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

}
