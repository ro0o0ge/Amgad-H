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
@Table(name = "actual_grades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActualGrades.findAll", query = "SELECT a FROM ActualGrades a")
    ,@NamedQuery(name = "ActualGrades.deleteById", query = "DELETE  FROM ActualGrades g where g.sId = :sId and g.gdId = :gdId")
    , @NamedQuery(name = "ActualGrades.findByAgId", query = "SELECT a FROM ActualGrades a WHERE a.agId = :agId")
    , @NamedQuery(name = "ActualGrades.findByGrade", query = "SELECT a FROM ActualGrades a WHERE a.grade = :grade")
    , @NamedQuery(name = "ActualGrades.findByGDate", query = "SELECT a FROM ActualGrades a WHERE a.gDate = :gDate")
    , @NamedQuery(name = "ActualGrades.findByGDesc", query = "SELECT a FROM ActualGrades a WHERE a.gDesc = :gDesc")})
public class ActualGrades implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "GRADE")
    private double grade;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AG_ID")
    private Long agId;
    @Basic(optional = true)
    @Column(name = "G_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gDate;
    @Column(name = "G_DESC")
    private String gDesc;
    @JoinColumn(name = "GD_ID", referencedColumnName = "GD_ID")
    @ManyToOne
    private GradeDetail gdId;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID")
    @ManyToOne
    private Student sId;

    public ActualGrades() {
    }

    public ActualGrades(Long agId) {
        this.agId = agId;
    }

    public ActualGrades(Long agId, double grade, Date gDate) {
        this.agId = agId;
        this.grade = grade;
        this.gDate = gDate;
    }

    public Long getAgId() {
        return agId;
    }

    public void setAgId(Long agId) {
        this.agId = agId;
    }

    public Date getGDate() {
        return gDate;
    }

    public void setGDate(Date gDate) {
        this.gDate = gDate;
    }

    public String getGDesc() {
        return gDesc;
    }

    public void setGDesc(String gDesc) {
        this.gDesc = gDesc;
    }

    public GradeDetail getGdId() {
        return gdId;
    }

    public void setGdId(GradeDetail gdId) {
        this.gdId = gdId;
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
        hash += (agId != null ? agId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActualGrades)) {
            return false;
        }
        ActualGrades other = (ActualGrades) object;
        if ((this.agId == null && other.agId != null) || (this.agId != null && !this.agId.equals(other.agId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ActualGrades[ agId=" + agId + " ]";
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
