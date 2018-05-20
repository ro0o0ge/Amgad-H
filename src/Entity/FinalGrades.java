/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "final_grades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalGrades.findAll", query = "SELECT f FROM FinalGrades f")
    , @NamedQuery(name = "FinalGrades.findByGId", query = "SELECT f FROM FinalGrades f WHERE f.gId = :gId")
    , @NamedQuery(name = "FinalGrades.findBysuId", query = "SELECT f FROM FinalGrades f WHERE f.suId = :suId")
    , @NamedQuery(name = "FinalGrades.findByGrade", query = "SELECT f FROM FinalGrades f WHERE f.grade = :grade")})
public class FinalGrades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "G_ID")
    private Integer gId;
    @Basic(optional = false)
    @Column(name = "GRADE")
    private int grade;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
    @ManyToOne
    private Classes cId;
    @JoinColumn(name = "SU_ID", referencedColumnName = "SU_ID")
    @OneToOne
    private Subjects suId;
    @OneToMany(mappedBy = "gId")
    private List<GradeDetail> gradeDetailList;

    public FinalGrades() {
    }

    public FinalGrades(Integer gId) {
        this.gId = gId;
    }

    public FinalGrades(Integer gId, int grade) {
        this.gId = gId;
        this.grade = grade;
    }

    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Classes getCsId() {
        return cId;
    }

    public void setCsId(Classes cId) {
        this.cId = cId;
    }

    public Subjects getSuId() {
        return suId;
    }

    public void setSuId(Subjects suId) {
        this.suId = suId;
    }

    @XmlTransient
    public List<GradeDetail> getGradeDetailList() {
        return gradeDetailList;
    }

    public void setGradeDetailList(List<GradeDetail> gradeDetailList) {
        this.gradeDetailList = gradeDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gId != null ? gId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalGrades)) {
            return false;
        }
        FinalGrades other = (FinalGrades) object;
        if ((this.gId == null && other.gId != null) || (this.gId != null && !this.gId.equals(other.gId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FinalGrades[ gId=" + gId + " ]";
    }

}
