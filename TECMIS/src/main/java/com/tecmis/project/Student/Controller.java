package com.tecmis.project.Student;

import java.util.Date;

public class Controller {


    private String Attendence_id;
    private String user_id;
    private String Subject_id;
    private Integer Hours;

    private String State;
    private Date Date;

    public Controller(String attendence_id, String user_id, String subject_id, Integer hours, String state, java.util.Date date) {
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

    public Integer getHours() {
        return Hours;
    }

    public String getState() {
        return State;
    }

    public java.util.Date getDate() {
        return Date;
    }
}



