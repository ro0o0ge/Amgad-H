/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findByClassDesc", query = "SELECT c FROM Schedule c WHERE c.cId.classDesc = :classDesc order by c.lecId")
    , @NamedQuery(name = "Schedule.findByScheduleId", query = "SELECT s FROM Schedule s WHERE s.scheduleId = :scheduleId")})
public class Schedule implements Serializable {

    @Basic(optional = false)
    @Column(name = "SU_ID")
    private String suId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SCHEDULE_ID")
    private Integer scheduleId;
    @JoinColumn(name = "LEC_ID", referencedColumnName = "LEC_ID")
    @ManyToOne(optional = false)
    private LectureDatetime lecId;
    @JoinColumn(name = "T_ID", referencedColumnName = "T_ID")
    @ManyToOne
    private Teacher tId;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
    @ManyToOne(optional = false)
    private Classes cId;

    public Schedule() {
    }

    public Schedule(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LectureDatetime getLecId() {
        return lecId;
    }

    public void setLecId(LectureDatetime lecId) {
        this.lecId = lecId;
    }

    public Teacher getTId() {
        return tId;
    }

    public void setTId(Teacher tId) {
        this.tId = tId;
    }

    public Classes getCId() {
        return cId;
    }

    public void setCId(Classes cId) {
        this.cId = cId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Schedule[ scheduleId=" + scheduleId + " ]";
    }

    public String getSuId() {
        return suId;
    }

    public void setSuId(String suId) {
        this.suId = suId;
    }

}
