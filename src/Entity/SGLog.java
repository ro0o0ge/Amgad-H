/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "s_g_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SGLog.findAll", query = "SELECT s FROM SGLog s")
    , @NamedQuery(name = "SGLog.findBySGId", query = "SELECT s FROM SGLog s WHERE s.sGId = :sGId")
    , @NamedQuery(name = "SGLog.findByGrade", query = "SELECT s FROM SGLog s WHERE s.grade = :grade")})
public class SGLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "S_G_ID")
    private Long sGId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "GRADE")
    private BigDecimal grade;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID")
    @ManyToOne
    private Student sId;
    @JoinColumn(name = "SU_ID", referencedColumnName = "SU_ID")
    @ManyToOne
    private Subjects suId;

    public SGLog() {
    }

    public SGLog(Long sGId) {
        this.sGId = sGId;
    }

    public SGLog(Long sGId, BigDecimal grade) {
        this.sGId = sGId;
        this.grade = grade;
    }

    public Long getSGId() {
        return sGId;
    }

    public void setSGId(Long sGId) {
        this.sGId = sGId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public Student getSId() {
        return sId;
    }

    public void setSId(Student sId) {
        this.sId = sId;
    }

    public Subjects getSuId() {
        return suId;
    }

    public void setSuId(Subjects suId) {
        this.suId = suId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sGId != null ? sGId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SGLog)) {
            return false;
        }
        SGLog other = (SGLog) object;
        if ((this.sGId == null && other.sGId != null) || (this.sGId != null && !this.sGId.equals(other.sGId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SGLog[ sGId=" + sGId + " ]";
    }
    
}
