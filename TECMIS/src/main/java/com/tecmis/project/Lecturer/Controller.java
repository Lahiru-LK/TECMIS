package com.tecmis.project.Lecturer;
import java.util.Date;


public class Controller {

    private String Attendance_id;
    private String user_id;
    private String Subject_id;


    private String State;
    private Date Date;

    public Controller(String user_id, String subject_id, String state, java.util.Date date) {
        this.user_id = user_id;
        Subject_id = subject_id;
        State = state;
        Date = date;
    }

    public String getAttendance_id() {
        return Attendance_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getSubject_id() {
        return Subject_id;
    }

    public String getState() {
        return State;
    }

    public java.util.Date getDate() {
        return Date;
    }
}
