/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "student_notes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentNotes.findAll", query = "SELECT s FROM StudentNotes s")
    , @NamedQuery(name = "StudentNotes.findByNDesc", query = "SELECT s FROM StudentNotes s WHERE s.nDesc = :nDesc")
    , @NamedQuery(name = "StudentNotes.findByNDate", query = "SELECT s FROM StudentNotes s WHERE s.nDate = :nDate")
    , @NamedQuery(name = "StudentNotes.findByNId", query = "SELECT s FROM StudentNotes s WHERE s.nId = :nId")})
public class StudentNotes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "N_DESC")
    private String nDesc;
    @Basic(optional = false)
    @Column(name = "N_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "N_ID")
    private Long nId;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID")
    @ManyToOne
    private Student sId;

    public StudentNotes() {
    }

    public StudentNotes(Long nId) {
        this.nId = nId;
    }

    public StudentNotes(Long nId, Date nDate) {
        this.nId = nId;
        this.nDate = nDate;
    }

    public String getNDesc() {
        return nDesc;
    }

    public void setNDesc(String nDesc) {
        this.nDesc = nDesc;
    }

    public Date getNDate() {
        return nDate;
    }

    public void setNDate(Date nDate) {
        this.nDate = nDate;
    }

    public Long getNId() {
        return nId;
    }

    public void setNId(Long nId) {
        this.nId = nId;
    }

    public Student getSId() {
        return sId;
    }

    public void setSId(Student sId) {
        this.sId = sId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nId != null ? nId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentNotes)) {
            return false;
        }
        StudentNotes other = (StudentNotes) object;
        if ((this.nId == null && other.nId != null) || (this.nId != null && !this.nId.equals(other.nId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StudentNotes[ nId=" + nId + " ]";
    }
    
}
