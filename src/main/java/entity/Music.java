package entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Calendar;
import java.util.Date;

@Entity
public class Music {
    @Id
    private long id;
    @Index
    private String name;
    @Index
    private String artist;
    @Index
    private int status;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public Music() {
        this.id = Calendar.getInstance().getTimeInMillis();
        this.status = Status.active.getValue(); //1 active, 0 deactive, -1 delete;
        this.createdAt=Calendar.getInstance().getTime();
    }
    public enum Status{
        active(1),deactive(0),detele(-1);
        int value;
        Status(int value){
            this.value =value;
        }
        public int getValue(){
            return value;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
