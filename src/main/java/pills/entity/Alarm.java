package pills.entity;
// Generated Oct 18, 2016 11:30:11 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Alarm generated by hbm2java
 */
@Entity
@Table(name="alarm"
    ,catalog="pillreminder"
)
public class Alarm  implements java.io.Serializable {


     private Integer AId;
     private User user;
     private int APillId;
     private Date AStartDate;
     private Date AEndDate;
     private int ARecurrence;

    public Alarm() {
    }

	
    public Alarm(User user, int APillId, int ARecurrence) {
        this.user = user;
        this.APillId = APillId;
        this.ARecurrence = ARecurrence;
    }
    public Alarm(User user, int APillId, Date AStartDate, Date AEndDate, int ARecurrence) {
       this.user = user;
       this.APillId = APillId;
       this.AStartDate = AStartDate;
       this.AEndDate = AEndDate;
       this.ARecurrence = ARecurrence;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="a_id", unique=true, nullable=false)
    public Integer getAId() {
        return this.AId;
    }
    
    public void setAId(Integer AId) {
        this.AId = AId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="a_user_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="a_pill_id", nullable=false)
    public int getAPillId() {
        return this.APillId;
    }
    
    public void setAPillId(int APillId) {
        this.APillId = APillId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="a_start_date", length=10)
    public Date getAStartDate() {
        return this.AStartDate;
    }
    
    public void setAStartDate(Date AStartDate) {
        this.AStartDate = AStartDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="a_end_date", length=10)
    public Date getAEndDate() {
        return this.AEndDate;
    }
    
    public void setAEndDate(Date AEndDate) {
        this.AEndDate = AEndDate;
    }

    
    @Column(name="a_recurrence", nullable=false)
    public int getARecurrence() {
        return this.ARecurrence;
    }
    
    public void setARecurrence(int ARecurrence) {
        this.ARecurrence = ARecurrence;
    }




}


