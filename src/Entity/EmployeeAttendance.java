/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
@Table(name = "employee_attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeAttendance.findAll", query = "SELECT e FROM EmployeeAttendance e")
    , @NamedQuery(name = "EmployeeAttendance.findByEaId", query = "SELECT e FROM EmployeeAttendance e WHERE e.eaId = :eaId")
    , @NamedQuery(name = "EmployeeAttendance.findByEaDate", query = "SELECT e FROM EmployeeAttendance e WHERE e.eaDate = :eaDate")
    , @NamedQuery(name = "EmployeeAttendance.findByStatus", query = "SELECT e FROM EmployeeAttendance e WHERE e.status = :status")
    , @NamedQuery(name = "EmployeeAttendance.findByAbscent", query = "SELECT e FROM EmployeeAttendance e WHERE e.abscent = :abscent")
    , @NamedQuery(name = "EmployeeAttendance.findByAbscenceType", query = "SELECT e FROM EmployeeAttendance e WHERE e.abscenceType = :abscenceType")
    , @NamedQuery(name = "EmployeeAttendance.findByArrive", query = "SELECT e FROM EmployeeAttendance e WHERE e.arrive = :arrive")
    , @NamedQuery(name = "EmployeeAttendance.findByLeave", query = "SELECT e FROM EmployeeAttendance e WHERE e.leave = :leave")
    , @NamedQuery(name = "EmployeeAttendance.findByTimeAmount", query = "SELECT e FROM EmployeeAttendance e WHERE e.timeAmount = :timeAmount")
    , @NamedQuery(name = "EmployeeAttendance.findByEaDesc", query = "SELECT e FROM EmployeeAttendance e WHERE e.eaDesc = :eaDesc")})
public class EmployeeAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EA_ID")
    private Long eaId;
    @Basic(optional = false)
    @Column(name = "EA_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eaDate;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private boolean status;
    @Column(name = "ABSCENT")
    private Boolean abscent;
    @Column(name = "ABSCENCE_TYPE")
    private String abscenceType;
    @Column(name = "ARRIVE")
    private Boolean arrive;
    @Column(name = "LEAVE")
    private Boolean leave;
    @Column(name = "TIME_AMOUNT")
    private String timeAmount;
    @Column(name = "EA_DESC")
    private String eaDesc;
    @JoinColumn(name = "T_ID", referencedColumnName = "T_ID")
    @ManyToOne
    private Teacher tId;
    @JoinColumn(name = "ST_ID", referencedColumnName = "ST_ID")
    @ManyToOne
    private Staff stId;

    public EmployeeAttendance() {
    }

    public EmployeeAttendance(Long eaId) {
        this.eaId = eaId;
    }

    public EmployeeAttendance(Long eaId, Date eaDate, boolean status) {
        this.eaId = eaId;
        this.eaDate = eaDate;
        this.status = status;
    }

    public Long getEaId() {
        return eaId;
    }

    public void setEaId(Long eaId) {
        this.eaId = eaId;
    }

    public Date getEaDate() {
        return eaDate;
    }

    public void setEaDate(Date eaDate) {
        this.eaDate = eaDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Boolean getAbscent() {
        return abscent;
    }

    public void setAbscent(Boolean abscent) {
        this.abscent = abscent;
    }

    public String getAbscenceType() {
        return abscenceType;
    }

    public void setAbscenceType(String abscenceType) {
        this.abscenceType = abscenceType;
    }

    public Boolean getArrive() {
        return arrive;
    }

    public void setArrive(Boolean arrive) {
        this.arrive = arrive;
    }

    public Boolean getLeave() {
        return leave;
    }

    public void setLeave(Boolean leave) {
        this.leave = leave;
    }

    public String getTimeAmount() {
        return timeAmount;
    }

    public void setTimeAmount(String timeAmount) {
        this.timeAmount = timeAmount;
    }

    public String getEaDesc() {
        return eaDesc;
    }

    public void setEaDesc(String eaDesc) {
        this.eaDesc = eaDesc;
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
        hash += (eaId != null ? eaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeAttendance)) {
            return false;
        }
        EmployeeAttendance other = (EmployeeAttendance) object;
        if ((this.eaId == null && other.eaId != null) || (this.eaId != null && !this.eaId.equals(other.eaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EmployeeAttendance[ eaId=" + eaId + " ]";
    }
    
}
