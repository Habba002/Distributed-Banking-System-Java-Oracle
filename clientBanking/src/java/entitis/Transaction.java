package entitis;

public class Transaction {

    private String type;
    private String date;
    private String executedby;
    private int amount;
    private int accnum;
    private String name;
    

    public Transaction() {
    }

    public Transaction(String type, String date, String executedby, int amount, int accnum, String name) {
        this.type = type;
        this.date = date;
        this.executedby = executedby;
        this.amount = amount;
        this.accnum = accnum;
        this.name = name;
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExecutedby() {
        return executedby;
    }

    public void setExecutedby(String executedby) {
        this.executedby = executedby;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAccnum() {
        return accnum;
    }

    public void setAccnum(int accnum) {
        this.accnum = accnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
