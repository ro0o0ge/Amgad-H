/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findByTId", query = "SELECT t FROM Teacher t WHERE t.tId = :tId")
    , @NamedQuery(name = "Teacher.findByMonthlySalary", query = "SELECT t FROM Teacher t WHERE t.monthlySalary = :monthlySalary")
    , @NamedQuery(name = "Teacher.findByStatus", query = "SELECT t FROM Teacher t WHERE t.status = :status")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "T_ID")
    private Integer tId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTHLY_SALARY")
    private Double monthlySalary;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne
    private Persons pId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tId")
    private List<Schedule> scheduleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tId")
    private List<TeacherSubjects> teacherSubjectsList;
    @OneToMany(mappedBy = "tId")
    private List<Payroll> payrollList;
    @OneToMany(mappedBy = "tId")
    private List<EmployeeAttendance> employeeAttendanceList;

    public Teacher() {
    }

    public Teacher(Integer tId) {
        this.tId = tId;
    }

    public Teacher(Integer tId, String status) {
        this.tId = tId;
        this.status = status;
    }

    public Integer getTId() {
        return tId;
    }

    public void setTId(Integer tId) {
        this.tId = tId;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Persons getPId() {
        return pId;
    }

    public void setPId(Persons pId) {
        this.pId = pId;
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

    @XmlTransient
    public List<Payroll> getPayrollList() {
        return payrollList;
    }

    public void setPayrollList(List<Payroll> payrollList) {
        this.payrollList = payrollList;
    }

    @XmlTransient
    public List<EmployeeAttendance> getEmployeeAttendanceList() {
        return employeeAttendanceList;
    }

    public void setEmployeeAttendanceList(List<EmployeeAttendance> employeeAttendanceList) {
        this.employeeAttendanceList = employeeAttendanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tId != null ? tId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.tId == null && other.tId != null) || (this.tId != null && !this.tId.equals(other.tId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Teacher[ tId=" + tId + " ]";
    }
    
}
