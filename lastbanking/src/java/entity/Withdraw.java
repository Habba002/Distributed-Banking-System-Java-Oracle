package entity ;



import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Withdraw implements SQLData, Serializable {

    private int account_no;
    private int amount;
    private String amount2;
    private int emp_id;
    private String dates;
    
    private String sql_type;

    public Withdraw() {
    }

    public Withdraw(int ACNUMBER, int AMOUNT, String AMOUNT2, int EMP) {
        this.account_no = ACNUMBER;
        this.amount = AMOUNT;
        this.amount2 = AMOUNT2;
        this.emp_id=EMP;
    }

    public int getEMP() {
        return emp_id;
    }

    public void setEMP(int EMP) {
        this.emp_id = EMP;
    }

    public int getACNUMBER() {
        return account_no;
    }

    public void setACNUMBER(int ACNUMBER) {
        this.account_no = ACNUMBER;
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

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getDates() {
        return dates;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        account_no = stream.readInt();
        amount = stream.readInt();
        dates = stream.readString();
        emp_id = stream.readInt();
        amount2 = stream.readString();
        sql_type = typeName;
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeInt(account_no);
        stream.writeInt(amount);
        stream.writeString(dates);
        stream.writeInt(emp_id);
        stream.writeString(amount2);
    }
}
