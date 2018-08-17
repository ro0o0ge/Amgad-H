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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.findByStId", query = "SELECT s FROM Staff s WHERE s.stId = :stId")
    , @NamedQuery(name = "Staff.findByMonthlySalary", query = "SELECT s FROM Staff s WHERE s.monthlySalary = :monthlySalary")
    , @NamedQuery(name = "Staff.findByStatus", query = "SELECT s FROM Staff s WHERE s.status = :status")})
public class Staff implements Serializable {

    @Column(name = "STAFF_CATEGORY")
    private String staffCategory;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTHLY_SALARY")
    private Double monthlySalary;
    @Basic(optional = false)
    @Column(name = "SERIAL_NO")
    private String serialNo;
    @Basic(optional = false)
    @Column(name = "STAFF_TYPE")
    private String staffType;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ST_ID")
    private Integer stId;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne
    private Persons pId;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "stId")
    private List<EmployeeAttendance> employeeAttendanceList;

    public Staff() {
    }

    public Staff(Integer stId) {
        this.stId = stId;
    }

    public Staff(Integer stId, String status) {
        this.stId = stId;
        this.status = status;
    }

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getStatus() {
        return status;
    }
    
    public StringProperty statusProperty() {
        if (status.equals("1")) {
            return new SimpleStringProperty("يعمل");
        } else {
            return new SimpleStringProperty("لا يعمل");
        }
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
    public List<EmployeeAttendance> getEmployeeAttendanceList() {
        return employeeAttendanceList;
    }

    public void setEmployeeAttendanceList(List<EmployeeAttendance> employeeAttendanceList) {
        this.employeeAttendanceList = employeeAttendanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stId != null ? stId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.stId == null && other.stId != null) || (this.stId != null && !this.stId.equals(other.stId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Staff[ stId=" + stId + " ]";
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }
    
}
