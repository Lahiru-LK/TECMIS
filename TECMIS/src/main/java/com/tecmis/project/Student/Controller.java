package com.tecmis.project.Student;

public class Controller {


    private String CourseCode;
    private String user_id;
    private String State;
    private String Date;

    public Controller(String courseCode, String user_id, String state, String date) {
        this.CourseCode = courseCode;
        this.user_id = user_id;
        this.State = state;
        this.Date = date;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getState() {
        return State;
    }

    public String getDate() {
        return Date;
    }
}



