package pills.entity;
// Generated Oct 19, 2016 12:51:53 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Alternative generated by hbm2java
 */

@Entity
@Table(name="alternative"
    ,catalog="pillreminder"
    , uniqueConstraints = @UniqueConstraint(columnNames={"pill_id", "alternate_pill_id"}) 
)
public class Alternative  implements java.io.Serializable {


     private Integer altId;
     private Pill pillByPillId;
     private Pill pillByAlternatePillId;

    public Alternative() {
    }

    public Alternative(Pill pillByPillId, Pill pillByAlternatePillId) {
       this.pillByPillId = pillByPillId;
       this.pillByAlternatePillId = pillByAlternatePillId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="alt_id", unique=true, nullable=false)
    public Integer getAltId() {
        return this.altId;
    }
    
    public void setAltId(Integer altId) {
        this.altId = altId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pill_id", nullable=false)
    public Pill getPillByPillId() {
        return this.pillByPillId;
    }
    
    public void setPillByPillId(Pill pillByPillId) {
        this.pillByPillId = pillByPillId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="alternate_pill_id", nullable=false)
    public Pill getPillByAlternatePillId() {
        return this.pillByAlternatePillId;
    }
    
    public void setPillByAlternatePillId(Pill pillByAlternatePillId) {
        this.pillByAlternatePillId = pillByAlternatePillId;
    }




}

