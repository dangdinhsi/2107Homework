package entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Calendar;

@Entity
public class Student {
    @Id
    private long id;
    @Index
    private String username;
    @Index
    private String rollnumber;
    @Index
    private int status;

    public Student() {
        this.id= Calendar.getInstance().getTimeInMillis();
        this.status =Status.active.getValue();
    }

    public Student(long id, String username, String rollnumber, int status) {
        this.id = id;
        this.username = username;
        this.rollnumber = rollnumber;
        this.status = status;
    }

    public enum Status{
        active(1),deactive(0),delete(-1);
        int value;
        Status( int value){
            this.value=value;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }
}
