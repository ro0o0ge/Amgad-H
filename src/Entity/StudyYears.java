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
import javax.persistence.FetchType;
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
@Table(name = "study_years")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyYears.findAll", query = "SELECT s FROM StudyYears s")
    , @NamedQuery(name = "StudyYears.findBySyId", query = "SELECT s FROM StudyYears s WHERE s.syId = :syId")
    , @NamedQuery(name = "StudyYears.findBySyDesc", query = "SELECT s FROM StudyYears s WHERE s.syDesc = :syDesc")})
public class StudyYears implements Serializable {

    @OneToMany(mappedBy = "syId", fetch = FetchType.EAGER)
    private List<Classes> classesList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SY_ID")
    private Integer syId;
    @Basic(optional = false)
    @Column(name = "SY_DESC")
    private String syDesc;
    @OneToMany(mappedBy = "syId")
    private List<Subjects> subjectsList;

    public StudyYears() {
    }

    public StudyYears(Integer syId) {
        this.syId = syId;
    }

    public StudyYears(Integer syId, String syDesc) {
        this.syId = syId;
        this.syDesc = syDesc;
    }

    public Integer getSyId() {
        return syId;
    }

    public void setSyId(Integer syId) {
        this.syId = syId;
    }

    public String getSyDesc() {
        return syDesc;
    }

    public void setSyDesc(String syDesc) {
        this.syDesc = syDesc;
    }

    @XmlTransient
    public List<Subjects> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<Subjects> subjectsList) {
        this.subjectsList = subjectsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (syId != null ? syId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyYears)) {
            return false;
        }
        StudyYears other = (StudyYears) object;
        if ((this.syId == null && other.syId != null) || (this.syId != null && !this.syId.equals(other.syId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StudyYears[ syId=" + syId + " ]";
    }

    @XmlTransient
    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }
    
}
