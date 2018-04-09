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
@Table(name = "staff_classes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffClasses.findAll", query = "SELECT s FROM StaffClasses s")
    , @NamedQuery(name = "StaffClasses.findByStcID", query = "SELECT s FROM StaffClasses s WHERE s.stcID = :stcID")})
public class StaffClasses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "stc_ID")
    private Integer stcID;
    @JoinColumn(name = "ST_ID", referencedColumnName = "ST_ID")
    @ManyToOne(optional = false)
    private Staff stId;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
    @ManyToOne(optional = false)
    private Classes cId;

    public StaffClasses() {
    }

    public StaffClasses(Integer stcID) {
        this.stcID = stcID;
    }

    public Integer getStcID() {
        return stcID;
    }

    public void setStcID(Integer stcID) {
        this.stcID = stcID;
    }

    public Staff getStId() {
        return stId;
    }

    public void setStId(Staff stId) {
        this.stId = stId;
    }

    public Classes getCId() {
        return cId;
    }

    public void setCId(Classes cId) {
        this.cId = cId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stcID != null ? stcID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffClasses)) {
            return false;
        }
        StaffClasses other = (StaffClasses) object;
        if ((this.stcID == null && other.stcID != null) || (this.stcID != null && !this.stcID.equals(other.stcID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StaffClasses[ stcID=" + stcID + " ]";
    }
    
}
