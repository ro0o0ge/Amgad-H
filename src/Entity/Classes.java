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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "classes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "SELECT c FROM Classes c")
    , @NamedQuery(name = "Classes.findByCId", query = "SELECT c FROM Classes c WHERE c.cId = :cId")
    , @NamedQuery(name = "Classes.findByClassDesc", query = "SELECT c FROM Classes c WHERE c.classDesc = :classDesc")})
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "C_ID")
    private Integer cId;
    @Basic(optional = false)
    @Column(name = "CLASS_DESC")
    private String classDesc;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cId")
    private List<Schedule> scheduleList;
    @OneToMany(mappedBy = "cId")
    private List<ClassStudents> classStudentsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cId")
    private List<StaffClasses> staffClassesList;

    public Classes() {
    }

    public Classes(Integer cId) {
        this.cId = cId;
    }

    public Classes(Integer cId, String classDesc) {
        this.cId = cId;
        this.classDesc = classDesc;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getClassDesc() {
        return classDesc;
    }
    
    public StringProperty ClassDescProperty() {
        return new SimpleStringProperty(classDesc);
    }
  

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @XmlTransient
    public List<ClassStudents> getClassStudentsList() {
        return classStudentsList;
    }

    public void setClassStudentsList(List<ClassStudents> classStudentsList) {
        this.classStudentsList = classStudentsList;
    }

    @XmlTransient
    public List<StaffClasses> getStaffClassesList() {
        return staffClassesList;
    }

    public void setStaffClassesList(List<StaffClasses> staffClassesList) {
        this.staffClassesList = staffClassesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Classes[ cId=" + cId + " ]";
    }
    
}
