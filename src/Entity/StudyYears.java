package Entity;
// Generated Mar 23, 2018 2:53:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * StudyYears generated by hbm2java
 */
public class StudyYears  implements java.io.Serializable {


     private int syId;
     private String syDesc;
     private Set subjectses = new HashSet(0);

    public StudyYears() {
    }

	
    public StudyYears(int syId, String syDesc) {
        this.syId = syId;
        this.syDesc = syDesc;
    }
    public StudyYears(int syId, String syDesc, Set subjectses) {
       this.syId = syId;
       this.syDesc = syDesc;
       this.subjectses = subjectses;
    }
   
    public int getSyId() {
        return this.syId;
    }
    
    public void setSyId(int syId) {
        this.syId = syId;
    }
    public String getSyDesc() {
        return this.syDesc;
    }
    
    public void setSyDesc(String syDesc) {
        this.syDesc = syDesc;
    }
    public Set getSubjectses() {
        return this.subjectses;
    }
    
    public void setSubjectses(Set subjectses) {
        this.subjectses = subjectses;
    }




}

