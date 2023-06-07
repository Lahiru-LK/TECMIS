package com.tecmis.project.Technical_Officer.Attendence;

import java.sql.Date;

public class attendenceController {

    private String Attendence_id;

    private String user_id;

    private String Subject_id;

    private int Hours;

    private String State;

    private Date Date;

    public attendenceController(String Attendence_id, String user_id, String Subject_id, int Hours, String State, java.sql.Date Date) {
       this.Attendence_id = Attendence_id;
        this.user_id = user_id;
        this.Subject_id = Subject_id;
        this.Hours = Hours;
        this.State = State;
        this.Date = Date;
    }

    public String getAttendence_id() {
        return Attendence_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getSubject_id() {
        return Subject_id;
    }

    public int getHours() {
        return Hours;
    }

    public String getState() {
        return State;
    }

    public java.sql.Date getDate() {
        return Date;
    }
}
