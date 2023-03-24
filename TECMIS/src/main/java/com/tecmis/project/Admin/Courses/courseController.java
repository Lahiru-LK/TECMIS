package com.tecmis.project.Admin.Courses;

import java.util.Date;

public class courseController {


    private String course_id;
    private String description;
    private String degree;
    private Date date;

    public courseController(String course_id, String description, String degree, Date date) {
        this.course_id = course_id;
        this.description = description;
        this.degree = degree;
        this.date = date;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getDescription() {
        return description;
    }

    public String getDegree() {
        return degree;
    }
    public Date getDate() {
        return date;
    }
}
