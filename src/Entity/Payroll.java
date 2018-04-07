package Entity;
// Generated Mar 23, 2018 2:53:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Payroll generated by hbm2java
 */
public class Payroll  implements java.io.Serializable {


     private long prId;
     private Staff staff;
     private Teacher teacher;
     private BigDecimal amount;
     private String prType;
     private Date prDate;

    public Payroll() {
    }

	
    public Payroll(long prId, BigDecimal amount, Date prDate) {
        this.prId = prId;
        this.amount = amount;
        this.prDate = prDate;
    }
    public Payroll(long prId, Staff staff, Teacher teacher, BigDecimal amount, String prType, Date prDate) {
       this.prId = prId;
       this.staff = staff;
       this.teacher = teacher;
       this.amount = amount;
       this.prType = prType;
       this.prDate = prDate;
    }
   
    public long getPrId() {
        return this.prId;
    }
    
    public void setPrId(long prId) {
        this.prId = prId;
    }
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getPrType() {
        return this.prType;
    }
    
    public void setPrType(String prType) {
        this.prType = prType;
    }
    public Date getPrDate() {
        return this.prDate;
    }
    
    public void setPrDate(Date prDate) {
        this.prDate = prDate;
    }




}


