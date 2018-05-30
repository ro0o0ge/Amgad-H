/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdo
 */
@Entity
@Table(name = "teacher_subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherSubjects.findAll", query = "SELECT t FROM TeacherSubjects t")
    ,@NamedQuery(name = "TeacherSubjects.deleteByTID", query = "DELETE  FROM TeacherSubjects t where t.tId = :tId")
    , @NamedQuery(name = "TeacherSubjects.findByTSID", query = "SELECT t FROM TeacherSubjects t WHERE t.tSID = :tSID")})
public class TeacherSubjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tS_ID")
    private Integer tSID;
    @JoinColumn(name = "SU_ID", referencedColumnName = "SU_ID")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Subjects suId;
    @JoinColumn(name = "T_ID", referencedColumnName = "T_ID")
    @ManyToOne(optional = false)
    private Teacher tId;

    public TeacherSubjects() {
    }

    public TeacherSubjects(Integer tSID) {
        this.tSID = tSID;
    }

    public Integer getTSID() {
        return tSID;
    }

    public void setTSID(Integer tSID) {
        this.tSID = tSID;
    }

    public Subjects getSuId() {
        return suId;
    }

    public void setSuId(Subjects suId) {
        this.suId = suId;
    }

    public Teacher getTId() {
        return tId;
    }

    public void setTId(Teacher tId) {
        this.tId = tId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tSID != null ? tSID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherSubjects)) {
            return false;
        }
        TeacherSubjects other = (TeacherSubjects) object;
        if ((this.tSID == null && other.tSID != null) || (this.tSID != null && !this.tSID.equals(other.tSID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TeacherSubjects[ tSID=" + tSID + " ]";
    }

}
