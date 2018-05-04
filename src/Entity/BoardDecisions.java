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
@Table(name = "board_decisions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoardDecisions.findAll", query = "SELECT b FROM BoardDecisions b")
    , @NamedQuery(name = "BoardDecisions.findByBdId", query = "SELECT b FROM BoardDecisions b WHERE b.bdId = :bdId")
    , @NamedQuery(name = "BoardDecisions.findByTitle", query = "SELECT b FROM BoardDecisions b WHERE b.title = :title")
    , @NamedQuery(name = "BoardDecisions.findByBody", query = "SELECT b FROM BoardDecisions b WHERE b.body = :body")
    , @NamedQuery(name = "BoardDecisions.findByDDate", query = "SELECT b FROM BoardDecisions b WHERE b.dDate = :dDate")})
public class BoardDecisions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BD_ID")
    private Integer bdId;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "BODY")
    private String body;
    @Basic(optional = false)
    @Column(name = "D_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dDate;

    public BoardDecisions() {
    }

    public BoardDecisions(Integer bdId) {
        this.bdId = bdId;
    }

    public BoardDecisions(Integer bdId, String title, String body, Date dDate) {
        this.bdId = bdId;
        this.title = title;
        this.body = body;
        this.dDate = dDate;
    }

    public Integer getBdId() {
        return bdId;
    }

    public void setBdId(Integer bdId) {
        this.bdId = bdId;
    }

    public String getTitle() {
        return title;
    }
    
    public StringProperty TitleProperty() {
        return new SimpleStringProperty(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDDate() {
        return dDate;
    }
    
    public StringProperty DDateProperty() {
        return new SimpleStringProperty(dDate.toString());
    }

    public void setDDate(Date dDate) {
        this.dDate = dDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bdId != null ? bdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BoardDecisions)) {
            return false;
        }
        BoardDecisions other = (BoardDecisions) object;
        if ((this.bdId == null && other.bdId != null) || (this.bdId != null && !this.bdId.equals(other.bdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BoardDecisions[ bdId=" + bdId + " ]";
    }
    
}
