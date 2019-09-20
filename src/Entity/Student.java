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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findBySId", query = "SELECT s FROM Student s WHERE s.sId = :sId")
    , @NamedQuery(name = "Student.findByStatus", query = "SELECT s FROM Student s WHERE s.status = :status")
    , @NamedQuery(name = "Student.findByAgeOnOct", query = "SELECT s FROM Student s WHERE s.ageOnOct = :ageOnOct")
    , @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.pId.name like :name")
    , @NamedQuery(name = "Student.findBySerialNo", query = "SELECT s FROM Student s WHERE s.serialNo = :serialNo")
    , @NamedQuery(name = "Student.findBySeatingNo", query = "SELECT s FROM Student s WHERE s.seatingNo = :seatingNo")})
public class Student implements Serializable {

    @Column(name = "SSTUDENT_CODE")
    private String sstudentCode;

    @Column(name = "OBSERVE_1")
    private String observe1;
    @Column(name = "OBSERVE_2")
    private String observe2;

    @Column(name = "REGISTRY_STATUS")
    private String registryStatus;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "S_ID")
    private Long sId;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "AGE_ON_OCT")
    private String ageOnOct;
    @Basic(optional = false)
    @Column(name = "SERIAL_NO")
    private String serialNo;
 
    @Column(name = "SEATING_NO")
    private String seatingNo;
    @OneToMany(mappedBy = "sId")
    private List<SGLog> sGLogList;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @OneToOne(fetch = FetchType.EAGER)
    private Persons pId;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "sId")
    private List<StudentAttendance> studentAttendanceList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "sId")
    private List<ActualGrades> actualGradesList;
    @OneToOne(mappedBy = "sId", fetch = FetchType.EAGER)
    private ClassStudents classStudentsList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "sId")
    private List<StudentExpenses> studentExpensesList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "sId")
    private List<StudentNotes> studentNotesList;

    public Student() {
    }

    public Student(Long sId) {
        this.sId = sId;
    }

    public Student(Long sId, String status, String ageOnOct, String serialNo) {
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

    public StringProperty statusProperty() {
        if (status.equals("1")) {
            return new SimpleStringProperty("مرفوض");
        } else if (status.equals("2")) {
            return new SimpleStringProperty("منتظر");
        } else {
            return new SimpleStringProperty("مقبول");
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgeOnOct() {
        return ageOnOct;
    }
    
    public StringProperty AgeOnOctProperty() {
//        ageOnOct=ageOnOct.replace("Y", "س");
//        ageOnOct=ageOnOct.replace("M","ش");
//        ageOnOct=ageOnOct.replace("D", "ي");
        return new SimpleStringProperty(ageOnOct);
    }

    public void setAgeOnOct(String ageOnOct) {
        this.ageOnOct = ageOnOct;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public StringProperty serialProperty() {
        return new SimpleStringProperty(serialNo);
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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
    public ClassStudents getClassStudentsList() {
        return classStudentsList;
    }

    public void setClassStudentsList(ClassStudents classStudentsList) {
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

    public String getRegistryStatus() {
        return registryStatus;
    }

    public void setRegistryStatus(String registryStatus) {
        this.registryStatus = registryStatus;
    }

    public String getObserve1() {
        return observe1;
    }

    public void setObserve1(String observe1) {
        this.observe1 = observe1;
    }

    public String getObserve2() {
        return observe2;
    }

    public void setObserve2(String observe2) {
        this.observe2 = observe2;
    }

    public String getSstudentCode() {
        return sstudentCode;
    }

    public void setSstudentCode(String sstudentCode) {
        this.sstudentCode = sstudentCode;
    }

}
