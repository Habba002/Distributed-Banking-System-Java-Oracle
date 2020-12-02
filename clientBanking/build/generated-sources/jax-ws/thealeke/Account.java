
package thealeke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="account">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account_no" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="account_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressinfo" type="{http://thealeke/}address" minOccurs="0"/>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dates" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userinfo" type="{http://thealeke/}user" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account", propOrder = {
    "accountNo",
    "accountType",
    "addressinfo",
    "balance",
    "dates",
    "empid",
    "status",
    "userinfo"
})
public class Account {

    @XmlElement(name = "account_no")
    protected int accountNo;
    @XmlElement(name = "account_type")
    protected String accountType;
    protected Address addressinfo;
    protected double balance;
    protected String dates;
    protected int empid;
    protected int status;
    protected User userinfo;

    /**
     * Gets the value of the accountNo property.
     * 
     */
    public int getAccountNo() {
        return accountNo;
    }

    /**
     * Sets the value of the accountNo property.
     * 
     */
    public void setAccountNo(int value) {
        this.accountNo = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the addressinfo property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddressinfo() {
        return addressinfo;
    }

    /**
     * Sets the value of the addressinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddressinfo(Address value) {
        this.addressinfo = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     */
    public void setBalance(double value) {
        this.balance = value;
    }

    /**
     * Gets the value of the dates property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDates() {
        return dates;
    }

    /**
     * Sets the value of the dates property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDates(String value) {
        this.dates = value;
    }

    /**
     * Gets the value of the empid property.
     * 
     */
    public int getEmpid() {
        return empid;
    }

    /**
     * Sets the value of the empid property.
     * 
     */
    public void setEmpid(int value) {
        this.empid = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the userinfo property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUserinfo() {
        return userinfo;
    }

    /**
     * Sets the value of the userinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUserinfo(User value) {
        this.userinfo = value;
    }

}
