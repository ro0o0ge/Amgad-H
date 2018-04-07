package Entity;
// Generated Mar 23, 2018 2:53:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SchoolExpenses generated by hbm2java
 */
public class SchoolExpenses  implements java.io.Serializable {


     private long sceId;
     private BigDecimal amount;
     private String sceType;
     private Date sceDate;
     private String issuedBy;

    public SchoolExpenses() {
    }

    public SchoolExpenses(long sceId, BigDecimal amount, String sceType, Date sceDate, String issuedBy) {
       this.sceId = sceId;
       this.amount = amount;
       this.sceType = sceType;
       this.sceDate = sceDate;
       this.issuedBy = issuedBy;
    }
   
    public long getSceId() {
        return this.sceId;
    }
    
    public void setSceId(long sceId) {
        this.sceId = sceId;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getSceType() {
        return this.sceType;
    }
    
    public void setSceType(String sceType) {
        this.sceType = sceType;
    }
    public Date getSceDate() {
        return this.sceDate;
    }
    
    public void setSceDate(Date sceDate) {
        this.sceDate = sceDate;
    }
    public String getIssuedBy() {
        return this.issuedBy;
    }
    
    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }




}


