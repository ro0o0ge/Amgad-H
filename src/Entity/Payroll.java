/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
//    , @NamedQuery(name = "Payroll.find",
//            query = "SELECT p FROM Payroll p WHERE p.pId.teacherList.status='1'")
//    , @NamedQuery(name = "Payroll.findforBonus",
//            query = "SELECT p FROM Payroll p WHERE p.pId.staffList.status='1'")
    , @NamedQuery(name = "Payroll.findByPrId", query = "SELECT p FROM Payroll p WHERE p.prId = :prId")
    , @NamedQuery(name = "Payroll.findByAmount", query = "SELECT p FROM Payroll p WHERE p.amount = :amount")
    , @NamedQuery(name = "Payroll.findByPrType", query = "SELECT p FROM Payroll p WHERE p.prType = :prType")
    , @NamedQuery(name = "Payroll.findByPrDate", query = "SELECT p FROM Payroll p WHERE p.prDate = :prDate")})
public class Payroll implements Serializable {

    @Column(name = "PR_Notes")
    private String pRNotes;
    @Column(name = "PR_TYPE_BONUS")
    private String prTypeBonus;
    @Basic(optional = false)
    @Column(name = "PR_STATUS")
    private boolean prStatus;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne(optional = false)
    private Persons pId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PR_ID")
    private Long prId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private double amount;
    @Column(name = "PR_TYPE")
    private String prType;
    @Column(name = "PR_DATE")
    @Temporal(TemporalType.DATE)
    private Date prDate;

    public Payroll() {
    }

    public Payroll(Long prId) {
        this.prId = prId;
    }

    public Payroll(Long prId, double amount, Date prDate) {
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

    public double getAmount() {
        return amount;
    }

    public StringProperty AmountProperty() {

        return new SimpleStringProperty(String.valueOf(amount));
    }

    public StringProperty PenaltyAmountProperty() {
//        System.out.println(Integer.valueOf(String.valueOf(amount)));
        return new SimpleStringProperty((int) amount + " أيام");
    }

    public void setAmount(double amount) {
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

    public StringProperty DateProperty() {
        return new SimpleStringProperty(prDate.toString());
    }

    public void setPrDate(Date prDate) {
        this.prDate = prDate;
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

    public String getPRNotes() {
        return pRNotes;
    }

    public StringProperty NoteProperty() {
        return new SimpleStringProperty(pRNotes);
    }

    public void setPRNotes(String pRNotes) {
        this.pRNotes = pRNotes;
    }

    public String getPrTypeBonus() {
        return prTypeBonus;
    }

    public StringProperty TypeBonusProperty() {
        return new SimpleStringProperty(prTypeBonus);
    }

    public void setPrTypeBonus(String prTypeBonus) {
        this.prTypeBonus = prTypeBonus;
    }

    public boolean getPrStatus() {
        return prStatus;
    }

    public BooleanProperty statusProperty() {
        return new SimpleBooleanProperty(prStatus);
    }

    public void setPrStatus(boolean prStatus) {
        this.prStatus = prStatus;
    }

    public Persons getPId() {
        return pId;
    }

    public void setPId(Persons pId) {
        this.pId = pId;
    }

}
