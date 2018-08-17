/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e")
    , @NamedQuery(name = "Evaluation.findByEvaId", query = "SELECT e FROM Evaluation e WHERE e.evaId = :evaId")
        , @NamedQuery(name = "Evaluation.findByPId", query = "SELECT e FROM Evaluation e WHERE e.pid = :pId")
    , @NamedQuery(name = "Evaluation.findByEvaDate", query = "SELECT e FROM Evaluation e WHERE e.evaDate = :evaDate")
    , @NamedQuery(name = "Evaluation.findByLateness", query = "SELECT e FROM Evaluation e WHERE e.lateness = :lateness")
    , @NamedQuery(name = "Evaluation.findByPenaleties", query = "SELECT e FROM Evaluation e WHERE e.penaleties = :penaleties")
    , @NamedQuery(name = "Evaluation.findByCllaboration", query = "SELECT e FROM Evaluation e WHERE e.cllaboration = :cllaboration")
    , @NamedQuery(name = "Evaluation.findByStudentTreatment", query = "SELECT e FROM Evaluation e WHERE e.studentTreatment = :studentTreatment")
    , @NamedQuery(name = "Evaluation.findByPersonality", query = "SELECT e FROM Evaluation e WHERE e.personality = :personality")
    , @NamedQuery(name = "Evaluation.findByTechLvl", query = "SELECT e FROM Evaluation e WHERE e.techLvl = :techLvl")
    , @NamedQuery(name = "Evaluation.findByInfoExplaination", query = "SELECT e FROM Evaluation e WHERE e.infoExplaination = :infoExplaination")
    , @NamedQuery(name = "Evaluation.findByAbsence", query = "SELECT e FROM Evaluation e WHERE e.absence = :absence")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVA_ID")
    private Integer evaId;
    @Column(name = "EVA_DATE")
    @Temporal(TemporalType.DATE)
    private Date evaDate;
    @Column(name = "LATENESS")
    private String lateness;
    @Column(name = "PENALETIES")
    private String penaleties;
    @Column(name = "CLLABORATION")
    private String cllaboration;
    @Column(name = "STUDENT_TREATMENT")
    private String studentTreatment;
    @Column(name = "PERSONALITY")
    private String personality;
    @Column(name = "TECH_LVL")
    private String techLvl;
    @Column(name = "INFO_EXPLAINATION")
    private String infoExplaination;
    @Column(name = "ABSENCE")
    private String absence;
    @JoinColumn(name = "PID", referencedColumnName = "P_ID")
    @ManyToOne
    private Persons pid;

    public Evaluation() {
    }

    public Evaluation(Integer evaId) {
        this.evaId = evaId;
    }

    public Integer getEvaId() {
        return evaId;
    }

    public void setEvaId(Integer evaId) {
        this.evaId = evaId;
    }

    public Date getEvaDate() {
        return evaDate;
    }
    public StringProperty DateProperty() {
        return new SimpleStringProperty(evaDate.toString());
    }

    public void setEvaDate(Date evaDate) {
        this.evaDate = evaDate;
    }

    public String getLateness() {
        return lateness;
    }
    
    public StringProperty LateProperty() {
        return new SimpleStringProperty(lateness);
    }

    public void setLateness(String lateness) {
        this.lateness = lateness;
    }

    public String getPenaleties() {
        return penaleties;
    }
    
    public StringProperty PenaltyProperty() {
        return new SimpleStringProperty(penaleties);
    }

    public void setPenaleties(String penaleties) {
        this.penaleties = penaleties;
    }

    public String getCllaboration() {
        return cllaboration;
    }
    public StringProperty CollaborationProperty() {
        return new SimpleStringProperty(cllaboration);
    }

    public void setCllaboration(String cllaboration) {
        this.cllaboration = cllaboration;
    }

    public String getStudentTreatment() {
        return studentTreatment;
    }
    
    public StringProperty StudentTreatmentProperty() {
        return new SimpleStringProperty(studentTreatment);
    }

    public void setStudentTreatment(String studentTreatment) {
        this.studentTreatment = studentTreatment;
    }

    public String getPersonality() {
        return personality;
    }
    
    public StringProperty PersonalityProperty() {
        return new SimpleStringProperty(personality);
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getTechLvl() {
        return techLvl;
    }
    
    public StringProperty TechLvlProperty() {
        return new SimpleStringProperty(techLvl);
    }

    public void setTechLvl(String techLvl) {
        this.techLvl = techLvl;
    }

    public String getInfoExplaination() {
        return infoExplaination;
    }
    
    public StringProperty InfoExplainationProperty() {
        return new SimpleStringProperty(infoExplaination);
    }

    public void setInfoExplaination(String infoExplaination) {
        this.infoExplaination = infoExplaination;
    }

    public String getAbsence() {
        return absence;
    }
    
    public StringProperty AbsenceProperty() {
        return new SimpleStringProperty(absence);
    }

    public void setAbsence(String absence) {
        this.absence = absence;
    }

    public Persons getPid() {
        return pid;
    }

    public void setPid(Persons pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaId != null ? evaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.evaId == null && other.evaId != null) || (this.evaId != null && !this.evaId.equals(other.evaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Evaluation[ evaId=" + evaId + " ]";
    }
    
}
