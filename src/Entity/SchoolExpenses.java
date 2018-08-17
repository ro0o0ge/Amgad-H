/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "school_expenses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolExpenses.findAll", query = "SELECT s FROM SchoolExpenses s")
    , @NamedQuery(name = "SchoolExpenses.findBySceId", query = "SELECT s FROM SchoolExpenses s WHERE s.sceId = :sceId")
    , @NamedQuery(name = "SchoolExpenses.findByAmount", query = "SELECT s FROM SchoolExpenses s WHERE s.amount = :amount")
    , @NamedQuery(name = "SchoolExpenses.findBySceType", query = "SELECT s FROM SchoolExpenses s WHERE s.sceType = :sceType")
    , @NamedQuery(name = "SchoolExpenses.findBySceDate", query = "SELECT s FROM SchoolExpenses s WHERE s.sceDate = :sceDate")
    , @NamedQuery(name = "SchoolExpenses.findByIssuedBy", query = "SELECT s FROM SchoolExpenses s WHERE s.issuedBy = :issuedBy")
    , @NamedQuery(name = "SchoolExpenses.findByIssuedTo", query = "SELECT s FROM SchoolExpenses s WHERE s.issuedTo = :issuedTo")})
public class SchoolExpenses implements Serializable {

    @Column(name = "Notes")
    private String notes;

    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private double amount;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SCE_ID")
    private Long sceId;
    @Column(name = "SCE_TYPE")
    private String sceType;
    @Basic(optional = false)
    @Column(name = "SCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sceDate;
    @Column(name = "ISSUED_BY")
    private String issuedBy;
    @Column(name = "ISSUED_TO")
    private String issuedTo;

    public SchoolExpenses() {
    }

    public SchoolExpenses(Long sceId) {
        this.sceId = sceId;
    }

    public SchoolExpenses(Long sceId, Double amount, Date sceDate) {
        this.sceId = sceId;
        this.amount = amount;
        this.sceDate = sceDate;
    }

    public Long getSceId() {
        return sceId;
    }

    public void setSceId(Long sceId) {
        this.sceId = sceId;
    }

    public String getSceType() {
        return sceType;
    }

    public void setSceType(String sceType) {
        this.sceType = sceType;
    }

    public Date getSceDate() {
        return sceDate;
    }

    public StringProperty DDateProperty() {
        return new SimpleStringProperty(sceDate.toString());
    }

    public void setSceDate(Date sceDate) {
        this.sceDate = sceDate;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public StringProperty IssuedByProperty() {
        return new SimpleStringProperty(issuedBy);
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public StringProperty IssuedToProperty() {
        return new SimpleStringProperty(issuedTo);
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sceId != null ? sceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchoolExpenses)) {
            return false;
        }
        SchoolExpenses other = (SchoolExpenses) object;
        if ((this.sceId == null && other.sceId != null) || (this.sceId != null && !this.sceId.equals(other.sceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SchoolExpenses[ sceId=" + sceId + " ]";
    }

    public double getAmount() {
        return amount;
    }

    public StringProperty AmountProperty() {
        return new SimpleStringProperty(Double.toString(amount));
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }
    
    public StringProperty NotesProperty() {
        return new SimpleStringProperty(notes);
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
