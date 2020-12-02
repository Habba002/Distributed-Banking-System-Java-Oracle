
package thealeke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transfer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="amount2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emp_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="r_address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="r_branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="r_firstname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="r_lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="r_middlename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="r_phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="s_address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="s_branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="s_firstname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="s_lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="s_middlename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transfer", propOrder = {
    "amount",
    "amount2",
    "date",
    "empId",
    "id",
    "rAddress",
    "rBranch",
    "rFirstname",
    "rLastname",
    "rMiddlename",
    "rPhone",
    "sAddress",
    "sBranch",
    "sFirstname",
    "sLastname",
    "sMiddlename",
    "status"
})
public class Transfer {

    protected int amount;
    protected String amount2;
    protected String date;
    @XmlElement(name = "emp_id")
    protected int empId;
    protected int id;
    @XmlElement(name = "r_address")
    protected String rAddress;
    @XmlElement(name = "r_branch")
    protected String rBranch;
    @XmlElement(name = "r_firstname")
    protected String rFirstname;
    @XmlElement(name = "r_lastname")
    protected String rLastname;
    @XmlElement(name = "r_middlename")
    protected String rMiddlename;
    @XmlElement(name = "r_phone")
    protected String rPhone;
    @XmlElement(name = "s_address")
    protected String sAddress;
    @XmlElement(name = "s_branch")
    protected String sBranch;
    @XmlElement(name = "s_firstname")
    protected String sFirstname;
    @XmlElement(name = "s_lastname")
    protected String sLastname;
    @XmlElement(name = "s_middlename")
    protected String sMiddlename;
    protected int status;

    /**
     * Gets the value of the amount property.
     * 
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(int value) {
        this.amount = value;
    }

    /**
     * Gets the value of the amount2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount2() {
        return amount2;
    }

    /**
     * Sets the value of the amount2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount2(String value) {
        this.amount2 = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the empId property.
     * 
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * Sets the value of the empId property.
     * 
     */
    public void setEmpId(int value) {
        this.empId = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the rAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRAddress() {
        return rAddress;
    }

    /**
     * Sets the value of the rAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRAddress(String value) {
        this.rAddress = value;
    }

    /**
     * Gets the value of the rBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRBranch() {
        return rBranch;
    }

    /**
     * Sets the value of the rBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRBranch(String value) {
        this.rBranch = value;
    }

    /**
     * Gets the value of the rFirstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRFirstname() {
        return rFirstname;
    }

    /**
     * Sets the value of the rFirstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRFirstname(String value) {
        this.rFirstname = value;
    }

    /**
     * Gets the value of the rLastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRLastname() {
        return rLastname;
    }

    /**
     * Sets the value of the rLastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRLastname(String value) {
        this.rLastname = value;
    }

    /**
     * Gets the value of the rMiddlename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRMiddlename() {
        return rMiddlename;
    }

    /**
     * Sets the value of the rMiddlename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRMiddlename(String value) {
        this.rMiddlename = value;
    }

    /**
     * Gets the value of the rPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRPhone() {
        return rPhone;
    }

    /**
     * Sets the value of the rPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRPhone(String value) {
        this.rPhone = value;
    }

    /**
     * Gets the value of the sAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSAddress() {
        return sAddress;
    }

    /**
     * Sets the value of the sAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSAddress(String value) {
        this.sAddress = value;
    }

    /**
     * Gets the value of the sBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBranch() {
        return sBranch;
    }

    /**
     * Sets the value of the sBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBranch(String value) {
        this.sBranch = value;
    }

    /**
     * Gets the value of the sFirstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFirstname() {
        return sFirstname;
    }

    /**
     * Sets the value of the sFirstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFirstname(String value) {
        this.sFirstname = value;
    }

    /**
     * Gets the value of the sLastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLastname() {
        return sLastname;
    }

    /**
     * Sets the value of the sLastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLastname(String value) {
        this.sLastname = value;
    }

    /**
     * Gets the value of the sMiddlename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMiddlename() {
        return sMiddlename;
    }

    /**
     * Sets the value of the sMiddlename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMiddlename(String value) {
        this.sMiddlename = value;
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

}
