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
import javax.persistence.FetchType;
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
@Table(name = "subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s")
    , @NamedQuery(name = "Subjects.findBySuId", query = "SELECT s FROM Subjects s WHERE s.suId = :suId")
    , @NamedQuery(name = "Subjects.findBySyId", query = "SELECT s FROM Subjects s WHERE s.syId = :syId")
    , @NamedQuery(name = "Subjects.findBySyDesc", query = "SELECT s FROM Subjects s WHERE s.syId.syDesc = :syDesc")
    , @NamedQuery(name = "Subjects.findBySuDesc", query = "SELECT s FROM Subjects s WHERE s.suDesc = :suDesc")
    , @NamedQuery(name = "Subjects.findBySuDescAndSyId", query = "SELECT s FROM Subjects s WHERE s.suDesc = :suDesc and s.syId.syDesc = :syDesc")
    , @NamedQuery(name = "Subjects.findByMandatoryFlag", query = "SELECT s FROM Subjects s WHERE s.mandatoryFlag = :mandatoryFlag")})
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SU_ID")
    private Integer suId;
    @Basic(optional = false)
    @Column(name = "SU_DESC")
    private String suDesc;
    @Basic(optional = false)
    @Column(name = "MANDATORY_FLAG")
    private String mandatoryFlag;
    @OneToMany(mappedBy = "suId")
    private List<SGLog> sGLogList;
    @OneToOne(mappedBy = "suId")
    private FinalGrades finalGradesList;
    @JoinColumn(name = "SY_ID", referencedColumnName = "SY_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private StudyYears syId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suId")
    private List<Schedule> scheduleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suId")
    private List<TeacherSubjects> teacherSubjectsList;

    public Subjects() {
    }

    public Subjects(Integer suId) {
        this.suId = suId;
    }

    public Subjects(Integer suId, String suDesc, String mandatoryFlag) {
        this.suId = suId;
        this.suDesc = suDesc;
        this.mandatoryFlag = mandatoryFlag;
        
    }

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public String getSuDesc() {
        return suDesc;
    }

    public StringProperty SubDescProperty() {
        return new SimpleStringProperty(suDesc);
    }

    public void setSuDesc(String suDesc) {
        this.suDesc = suDesc;
    }

    public String getMandatoryFlag() {
        return mandatoryFlag;
    }

    public void setMandatoryFlag(String mandatoryFlag) {
        this.mandatoryFlag = mandatoryFlag;
    }

    @XmlTransient
    public List<SGLog> getSGLogList() {
        return sGLogList;
    }

    public void setSGLogList(List<SGLog> sGLogList) {
        this.sGLogList = sGLogList;
    }

    @XmlTransient
    public FinalGrades getFinalGradesList() {
        return finalGradesList;
    }

    public void setFinalGradesList(FinalGrades finalGradesList) {
        this.finalGradesList = finalGradesList;
    }

    public StudyYears getSyId() {
        return syId;
    }
    
    public StringProperty SyDescProperty() {
        return new SimpleStringProperty(syId.getSyDesc());
    }

    public void setSyId(StudyYears syId) {
        this.syId = syId;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @XmlTransient
    public List<TeacherSubjects> getTeacherSubjectsList() {
        return teacherSubjectsList;
    }

    public void setTeacherSubjectsList(List<TeacherSubjects> teacherSubjectsList) {
        this.teacherSubjectsList = teacherSubjectsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suId != null ? suId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.suId == null && other.suId != null) || (this.suId != null && !this.suId.equals(other.suId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Subjects[ suId=" + suId + " ]";
    }

   
}
