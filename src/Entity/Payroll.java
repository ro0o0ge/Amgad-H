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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "payroll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payroll.findAll", query = "SELECT p FROM Payroll p")
    , @NamedQuery(name = "Payroll.findByPrId", query = "SELECT p FROM Payroll p WHERE p.prId = :prId")
    , @NamedQuery(name = "Payroll.findByAmount", query = "SELECT p FROM Payroll p WHERE p.amount = :amount")
    , @NamedQuery(name = "Payroll.findByPrType", query = "SELECT p FROM Payroll p WHERE p.prType = :prType")
    , @NamedQuery(name = "Payroll.findByPrDate", query = "SELECT p FROM Payroll p WHERE p.prDate = :prDate")})
public class Payroll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PR_ID")
    private Long prId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "PR_TYPE")
    private String prType;
    @Basic(optional = false)
    @Column(name = "PR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prDate;
    @JoinColumn(name = "T_ID", referencedColumnName = "T_ID")
    @ManyToOne
    private Teacher tId;
    @JoinColumn(name = "ST_ID", referencedColumnName = "ST_ID")
    @ManyToOne
    private Staff stId;

    public Payroll() {
    }

    public Payroll(Long prId) {
        this.prId = prId;
    }

    public Payroll(Long prId, BigDecimal amount, Date prDate) {
        this.prId = prId;
        this.amount = amount;
        this.prDate = prDate;
    }

    public Long getPrId() {
        return prId;
    }

    public void setPrId(Long prId) {
        this.prId = prId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPrType() {
        return prType;
    }

    public void setPrType(String prType) {
        this.prType = prType;
    }

    public Date getPrDate() {
        return prDate;
    }

    public void setPrDate(Date prDate) {
        this.prDate = prDate;
    }

    public Teacher getTId() {
        return tId;
    }

    public void setTId(Teacher tId) {
        this.tId = tId;
    }

    public Staff getStId() {
        return stId;
    }

    public void setStId(Staff stId) {
        this.stId = stId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prId != null ? prId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payroll)) {
            return false;
        }
        Payroll other = (Payroll) object;
        if ((this.prId == null && other.prId != null) || (this.prId != null && !this.prId.equals(other.prId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Payroll[ prId=" + prId + " ]";
    }
    
}
