
package thealeke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for employee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="employee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressinfo" type="{http://thealeke/}address" minOccurs="0"/>
 *         &lt;element name="dates" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "employee", propOrder = {
    "addressinfo",
    "dates",
    "id",
    "status",
    "userinfo"
})
public class Employee {

    protected Address addressinfo;
    protected String dates;
    protected int id;
    protected int status;
    protected User userinfo;

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
