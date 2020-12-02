
package thealeke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transaction1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transaction1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="role1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accnum1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaction1", propOrder = {
    "role1",
    "id1",
    "accnum1"
})
public class Transaction1 {

    protected String role1;
    protected int id1;
    protected int accnum1;

    /**
     * Gets the value of the role1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole1() {
        return role1;
    }

    /**
     * Sets the value of the role1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole1(String value) {
        this.role1 = value;
    }

    /**
     * Gets the value of the id1 property.
     * 
     */
    public int getId1() {
        return id1;
    }

    /**
     * Sets the value of the id1 property.
     * 
     */
    public void setId1(int value) {
        this.id1 = value;
    }

    /**
     * Gets the value of the accnum1 property.
     * 
     */
    public int getAccnum1() {
        return accnum1;
    }

    /**
     * Sets the value of the accnum1 property.
     * 
     */
    public void setAccnum1(int value) {
        this.accnum1 = value;
    }

}
