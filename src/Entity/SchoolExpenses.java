/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
    , @NamedQuery(name = "SchoolExpenses.findByIssuedBy", query = "SELECT s FROM SchoolExpenses s WHERE s.issuedBy = :issuedBy")})
public class SchoolExpenses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SCE_ID")
    private Long sceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Basic(optional = false)
    @Column(name = "SCE_TYPE")
    private String sceType;
    @Basic(optional = false)
    @Column(name = "SCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sceDate;
    @Basic(optional = false)
    @Column(name = "ISSUED_BY")
    private String issuedBy;

    public SchoolExpenses() {
    }

    public SchoolExpenses(Long sceId) {
        this.sceId = sceId;
    }

    public SchoolExpenses(Long sceId, BigDecimal amount, String sceType, Date sceDate, String issuedBy) {
        this.sceId = sceId;
        this.amount = amount;
        this.sceType = sceType;
        this.sceDate = sceDate;
        this.issuedBy = issuedBy;
    }

    public Long getSceId() {
        return sceId;
    }

    public void setSceId(Long sceId) {
        this.sceId = sceId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public void setSceDate(Date sceDate) {
        this.sceDate = sceDate;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
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
    
}
