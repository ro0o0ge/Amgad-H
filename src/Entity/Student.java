/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findBySId", query = "SELECT s FROM Student s WHERE s.sId = :sId")
    , @NamedQuery(name = "Student.findByStatus", query = "SELECT s FROM Student s WHERE s.status = :status")
    , @NamedQuery(name = "Student.findByAgeOnOct", query = "SELECT s FROM Student s WHERE s.ageOnOct = :ageOnOct")
    , @NamedQuery(name = "Student.findBySerialNo", query = "SELECT s FROM Student s WHERE s.serialNo = :serialNo")
    , @NamedQuery(name = "Student.findBySecretNo", query = "SELECT s FROM Student s WHERE s.secretNo = :secretNo")
    , @NamedQuery(name = "Student.findBySeatingNo", query = "SELECT s FROM Student s WHERE s.seatingNo = :seatingNo")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "S_ID")
    private Long sId;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @Column(name = "AGE_ON_OCT")
    @Temporal(TemporalType.DATE)
    private Date ageOnOct;
    @Basic(optional = false)
    @Column(name = "SERIAL_NO")
    private String serialNo;
    @Column(name = "SECRET_NO")
    private String secretNo;
    @Column(name = "SEATING_NO")
    private String seatingNo;
    @OneToMany(mappedBy = "sId")
    private List<SGLog> sGLogList;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne
    private Persons pId;
    @OneToMany(mappedBy = "sId")
    private List<StudentAttendance> studentAttendanceList;
    @OneToMany(mappedBy = "sId")
    private List<ActualGrades> actualGradesList;
    @OneToMany(mappedBy = "sId")
    private List<ClassStudents> classStudentsList;
    @OneToMany(mappedBy = "sId")
    private List<StudentExpenses> studentExpensesList;
    @OneToMany(mappedBy = "sId")
    private List<StudentNotes> studentNotesList;

    public Student() {
    }

    public Student(Long sId) {
        this.sId = sId;
    }

    public Student(Long sId, String status, Date ageOnOct, String serialNo) {
        this.sId = sId;
        this.status = status;
        this.ageOnOct = ageOnOct;
        this.serialNo = serialNo;
    }

    public Long getSId() {
        return sId;
    }

    public void setSId(Long sId) {
        this.sId = sId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAgeOnOct() {
        return ageOnOct;
    }

    public void setAgeOnOct(Date ageOnOct) {
        this.ageOnOct = ageOnOct;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSecretNo() {
        return secretNo;
    }

    public void setSecretNo(String secretNo) {
        this.secretNo = secretNo;
    }

    public String getSeatingNo() {
        return seatingNo;
    }

    public void setSeatingNo(String seatingNo) {
        this.seatingNo = seatingNo;
    }

    @XmlTransient
    public List<SGLog> getSGLogList() {
        return sGLogList;
    }

    public void setSGLogList(List<SGLog> sGLogList) {
        this.sGLogList = sGLogList;
    }

    public Persons getPId() {
        return pId;
    }

    public void setPId(Persons pId) {
        this.pId = pId;
    }

    @XmlTransient
    public List<StudentAttendance> getStudentAttendanceList() {
        return studentAttendanceList;
    }

    public void setStudentAttendanceList(List<StudentAttendance> studentAttendanceList) {
        this.studentAttendanceList = studentAttendanceList;
    }

    @XmlTransient
    public List<ActualGrades> getActualGradesList() {
        return actualGradesList;
    }

    public void setActualGradesList(List<ActualGrades> actualGradesList) {
        this.actualGradesList = actualGradesList;
    }

    @XmlTransient
    public List<ClassStudents> getClassStudentsList() {
        return classStudentsList;
    }

    public void setClassStudentsList(List<ClassStudents> classStudentsList) {
        this.classStudentsList = classStudentsList;
    }

    @XmlTransient
    public List<StudentExpenses> getStudentExpensesList() {
        return studentExpensesList;
    }

    public void setStudentExpensesList(List<StudentExpenses> studentExpensesList) {
        this.studentExpensesList = studentExpensesList;
    }

    @XmlTransient
    public List<StudentNotes> getStudentNotesList() {
        return studentNotesList;
    }

    public void setStudentNotesList(List<StudentNotes> studentNotesList) {
        this.studentNotesList = studentNotesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Student[ sId=" + sId + " ]";
    }
    
}
