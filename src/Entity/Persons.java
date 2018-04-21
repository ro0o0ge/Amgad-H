/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "persons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persons.findAll", query = "SELECT p FROM Persons p")
    , @NamedQuery(name = "Persons.findByPId", query = "SELECT p FROM Persons p WHERE p.pId = :pId")
    , @NamedQuery(name = "Persons.findByName", query = "SELECT p FROM Persons p WHERE p.name = :name")
    , @NamedQuery(name = "Persons.findByGender", query = "SELECT p FROM Persons p WHERE p.gender = :gender")
    , @NamedQuery(name = "Persons.findByNationality", query = "SELECT p FROM Persons p WHERE p.nationality = :nationality")
    , @NamedQuery(name = "Persons.findByReligion", query = "SELECT p FROM Persons p WHERE p.religion = :religion")
    , @NamedQuery(name = "Persons.findByNationalId", query = "SELECT p FROM Persons p WHERE p.nationalId = :nationalId")
    , @NamedQuery(name = "Persons.findByAddress", query = "SELECT p FROM Persons p WHERE p.address = :address")
    , @NamedQuery(name = "Persons.findByDob", query = "SELECT p FROM Persons p WHERE p.dob = :dob")
    , @NamedQuery(name = "Persons.findByCreatedDate", query = "SELECT p FROM Persons p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "Persons.findByMaritalStatus", query = "SELECT p FROM Persons p WHERE p.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Persons.findByModifiedDate", query = "SELECT p FROM Persons p WHERE p.modifiedDate = :modifiedDate")
    , @NamedQuery(name = "Persons.findByHiringDate", query = "SELECT p FROM Persons p WHERE p.hiringDate = :hiringDate")
    , @NamedQuery(name = "Persons.findByQualification", query = "SELECT p FROM Persons p WHERE p.qualification = :qualification")
    , @NamedQuery(name = "Persons.findByGradYear", query = "SELECT p FROM Persons p WHERE p.gradYear = :gradYear")})
public class Persons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "P_ID")
    private Long pId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Basic(optional = false)
    @Column(name = "RELIGION")
    private String religion;
    @Basic(optional = false)
    @Column(name = "NATIONAL_ID")
    private String nationalId;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name = "HIRING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hiringDate;
    @Column(name = "QUALIFICATION")
    private String qualification;
    @Column(name = "GRAD_YEAR")
    private String gradYear;
    @OneToOne(mappedBy = "pId",fetch = FetchType.EAGER)
    private Student studentList;
    @OneToOne(mappedBy = "pId",fetch = FetchType.EAGER)
    private Teacher teacherList;
    @OneToOne(mappedBy = "pId",fetch = FetchType.EAGER)
    private Staff staffList;
    @OneToOne(mappedBy = "pId")
    private Users usersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId",fetch = FetchType.EAGER)
    private List<Contacts> contactsList;

    public Persons() {
    }

    public Persons(Long pId) {
        this.pId = pId;
    }

    public Persons(Long pId, String name, String gender, String nationality, String religion, String nationalId, String address, Date dob, Date createdDate, Date modifiedDate, Date hiringDate) {
        this.pId = pId;
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.religion = religion;
        this.nationalId = nationalId;
        this.address = address;
        this.dob = dob;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.hiringDate = hiringDate;
    }

    public Long getPId() {
        return pId;
    }

    public void setPId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public StringProperty NameProperty() {
        return new SimpleStringProperty(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public StringProperty DOBProperty() {
        return new SimpleStringProperty(dob.toString());
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public StringProperty createdDateProperty() {
        return new SimpleStringProperty(createdDate.toString());
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    @XmlTransient
    public Student getStudentList() {
        return studentList;
    }

    public void setStudentList(Student studentList) {
        this.studentList = studentList;
    }

    @XmlTransient
    public Teacher getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(Teacher teacherList) {
        this.teacherList = teacherList;
    }

    @XmlTransient
    public Staff getStaffList() {
        return staffList;
    }

    public void setStaffList(Staff staffList) {
        this.staffList = staffList;
    }

    @XmlTransient
    public Users getUsersList() {
        return usersList;
    }

    public void setUsersList(Users usersList) {
        this.usersList = usersList;
    }

    @XmlTransient
    public List<Contacts> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<Contacts> contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Persons[ pId=" + pId + " ]";
    }

}
