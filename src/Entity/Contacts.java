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
@Table(name = "contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c")
    , @NamedQuery(name = "Contacts.findByCId", query = "SELECT c FROM Contacts c WHERE c.cId = :cId")
    , @NamedQuery(name = "Contacts.findByConName", query = "SELECT c FROM Contacts c WHERE c.conName = :conName")
    , @NamedQuery(name = "Contacts.findByConDeatails", query = "SELECT c FROM Contacts c WHERE c.conDeatails = :conDeatails")})
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "C_ID")
    private Long cId;
    @Basic(optional = false)
    @Column(name = "CON_NAME")
    private String conName;
    @Basic(optional = false)
    @Column(name = "CON_DEATAILS")
    private String conDeatails;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne(optional = false)
    private Persons pId;

    public Contacts() {
    }

    public Contacts(Long cId) {
        this.cId = cId;
    }

    public Contacts(Long cId, String conName, String conDeatails) {
        this.cId = cId;
        this.conName = conName;
        this.conDeatails = conDeatails;
    }

    public Long getCId() {
        return cId;
    }

    public void setCId(Long cId) {
        this.cId = cId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConDeatails() {
        return conDeatails;
    }

    public void setConDeatails(String conDeatails) {
        this.conDeatails = conDeatails;
    }

    public Persons getPId() {
        return pId;
    }

    public void setPId(Persons pId) {
        this.pId = pId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Contacts[ cId=" + cId + " ]";
    }
    
}
