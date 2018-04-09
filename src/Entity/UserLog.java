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
@Table(name = "user_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserLog.findAll", query = "SELECT u FROM UserLog u")
    , @NamedQuery(name = "UserLog.findByLogDESC", query = "SELECT u FROM UserLog u WHERE u.logDESC = :logDESC")
    , @NamedQuery(name = "UserLog.findByLogDate", query = "SELECT u FROM UserLog u WHERE u.logDate = :logDate")
    , @NamedQuery(name = "UserLog.findByLogId", query = "SELECT u FROM UserLog u WHERE u.logId = :logId")})
public class UserLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "log_DESC")
    private String logDESC;
    @Basic(optional = false)
    @Column(name = "LOG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOG_ID")
    private Long logId;
    @JoinColumn(name = "U_ID", referencedColumnName = "U_ID")
    @ManyToOne(optional = false)
    private Users uId;

    public UserLog() {
    }

    public UserLog(Long logId) {
        this.logId = logId;
    }

    public UserLog(Long logId, String logDESC, Date logDate) {
        this.logId = logId;
        this.logDESC = logDESC;
        this.logDate = logDate;
    }

    public String getLogDESC() {
        return logDESC;
    }

    public void setLogDESC(String logDESC) {
        this.logDESC = logDESC;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Users getUId() {
        return uId;
    }

    public void setUId(Users uId) {
        this.uId = uId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLog)) {
            return false;
        }
        UserLog other = (UserLog) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UserLog[ logId=" + logId + " ]";
    }
    
}
