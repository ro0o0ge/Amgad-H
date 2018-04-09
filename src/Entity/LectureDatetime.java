/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "lecture_datetime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LectureDatetime.findAll", query = "SELECT l FROM LectureDatetime l")
    , @NamedQuery(name = "LectureDatetime.findByLecId", query = "SELECT l FROM LectureDatetime l WHERE l.lecId = :lecId")
    , @NamedQuery(name = "LectureDatetime.findByLecDay", query = "SELECT l FROM LectureDatetime l WHERE l.lecDay = :lecDay")
    , @NamedQuery(name = "LectureDatetime.findByLecTime", query = "SELECT l FROM LectureDatetime l WHERE l.lecTime = :lecTime")})
public class LectureDatetime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LEC_ID")
    private Integer lecId;
    @Basic(optional = false)
    @Column(name = "LEC_DAY")
    private String lecDay;
    @Basic(optional = false)
    @Column(name = "LEC_TIME")
    private String lecTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecId")
    private List<Schedule> scheduleList;

    public LectureDatetime() {
    }

    public LectureDatetime(Integer lecId) {
        this.lecId = lecId;
    }

    public LectureDatetime(Integer lecId, String lecDay, String lecTime) {
        this.lecId = lecId;
        this.lecDay = lecDay;
        this.lecTime = lecTime;
    }

    public Integer getLecId() {
        return lecId;
    }

    public void setLecId(Integer lecId) {
        this.lecId = lecId;
    }

    public String getLecDay() {
        return lecDay;
    }

    public void setLecDay(String lecDay) {
        this.lecDay = lecDay;
    }

    public String getLecTime() {
        return lecTime;
    }

    public void setLecTime(String lecTime) {
        this.lecTime = lecTime;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecId != null ? lecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LectureDatetime)) {
            return false;
        }
        LectureDatetime other = (LectureDatetime) object;
        if ((this.lecId == null && other.lecId != null) || (this.lecId != null && !this.lecId.equals(other.lecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.LectureDatetime[ lecId=" + lecId + " ]";
    }
    
}
