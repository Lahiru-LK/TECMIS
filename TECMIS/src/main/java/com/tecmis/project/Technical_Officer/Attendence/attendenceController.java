package com.tecmis.project.Technical_Officer.Attendence;

import java.sql.Date;

public class attendenceController {

    private String Attendence_id;

    private String user_id;

    private String Subject_id;

    private int Hours;

    private String State;

    private Date Date;

    public attendenceController(String attendence_id, String user_id, String subject_id, int hours, String state, java.sql.Date date) {
        Attendence_id = attendence_id;
        this.user_id = user_id;
        Subject_id = subject_id;
        Hours = hours;
        State = state;
        Date = date;
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
