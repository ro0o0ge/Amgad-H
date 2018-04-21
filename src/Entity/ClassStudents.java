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
@Table(name = "class_students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassStudents.findAll", query = "SELECT c FROM ClassStudents c")
        ,@NamedQuery(name = "ClassStudents.findBysId", query = "SELECT c FROM ClassStudents c WHERE c.sId = :sId")
    , @NamedQuery(name = "ClassStudents.findByCsId", query = "SELECT c FROM ClassStudents c WHERE c.csId = :csId")})
public class ClassStudents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CS_ID")
    private Integer csId;
    @OneToMany(mappedBy = "csId")
    private List<FinalGrades> finalGradesList;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID")
    @OneToOne
    private Student sId;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
    @ManyToOne
    private Classes cId;

    public ClassStudents() {
    }

    public ClassStudents(Integer csId) {
        this.csId = csId;
    }

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
    }

    @XmlTransient
    public List<FinalGrades> getFinalGradesList() {
        return finalGradesList;
    }

    public void setFinalGradesList(List<FinalGrades> finalGradesList) {
        this.finalGradesList = finalGradesList;
    }

    public Student getSId() {
        return sId;
    }

    public void setSId(Student sId) {
        this.sId = sId;
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
        hash += (csId != null ? csId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassStudents)) {
            return false;
        }
        ClassStudents other = (ClassStudents) object;
        if ((this.csId == null && other.csId != null) || (this.csId != null && !this.csId.equals(other.csId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ClassStudents[ csId=" + csId + " ]";
    }
    
}
