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
@Table(name = "student_expenses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentExpenses.findAll", query = "SELECT s FROM StudentExpenses s")
    , @NamedQuery(name = "StudentExpenses.findBySteId", query = "SELECT s FROM StudentExpenses s WHERE s.steId = :steId")
    , @NamedQuery(name = "StudentExpenses.findByAmount", query = "SELECT s FROM StudentExpenses s WHERE s.amount = :amount")
    , @NamedQuery(name = "StudentExpenses.findBySteType", query = "SELECT s FROM StudentExpenses s WHERE s.steType = :steType")
    , @NamedQuery(name = "StudentExpenses.findBySteDate", query = "SELECT s FROM StudentExpenses s WHERE s.steDate = :steDate")})
public class StudentExpenses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STE_ID")
    private Long steId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Basic(optional = false)
    @Column(name = "STE_TYPE")
    private String steType;
    @Basic(optional = false)
    @Column(name = "STE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date steDate;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID")
    @ManyToOne
    private Student sId;

    public StudentExpenses() {
    }

    public StudentExpenses(Long steId) {
        this.steId = steId;
    }

    public StudentExpenses(Long steId, BigDecimal amount, String steType, Date steDate) {
        this.steId = steId;
        this.amount = amount;
        this.steType = steType;
        this.steDate = steDate;
    }

    public Long getSteId() {
        return steId;
    }

    public void setSteId(Long steId) {
        this.steId = steId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSteType() {
        return steType;
    }

    public void setSteType(String steType) {
        this.steType = steType;
    }

    public Date getSteDate() {
        return steDate;
    }

    public void setSteDate(Date steDate) {
        this.steDate = steDate;
    }

    public Student getSId() {
        return sId;
    }

    public void setSId(Student sId) {
        this.sId = sId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (steId != null ? steId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentExpenses)) {
            return false;
        }
        StudentExpenses other = (StudentExpenses) object;
        if ((this.steId == null && other.steId != null) || (this.steId != null && !this.steId.equals(other.steId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StudentExpenses[ steId=" + steId + " ]";
    }

}
