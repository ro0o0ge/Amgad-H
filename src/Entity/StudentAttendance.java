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
@Table(name = "student_attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentAttendance.findAll", query = "SELECT s FROM StudentAttendance s")
    , @NamedQuery(name = "StudentAttendance.findBySAtId", query = "SELECT s FROM StudentAttendance s WHERE s.sAtId = :sAtId")
    , @NamedQuery(name = "StudentAttendance.findByAbsentDay", query = "SELECT s FROM StudentAttendance s WHERE s.absentDay = :absentDay")
    , @NamedQuery(name = "StudentAttendance.findByAbDesc", query = "SELECT s FROM StudentAttendance s WHERE s.abDesc = :abDesc")
    , @NamedQuery(name = "StudentAttendance.findByEntryDate", query = "SELECT s FROM StudentAttendance s WHERE s.entryDate = :entryDate")})
public class StudentAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "S_AT_ID")
    private Long sAtId;
    @Basic(optional = false)
    @Column(name = "ABSENT_DAY")
    @Temporal(TemporalType.DATE)
    private Date absentDay;
    @Column(name = "AB_DESC")
    private String abDesc;
    @Basic(optional = false)
    @Column(name = "ENTRY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entryDate;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID")
    @ManyToOne
    private Student sId;

    public StudentAttendance() {
    }

    public StudentAttendance(Long sAtId) {
        this.sAtId = sAtId;
    }

    public StudentAttendance(Long sAtId, Date absentDay, Date entryDate) {
        this.sAtId = sAtId;
        this.absentDay = absentDay;
        this.entryDate = entryDate;
    }

    public Long getSAtId() {
        return sAtId;
    }

    public void setSAtId(Long sAtId) {
        this.sAtId = sAtId;
    }

    public Date getAbsentDay() {
        return absentDay;
    }
    
    public StringProperty DateProperty() {
        return new SimpleStringProperty(absentDay.toString());
    }

    public void setAbsentDay(Date absentDay) {
        this.absentDay = absentDay;
    }

    public String getAbDesc() {
        return abDesc;
    }
    
    public StringProperty DescProperty() {
        return new SimpleStringProperty(abDesc);
    }

    public void setAbDesc(String abDesc) {
        this.abDesc = abDesc;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
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
        hash += (sAtId != null ? sAtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentAttendance)) {
            return false;
        }
        StudentAttendance other = (StudentAttendance) object;
        if ((this.sAtId == null && other.sAtId != null) || (this.sAtId != null && !this.sAtId.equals(other.sAtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StudentAttendance[ sAtId=" + sAtId + " ]";
    }
    
}
