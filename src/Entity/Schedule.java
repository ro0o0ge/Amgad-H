package Entity;
// Generated Mar 23, 2018 2:53:57 PM by Hibernate Tools 4.3.1



/**
 * Schedule generated by hbm2java
 */
public class Schedule  implements java.io.Serializable {


     private ScheduleId id;
     private Classes classes;
     private LectureDatetime lectureDatetime;
     private Subjects subjects;
     private Teacher teacher;

    public Schedule() {
    }

    public Schedule(ScheduleId id, Classes classes, LectureDatetime lectureDatetime, Subjects subjects, Teacher teacher) {
       this.id = id;
       this.classes = classes;
       this.lectureDatetime = lectureDatetime;
       this.subjects = subjects;
       this.teacher = teacher;
    }
   
    public ScheduleId getId() {
        return this.id;
    }
    
    public void setId(ScheduleId id) {
        this.id = id;
    }
    public Classes getClasses() {
        return this.classes;
    }
    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }
    public LectureDatetime getLectureDatetime() {
        return this.lectureDatetime;
    }
    
    public void setLectureDatetime(LectureDatetime lectureDatetime) {
        this.lectureDatetime = lectureDatetime;
    }
    public Subjects getSubjects() {
        return this.subjects;
    }
    
    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }
    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }




}

