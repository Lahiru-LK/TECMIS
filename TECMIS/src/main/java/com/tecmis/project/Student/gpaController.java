package com.tecmis.project.Student;

public class gpaController {
    private String course_id;
    private String course;
    private String Grade;

    public gpaController(String course_id, String course, String Grade) {
        this.course_id = course_id;
        this.course = course;
        this.Grade = Grade;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getCourse() {
        return course;
    }

    public String getGrade() {
        return Grade;
    }
}
