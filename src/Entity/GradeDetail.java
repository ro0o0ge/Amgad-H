/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "grade_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradeDetail.findAll", query = "SELECT g FROM GradeDetail g")
    ,@NamedQuery(name = "GradeDetail.deleteById", query = "DELETE  FROM GradeDetail g where g.gdId = :gdId")
    , @NamedQuery(name = "GradeDetail.findByGdId", query = "SELECT g FROM GradeDetail g WHERE g.gdId = :gdId")
    , @NamedQuery(name = "GradeDetail.findBySubjectId", query = "SELECT g FROM GradeDetail g WHERE g.gId.suId = :suId")
    , @NamedQuery(name = "GradeDetail.findByGrade", query = "SELECT g FROM GradeDetail g WHERE g.grade = :grade")
    , @NamedQuery(name = "GradeDetail.findByGradeDetail", query = "SELECT g FROM GradeDetail g WHERE g.gradeDetail = :gradeDetail")})
public class GradeDetail implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "GRADE")
    private double grade;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GD_ID")
    private Integer gdId;
    @Basic(optional = false)
    @Column(name = "GRADE_DETAIL")
    private String gradeDetail;
    @OneToMany(mappedBy = "gdId")
    private List<ActualGrades> actualGradesList;
    @JoinColumn(name = "G_ID", referencedColumnName = "G_ID")
    @ManyToOne
    private FinalGrades gId;

    public GradeDetail() {
    }

    public GradeDetail(Integer gdId) {
        this.gdId = gdId;
    }

    public GradeDetail(Integer gdId, double grade, String gradeDetail) {
        this.gdId = gdId;
        this.grade = grade;
        this.gradeDetail = gradeDetail;
    }

    public Integer getGdId() {
        return gdId;
    }

    public void setGdId(Integer gdId) {
        this.gdId = gdId;
    }

    public StringProperty GradeProperty() {
        return new SimpleStringProperty(String.valueOf(grade));
    }

    public String getGradeDetail() {
        return gradeDetail;
    }

    public StringProperty GradeDescProperty() {
        return new SimpleStringProperty(gradeDetail);
    }

    public void setGradeDetail(String gradeDetail) {
        this.gradeDetail = gradeDetail;
    }

    @XmlTransient
    public List<ActualGrades> getActualGradesList() {
        return actualGradesList;
    }

    public void setActualGradesList(List<ActualGrades> actualGradesList) {
        this.actualGradesList = actualGradesList;
    }

    public FinalGrades getGId() {
        return gId;
    }

    public void setGId(FinalGrades gId) {
        this.gId = gId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gdId != null ? gdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradeDetail)) {
            return false;
        }
        GradeDetail other = (GradeDetail) object;
        if ((this.gdId == null && other.gdId != null) || (this.gdId != null && !this.gdId.equals(other.gdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.GradeDetail[ gdId=" + gdId + " ]";
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
