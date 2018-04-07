package Entity;
// Generated Mar 23, 2018 2:53:57 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * StudentNotes generated by hbm2java
 */
public class StudentNotes  implements java.io.Serializable {


     private long NId;
     private Student student;
     private String NDesc;
     private Date NDate;

    public StudentNotes() {
    }

	
    public StudentNotes(long NId, Date NDate) {
        this.NId = NId;
        this.NDate = NDate;
    }
    public StudentNotes(long NId, Student student, String NDesc, Date NDate) {
       this.NId = NId;
       this.student = student;
       this.NDesc = NDesc;
       this.NDate = NDate;
    }
   
    public long getNId() {
        return this.NId;
    }
    
    public void setNId(long NId) {
        this.NId = NId;
    }
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    public String getNDesc() {
        return this.NDesc;
    }
    
    public void setNDesc(String NDesc) {
        this.NDesc = NDesc;
    }
    public Date getNDate() {
        return this.NDate;
    }
    
    public void setNDate(Date NDate) {
        this.NDate = NDate;
    }




}


