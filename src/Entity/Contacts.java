package Entity;
// Generated Mar 23, 2018 2:53:57 PM by Hibernate Tools 4.3.1



/**
 * Contacts generated by hbm2java
 */
public class Contacts  implements java.io.Serializable {


     private long CId;
     private Persons persons;
     private String conName;
     private String conDeatails;

    public Contacts() {
    }

    public Contacts(long CId, Persons persons, String conName, String conDeatails) {
       this.CId = CId;
       this.persons = persons;
       this.conName = conName;
       this.conDeatails = conDeatails;
    }
   
    public long getCId() {
        return this.CId;
    }
    
    public void setCId(long CId) {
        this.CId = CId;
    }
    public Persons getPersons() {
        return this.persons;
    }
    
    public void setPersons(Persons persons) {
        this.persons = persons;
    }
    public String getConName() {
        return this.conName;
    }
    
    public void setConName(String conName) {
        this.conName = conName;
    }
    public String getConDeatails() {
        return this.conDeatails;
    }
    
    public void setConDeatails(String conDeatails) {
        this.conDeatails = conDeatails;
    }




}


